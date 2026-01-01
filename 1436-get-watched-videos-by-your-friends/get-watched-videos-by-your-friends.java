class Pair{
    String video;
    int freq;

    public Pair(String video, int freq){
        this.video = video;
        this.freq = freq;
    }
}

class VideoComparator implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        int val = a.freq - b.freq;

        if(val == 0)
            return a.video.compareTo(b.video);
        
        return val;
    }
}

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<friends.length;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<friends.length;i++){
            for(int j=0;j<friends[i].length;j++){
                adj.get(i).add(friends[i][j]);
                adj.get(friends[i][j]).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        HashSet<Integer> set = new HashSet<>();
        set.add(id);

        int currLevel = 0;

        HashMap<String, Integer> map = new HashMap<>();

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int node = q.poll();

                if(currLevel == level){
                    for(String video: watchedVideos.get(node))
                        map.put(video, map.getOrDefault(video, 0) + 1);
                }

                for(int adjNode: adj.get(node)){
                    if(!set.contains(adjNode)){
                        q.offer(adjNode);
                        set.add(adjNode);
                    }
                }
            }

            if(currLevel == level)
                break;
            
            currLevel++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new VideoComparator());

        for(String key: map.keySet()){
            pq.offer(new Pair(key, map.get(key)));
        }

        List<String> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            ans.add(pq.poll().video);
        }

        return ans;
    }
}
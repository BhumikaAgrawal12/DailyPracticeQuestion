class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
       int n=deck.length;
       ArrayDeque<Integer>q=new ArrayDeque<>();
       for(int i=0;i<n;i++){
            q.add(i);
       }
       Arrays.sort(deck);
       int[] res=new int[n];
       int k=0;
       while(!q.isEmpty()){
            int ind=q.poll();
            res[ind]=deck[k++];
            if(!q.isEmpty()){
                int indx=q.poll();
                q.add(indx);
            }

       }
       return res;
    }
}
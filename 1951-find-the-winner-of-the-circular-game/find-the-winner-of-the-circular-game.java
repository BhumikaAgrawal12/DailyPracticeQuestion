class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        int i=1;
        while(q.size()!=1){
            int val=q.poll();
            if(i==k){
                i=0;
            }
            else{
                q.add(val);
            }
            i++;
        }
        return q.poll();
    }
}
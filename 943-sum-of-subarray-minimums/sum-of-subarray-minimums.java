class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        ArrayDeque<Integer>st=new ArrayDeque<>();
        int[] pse=new int[n];
        int[] nse=new int[n];
        Arrays.fill(pse,-1);
        Arrays.fill(nse,n);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nse[i]=st.peek();
            }
            st.push(i);
        }
        long ans=0;
        long mod=(int)1e9+7;
        for(int i=0;i<arr.length;i++){
            ans=(ans+(long)(i-pse[i])*(nse[i]-i)%mod*arr[i]%mod)%mod;
        }
        return (int)ans;
    }
}
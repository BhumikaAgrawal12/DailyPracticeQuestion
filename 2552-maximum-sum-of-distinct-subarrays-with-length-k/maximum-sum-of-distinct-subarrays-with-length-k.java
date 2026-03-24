class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int n=arr.length;
        int i=0;
        int j=0;
        long sum=0;
        long maxSum=0;
        Set<Integer> set=new HashSet<>();
        while(j<n){
            while(set.contains(arr[j])){
                set.remove(arr[i]);
                sum-=arr[i];
                i++;
            }
            set.add(arr[j]);
            sum+=arr[j];
            if(j-i+1==k){
                maxSum=Math.max(sum,maxSum);
                sum-=arr[i];
                set.remove(arr[i]);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
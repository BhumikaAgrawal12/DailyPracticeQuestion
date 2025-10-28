// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int n=nums1.length;
//         int m=nums2.length;
//         int[] temp=new int[m];
//         int[] res=new int[n];
//         ArrayDeque<Integer>st=new ArrayDeque<>();
//         for(int i=m-1;i>=0;i--){
//             while(!st.isEmpty() && st.peek()<=nums2[i]){
//                 st.pop();
//             }
//             if(st.isEmpty()){
//                 temp[i]=-1;
//             }
//             else{
//                 temp[i]=st.peek();
//             }
//             st.push(nums2[i]);
//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(nums1[i]==nums2[j]){
//                     res[i]=temp[j];
//                     break;
//                 }
//             }
//         }
//         return res;
//    }
// }

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer>st=new ArrayDeque<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        int[] res=new int[nums1.length];
        for(int num:nums2){
            while(!st.isEmpty() && num>st.peek()){
                map.put(st.pop(),num);
            }
            st.push(num);
        }
        int i=0;
        for(int num:nums1){
            res[i]=map.getOrDefault(num,-1);
            i++;
        }
        return res;
    }
}
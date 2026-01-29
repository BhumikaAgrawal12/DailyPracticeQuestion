class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0;
        int i=0;
        int j=0;
        int m=nums1.length;
        int n=nums2.length;
        int[] temp=new int[m+n];
        int c=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                temp[c++]=nums1[i++];
            }
            else{
                temp[c++]=nums2[j++];
            }
        }
        while(i<m){
            temp[c++]=nums1[i++];
        }
        while(j<n){
            temp[c++]=nums2[j++];
        }
        // for(int s=0;s<temp.length;s++){
        //     System.out.print(temp[s]+" ");
        // }

        int len=m+n;
        if(len%2!=0){
            ans=temp[len/2];
        }
        else{
            ans=(double)(temp[len/2]+temp[(len/2)-1])/2;
        }
        return ans;
    }
}
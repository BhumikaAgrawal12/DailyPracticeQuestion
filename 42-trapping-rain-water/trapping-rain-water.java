class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,height[i]);
            leftMax[i]=max;
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            rightMax[i]=max;
        }
        int area=0;
        for(int i=0;i<n;i++){
            area+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return area;
    }
}
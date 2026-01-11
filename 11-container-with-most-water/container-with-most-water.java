class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        int s=0;
        int e=height.length-1;
        int area=1;
        while(s<e){
            if(height[s]<height[e]){
                area=height[s]*(e-s);
                maxArea=Math.max(maxArea,area);
                s++;
            }
            else{
                area=height[e]*(e-s);
                maxArea=Math.max(maxArea,area);
                e--;
            }
        }
        return maxArea;
    }
}
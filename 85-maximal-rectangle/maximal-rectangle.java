class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0;
        int[] histogram=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    histogram[j]++;
                }
                else{
                    histogram[j]=0;
                }
            }
            ans=Math.max(ans,largestAreaOfHistogram(histogram));
        }
        return ans;
    }
    int largestAreaOfHistogram(int[] heights){
        int n=heights.length;
        int[] prevSmaller=new int[n];
        int[] nextSmaller=new int[n];
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            prevSmaller[i]=st.peek();
            st.push(i);
        }

        st.clear();
        st.push(-1);
        for(int i=n-1;i>=0;i--){
            while(st.peek()!=-1 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nextSmaller[i]=st.peek()==-1?n:st.peek();
            st.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int height=heights[i];
            int width=nextSmaller[i]-prevSmaller[i]-1;
            maxArea=Math.max(maxArea,height*width);
        }
        return maxArea;
    }

}
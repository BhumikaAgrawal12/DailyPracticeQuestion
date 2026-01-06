////USING DP/////
class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        else if(n==1||n==2){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];

    }
}
//T.C=O(n)
//S.C=O(n)

/////USING MAP////
// class Solution {
//     public int tribo(int n,Map<Integer,Integer>map) {
//         if(n==0){
//             return 0;
//         }
//         else if(n==1||n==2){
//             return 1;
//         }
//         else if(map.containsKey(n)){
//             return map.get(n);
//         }
//         int a=tribo(n-1,map)+tribo(n-2,map)+tribo(n-3,map);
//         map.put(n,a);
//         return a;
//     }
//     public int tribonacci(int n) {
//         Map<Integer,Integer>map=new HashMap<>();
//         return tribo(n,map);
//     }
// }
// //T.C=O(n)
// //S.C=O(n)


// ///USING MAP(Another method)////
// class Solution {
//     public int tribonacci(int n) {
//         Map<Integer,Integer>map=new HashMap<>();
//         map.put(0,0);
//         map.put(1,1);
//         map.put(2,1);
//         for(int i=3;i<=n;i++){
//             map.put(i,(map.get(i-1)+map.get(i-2)+map.get(i-3)));
//         }
//         return map.get(n);
//     }
// }
// //T.C=O(n)
// //S.C=O(n)

// ////Using Array////
// class Solution {
//     public int tribo(int n,int[] arr) {
//         if(n==0){
//             return 0;
//         }
//         else if(n==1||n==2){
//             return 1;
//         }
//         else if(arr[n]!=0){
//             return arr[n];
//         }
//         int a=tribo(n-1,arr)+tribo(n-2,arr)+tribo(n-3,arr);
//         arr[n]=a;
//         return a;
//     }
//     public int tribonacci(int n) {
//         int[] arr=new int[n+1];
//         return tribo(n,arr);
//     }
// }
// //T.C=O(n)
// //S.C=O(n)


// ////USING RECURSION AND BACKTRACKING/////
// class Solution {
//     public int tribonacci(int n) {
//          if(n==0){
//             return 0;
//         }
//         else if(n==1||n==2){
//             return 1;
//         }
//         else{
//             return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
//         }
//     }
// }
// //T.C=O(3^n)
// //S.C=O(n)








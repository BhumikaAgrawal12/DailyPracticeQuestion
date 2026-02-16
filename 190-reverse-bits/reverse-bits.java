class Solution {
    public int reverseBits(int n) {
        String s=Integer.toBinaryString(n);
        int m=s.length();
        for(int i=0;i<32-m;i++){
            s='0'+s;
        }
        String rev="";
        for(int i=s.length()-1;i>=0;i--){
            rev=rev+s.charAt(i);
        }
        return Integer.parseInt(rev,2);
    }
}

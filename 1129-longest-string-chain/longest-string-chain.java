class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;

        for( int i =0 ; i<n ; i++){
            map.put( words[i] , 1 );
        }

        int max = 0 ;
        for( int i =0 ; i<n ; i++){
            for( int j = 0 ; j<words[i].length() ; j++){
                String s1 = words[i].substring(0,j) + words[i].substring(j+1) ;

                if( map.containsKey(s1) ){
                    map.put(words[i], Math.max(map.get(words[i]), map.get(s1) + 1));
                }
            }
            max = Math.max( max , map.get(words[i]) );
        }
        return max ;
    }
}
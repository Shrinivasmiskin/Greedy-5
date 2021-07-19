//USING DP APPROACH 
class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p) || p.equals('*')) return true;
        int sl = s.length();
        int pl = p.length();
        boolean [][] dp = new boolean[pl + 1][sl + 1];
        dp[0][0] = true;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j > 0 && p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?'){
                    if(j > 0)
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(i - 1) == '*'){
                    if(j == 0){
                        dp[i][j] = dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } 
                }
            }
        }
        return dp[pl][sl];
    }
}
//Time Complexity = O(s*p)
//Space Complexity = O(s*p)


//USING 2 POINTERS APPROACH

class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p) || p.equals('*')) return true;
        int sl = s.length();
        int pl = p.length();
        int sp = 0;
        int pp = 0;
        int sStar = -1;
        int pStar = -1;
        
        while(sp < sl){
            if(pp < pl && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                sp++; pp++;
            }else if(pp < pl && p.charAt(pp) == '*'){
                pStar = pp;
                sStar = sp;
                pp++;
            }else if(pStar == - 1) return false;
            else{
                 sStar++;
                 sp = sStar;
                 pp = pStar + 1;
                 
            }
        }
        while(pp < pl){
            if(p.charAt(pp) != '*') return false;
            pp++;
        }
        return true;
       
    }
}

//Time Complexity = O(min(s, p))
//Space Complexity = O(1)

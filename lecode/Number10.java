package lecode;
public class Number10{
    public boolean match(String s, String p, int i, int j){
        if(i == 0)  return false;
        else if(s.charAt(i-1) == p.charAt(j-1)) return true;
        else if(p.charAt(j-1) == '.') return true;
        else return false;
    }

    public boolean Solution(String s, String p){
        int lens = s.length(), lenp = p.length();
        boolean[][] dp = new boolean[lens][lenp];

        dp[0][0] = true;
        for(int i=0; i<=lens; i++){
            for(int j=1; j<=lenp; j++){
                char cp = p.charAt(j-1);
                if(cp == '*'){
                    if(match(s, p, i, j-1)){
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    } else{
                        dp[i][j] = dp[i][j-2];
                    }
                } else{
                    if(match(s, p, i, j)){
                        dp[i][j] = dp[i-1][j-1];
                    } else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[lens][lenp];
    }
}
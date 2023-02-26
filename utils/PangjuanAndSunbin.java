package utils;

import java.lang.Math;
import java.util.Hashtable;
public class PangjuanAndSunbin {

    public boolean judgeNum(int x){
        for(int i=2; i<=Math.sqrt(x); i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        PangjuanAndSunbin obj = new PangjuanAndSunbin();
        Hashtable<Integer, Integer> dict = new Hashtable<Integer, Integer>();
        // System.out.println(obj.judgeNum(9));
        for(int x=7; x<53; x += 2){
            int i;
            for(i=2; i<=x/2; i++){
                int target = x - i;
                if(obj.judgeNum(i) && obj.judgeNum(target)){
                    break;
                }
            }
            if(i > x/2){
                System.out.println(x);
            }
        }
    }
    
}

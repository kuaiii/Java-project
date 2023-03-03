package lecode;

import java.util.HashMap;
import java.util.Map;

public class Number8 {

    public int nextStatue(char c){
        if(c == ' ')    return 0;
        else if(c == '+' || c == '-') return 1;
        else if(c <= '9' && c >= '0') return 2;
        else return 3;
    }
    public int myAtoi(String s) {
        int x=0, sign=1;
        Map<String, String[]> table = new HashMap<String, String[]>(){
            {
                put("start", new String[]{"start", "signed", "in-number", "end"});
                put("signed", new String[]{"end", "end", "in-number", "end"});
                put("in-number", new String[]{"end", "end", "in-number", "end"});
                put("end", new String[]{"end", "end", "end", "end"});
            }
        };

        String nowStatue = "start";
        for(int i=0; i<s.length(); i++){
            int num = this.nextStatue(s.charAt(i)); //状态
            String statue = table.get(nowStatue)[num];
            if(statue == "signed"){
                if(s.charAt(i) == '-') sign = -1;
            } else if(statue == "in-number"){
                x = 10*x + (s.charAt(i)-'0');
                x = Math.min(x, Integer.MAX_VALUE);
                x = Math.max(x, Integer.MIN_VALUE);
            } else if(statue == "end"){
                break;
            } 
            nowStatue = statue;
        }
        x *= sign;
        System.out.println("最后转化得到的结果为： " + x);
        return x;
    }

    public static void main(String[] args){
        Number8 data = new Number8();
        data.myAtoi(" -111d111dadasd");
    }
}

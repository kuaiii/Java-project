package utils;

public class QuickMultiple{
    
    public long quick(int num, int mul){
        if(mul == 0){
            return 1;
        } else if(mul == 1){
            return num;  
        } else if(mul%2 == 0){
            long temp = this.quick(num, mul/2);
            return temp * temp;
        } else{
            long temp = this.quick(num, mul/2);
            return temp * temp * num;
        }
    }
    public static void main(String[] args){
        int num = 5;
        QuickMultiple x = new QuickMultiple();
        long result = x.quick(num, 3);
        System.out.println(result);

    }
}




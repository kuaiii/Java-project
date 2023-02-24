package utils;

public final class StaticFinal {
    static int x;
    public StaticFinal(int num){
        x = num;
    }
    public static void main(String[] args){
        StaticFinal data1 = new StaticFinal(10);
        System.out.println("静态变量的值为：" + data1.x);
        StaticFinal data2 = new StaticFinal(11);
        System.out.println("静态变量的值为：" + data2.x);
    }
}


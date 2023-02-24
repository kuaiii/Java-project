package utils;

public final class StaticFinal {
    static int x;
    public StaticFinal(int num){
        x = num;
    }
    public int getX(){
        return x;
    }
    public static void main(String[] args){
        System.out.println("静态变量的值为：" + StaticFinal.x);
        StaticFinal data = new StaticFinal(10);
        System.out.println(data.getX());
        System.out.println("静态变量的值为：" + StaticFinal.x);
    }
}


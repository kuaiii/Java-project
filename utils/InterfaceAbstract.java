package utils;

interface UsbFunction{
    public double area = 0;
    public void printShape();
    public double getArea(double x);
    public double getCircumference(double x);
}

public class InterfaceAbstract implements UsbFunction{
    public double area;
    public void printShape(){
        System.out.println("这是一个正方形");
    }
    public double getArea(double x){
        return x*x;
    }
    public double getCircumference(double x){
        return 4*x;
    }
    public static void main(String[] args){
        InterfaceAbstract data = new InterfaceAbstract();
        data.printShape();
        System.out.println("面积: " + data.getArea(10));
        System.out.println("周长: " + data.getCircumference(10));
    }
}

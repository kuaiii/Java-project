package utils;

public class SortMethod{
    private int[] data;

    public SortMethod(){
        this.data = new int[]{5, 3, 1, 2, 8, 4, 10, 7};
    }

    public void bubble(int[] data){
        for(int i=0; i<data.length-1; i++){
            int temp;
            for(int j=0; j<data.length-i-1; j++){
                if(data[j] > data[j+1]){
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }
    public static void main(String[] args){
        SortMethod x = new SortMethod();
        int[] newdata = new int[x.data.length];
        for(int i=0; i<x.data.length; i++){
            newdata[i] = x.data[i];
        }
        // 调用bubble方法
        x.bubble(newdata);
    }
}
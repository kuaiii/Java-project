package utils;

public class SortMethod{
    private int[] data;

    public SortMethod(){
        this.data = new int[]{5, 3, 1, 2, 8, 4, 10, 7, 6};
    }

    public int[] copyInt(int[] data){
        System.out.println("print");
        int[] newdata = new int[data.length];
        for(int i=0; i<data.length; i++){
            newdata[i] = data[i];
        }
        return newdata;
    }

    public void printInt(int[] data){
        for(int i=0; i<data.length; i++){
            System.out.print(data[i] + " ");
        }
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
        System.out.println("\nbubble排序之后的数组排序:");
        printInt(data);
    }
    public void quick(int[] data){
        partition(data, 0, data.length-1);
        System.out.println("quicksort");
        for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }

    public void partition(int[] data, int low, int high){
        if(low < high){
            int posi = this.quickSort(data, low, high);
            this.partition(data, low, posi-1);
            this.partition(data, posi+1, high);
        }
    }

    public int quickSort(int[] data, int low, int high){
        int target = data[low];
        while(low < high){
            while(low < high && data[high] > target) high--;
            data[low] = data[high];
            while(low < high && data[low] < target) low++;
            data[high] = data[low];
        }
        data[low] = target;
        return low;
    }
    public static void main(String[] args){
        SortMethod x = new SortMethod();
        int[] data = new int[]{5, 3, 1, 2, 8, 4, 10, 7, 6};
        System.out.println("数组在修改之前的值: ");;
        // 调用bubble方法
        x.printInt(data);
        //int[] newdata = x.copyInt(x.data);
        x.bubble(data);
        System.out.println("\n数组在修改之后的值：");
        x.printInt(data);
        // newdata = x.copyInt(x.data);
        // x.printInt(newdata);
        // x.quick(newdata);
    }
}
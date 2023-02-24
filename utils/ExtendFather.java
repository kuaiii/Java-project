package utils;


public class ExtendFather {
    public int work_year=5;
    public void calculateYear(){
        work_year = 1;
    }
}

class Teacher extends ExtendFather{
    public int teach_year;
    
    public Teacher(int year){
        teach_year = year;
    }

    public static void main(String[] args){
        // ExtendFather fa = new ExtendFather();
        Teacher te = new Teacher(10);
        System.out.println(te.teach_year+" "+te.work_year);
        te.calculateYear();
        System.out.println(te.work_year);
    }
}
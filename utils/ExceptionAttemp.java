package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionAttemp {
    public int method(){
        File f = new File("d:/LOL.exe");
        try{
            System.out.println("打开文件");
            new FileInputStream(f);
        } catch(FileNotFoundException e){
            System.out.println("打开失败");
            return 1;
        } finally{
            return 3;
        }
    }
    public static void main(String[] args){
        ExceptionAttemp x = new ExceptionAttemp();
        System.out.println(x.method());
    }
}

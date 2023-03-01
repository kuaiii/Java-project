package testCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import testCode.CodeThread;
import testCode.LogThread;

public class TestThread {
    public static boolean flag = false;

    public static String randomString(int length){
        char[] str = new char[length];
        String pool = "";
        for(short i='0'; i<='9'; i++){
            pool += (char)i;
        }
        for(short i='a'; i<='z'; i++){
            pool += (char)i;
        }
        for(short i='A'; i<='Z'; i++){
            pool += (char)i;
        }
        
        for(int i=0; i<length; i++){
            int site = new Random().nextInt(pool.length());
            str[i] = pool.charAt(site);
        }
        return new String(str);
    }

    public static void main(String[] args){
        String password = TestThread.randomString(3);
        List<String> passwords = new ArrayList<>();

        new CodeThread(password, passwords).start();
        new LogThread(passwords).start();
    }
}

package question;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Admin {
    public String common = "12345";
    private StringBuilder password;
    private HashSet<StringBuilder> admin = new HashSet<StringBuilder>();
    //private Stack<StringBuilder> admin = new Stack<>();
    public Admin(){
        Random r = new Random();
        password = new StringBuilder();
        for(int i=0; i<3; i++){
            password.append(common.charAt(r.nextInt(common.length())));
        }
        //System.out.println(password);
    }

    //破解密码的线程
    Thread guessPd = new Thread(new Runnable() {
        public void run(){
            while(true){
                StringBuilder pwd = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    pwd.append(common.charAt(new Random().nextInt(common.length())));
                }
                admin.add(pwd);
                if (pwd == password) {
                    System.out.println("破解成功！");
                    break;
                }
            }
        }
    });

    Thread blog = new Thread(new Runnable() {
        public void run(){
            while(true){
                try{
                    if(admin.isEmpty()){
                        Thread.sleep(1000);
                    } else{
                        guessPd.interrupt();
                        int length = admin.size();
                        int site = new Random().nextInt(length);
                        Iterator iter = admin.iterator();
                        for(int i=0; i<site-1; i++) iter.next();
                        System.out.println(iter.next());
                    }
                } catch(InterruptedException e){
                    e.printStackTrace();
                } catch(ConcurrentModificationException e){
                    e.printStackTrace();
                }
            }
        }
    });

    public static void main(String[] args){
        Admin adm = new Admin();
        adm.guessPd.start();
        //  设置该线程为守护进程
        adm.blog.setDaemon(true);
        adm.blog.start();
        //System.out.format("破解成功密码为%s", adm.password);
    }
}




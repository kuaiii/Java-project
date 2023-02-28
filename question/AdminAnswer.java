package question;

import java.util.Random;
import java.util.Stack;

public class AdminAnswer {
    private boolean flag=false;//判断是否破解成功
    private Stack<StringBuilder> admin=new Stack<>();//创建一个栈存储破解方法生成的随机密码
    private StringBuilder password;//随机的三位生成密码


    {//随机生成三位密码
        Random random = new Random();
        password=new StringBuilder();
        String s="1234567890abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 3; i++) {
            password.append(s.charAt(random.nextInt(s.length())));
        }
    }
    //随机产生密码,与原密码匹配
    Thread getPwd=new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                String s = "1234567890abcdefghijklmnopqrstuvwxyz";
                StringBuilder pwd = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    pwd.append(s.charAt(new Random().nextInt(s.length())));
                }
                admin.push(pwd);
                if (pwd == password) {
                    flag=true;
                    System.out.println(flag);
                    break;
                }
            }
        }
    });
    //日志线程
    Thread blog=new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                if (admin.isEmpty()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(admin.pop().toString());
                }
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        AdminAnswer test = new AdminAnswer();
        test.getPwd.start();
        test.blog.setDaemon(true);
        test.blog.start();
    }
}




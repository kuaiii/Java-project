package testCode;

import java.util.List;

public class LogThread extends Thread{
    private List<String> passwords;
    private boolean flag = false;
    
    public LogThread(List<String> passwords){
        this.passwords = passwords;
        this.setDaemon(true);
    }

    public void run (){
        while(true){
            if(passwords.isEmpty()){
                try{
                   Thread.sleep(1000); 
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            } else{
                String password = passwords.remove(0);
                System.out.println("破译猜测的密码为：" + password);
            }
        }
    }
}

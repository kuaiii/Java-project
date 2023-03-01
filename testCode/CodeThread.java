package testCode;

import java.util.List;

public class CodeThread extends Thread{
    private String password;
    private List<String> passwords;
    private boolean flag = false;

    public CodeThread(String password, List<String> passwords){
        this.password = password;
        this.passwords = passwords;
    }

    public void run(){
        char[] guessword = new char[password.length()];
        generated(guessword, password);
    }
    public void generated(char[] guessword, String password){
        generated(guessword, 0, password);
    }
    public void generated(char[] guessword, int index, String password){
        if(flag){
            return;
        } else{
            for(short i='0'; i<'z'; i++){
                char c = (char)i;
                if(!Character.isLetterOrDigit(c)){
                    continue;
                } else{
                    guessword[index] = c;
                    String guess = new String(guessword);
                    if(index == guess.length()-1){
                        passwords.add(guess);
                        if(guess.equals(password)){
                            flag = true;
                            System.out.println("密码破译成功为: " + guess);
                            System.out.println("密码为：" + password);
                            return;
                        }
                    }  else{
                        generated(guessword, index+1, password);
                    }
                }
            }
        }
    }
}

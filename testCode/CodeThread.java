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
        char[] guessword = new char[passwords.size()];
        generated(guessword, 0, passwords);
    }

    public void generated(char[] guessword, int index, List<String> passwords){
        if(flag){
            return;
        } else{
            for(short i='0'; i<'Z'; i++){
                c = (char)i;
                if(!Character.isLetterOrDigit(c)){
                    continue;
                } else{
                    guessword[index] = c;
                    String guess = new String(guessword);
                    if(index == guess.length()-1){
                        passwords.add(guess);
                        if(guess.equals(password)){
                            flag = true;
                            break;
                        }
                    }  else{
                        generated(guessword, index+1, passwords);
                    }
                }
            }
        }
    }
}

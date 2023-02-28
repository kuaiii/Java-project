package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import characters.Hero;

class KillThrea extends Thread{
    private Hero h1, h2;
    public KillThrea(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
public class MultiThread{
    public static void main(String[] args){
        List<Hero> heros = new ArrayList<Hero>();
        Random r = new Random();
        for(int i=0; i<3; i++){
            heros.add(new Hero("hero"+i, r.nextInt(100), r.nextInt(60)));
        }
        int x1 = r.nextInt(3);
        int x2 = (x1+1)%3, x3 = (x1+2)%3;
        KillThrea kil1 = new KillThrea(heros.get(x1), heros.get(x2));
        new Thread(kil1).start();
        KillThrea kil2 = new KillThrea(heros.get(x2), heros.get(x3));
        new Thread(kil2).start();
    }
}

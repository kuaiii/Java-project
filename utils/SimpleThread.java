package utils;

import characters.Hero;

public class SimpleThread {
    public static void main(String[] args){

        Hero lu = new Hero("陆小凤", 600, 50);
        Hero xi = new Hero("西门吹雪", 400, 200);
        Hero ye = new Hero("叶孤城", 500, 100);
        while(!lu.isDead()){
            xi.attackHero(lu);
        }
        while(!xi.isDead()){
            ye.attackHero(xi);
        }

    }
}

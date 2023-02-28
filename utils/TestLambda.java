package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



class Hero{
    public String name;
    public float hp;
    public int damage;
    public Hero(){

    }
    public Hero(String name){
        this.name = name;
    }
    public Hero(String name, float hp, int damage){
        this.name = name;
        System.out.println(name);
        this.hp = hp;
        this.damage = damage;
    }
}
public class TestLambda {

    private static void filter(List<Hero> heros, HeroChecker checker){
        for(Hero h: heros){
            if(checker.test(h)){
                System.out.print("存在  ");
                System.out.println(h.name+" "+h.hp+" "+h.damage);
            }
            else{
                System.out.println("这一个不是");
            }
        }
    }

    public static void main(String[] args){
        List<Hero> heros = new ArrayList<Hero>();
        Random r = new Random();
        for(int i=0; i<3; i++){
            heros.add(new Hero("hero"+i, r.nextInt(100), r.nextInt(10)));
        }

        System.out.println("初始化后的集合");
        // System.out.println(heros);
        System.out.println("使用Lambda匿名表达式来进行筛选");
        // for(Hero h: heros){
        //     System.out.println(h.name+" "+h.hp+" "+h.damage);
        // }
        // Lambda表达式来进行筛选
        // 通过接口实现匿名表达式，必须在另外一个单独的文件夹中定义一个接口
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp<50 && h.damage<5);
            }
        };

        filter(heros, checker);
    }
}

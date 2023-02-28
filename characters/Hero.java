package characters;

public class Hero {
    public String name;
    public float hp;
    public int damage;

    public Hero(String name, float hp, int damage){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
    public void attackHero(Hero h){
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s受到了%d的伤害\n", name, h.name, h.name, damage);
        if(h.isDead()){
            System.out.println(h.name+"已经被击杀！\n");
        }
    }
    public boolean isDead(){
        return 0>=hp;
    }
}


package synchroTest;

public class Hero {
    public String name;
    public double hp;
    public double damage;

    public boolean isDead(){
        if(hp <= 0){
            return true;
        } else{
            return false;
        }
    }

    public void recover(){
        this.hp++;
        this.notify();
    }
    public void hurt(){
        if(this.hp == 1){
            try{
                this.wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.hp--;
    }
    public void attack(Hero h){
        h.hp -= this.damage;
        if(h.isDead())  System.out.println(h.name+"已经被击杀了!!!");
    }
}

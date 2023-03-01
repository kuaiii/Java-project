package synchroTest;

//import synchroTest.Hero;

public class TestSynchro {
    
    public static void main(String[]  args){
        Hero ximen = new Hero();
        ximen.name = "ximen";
        ximen.hp = 100;
        ximen.damage = 70;

        int n = 1000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        for(int i=0; i<n; i++){
            Thread addthread = new Thread(){
                public void run(){
                    synchronized(ximen){
                        ximen.recover();
                    }
                    try{
                        Thread.sleep(100);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            addthread.start();
            addThreads[i] = addthread;
        }

        for(int i=0; i<n; i++){
            Thread reduceThread = new Thread(){
                public void run(){
                    synchronized(ximen){
                        ximen.hurt();
                    }
                    try{
                        Thread.sleep(100);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            reduceThread.start();
            reduceThreads[i] = reduceThread;
        }

        for(Thread addThread : addThreads){
            try{
                addThread.join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        for(Thread reduceThread : reduceThreads){
            try{
                reduceThread.join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("现在ximen的血量为" + ximen.hp);
    }
}

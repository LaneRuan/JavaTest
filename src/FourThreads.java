/*
* */
public class FourThreads {
    private int j;
    public static void main(String args[]){
        FourThreads tt=new FourThreads();
        Inc inc=tt.new Inc();
        Dec dec=tt.new Dec();
        for(int i=0;i<2;i++){
            Thread t=new Thread(inc);
            t.start();
            t=new Thread(dec);
            t.start();
        }
    }
    private synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }
    private synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName()+"-dec:"+j);
    }
    class Inc implements Runnable{
        public void run(){
            for(int i=0;i<100;i++){
                inc();
            }
        }
    }
    class Dec implements Runnable{
        public void run(){
            for(int i=0;i<100;i++){
                dec();
            }
        }
    }
    class JManager {
        private int j = 0;
        public synchronized void subtract() {
            j--;
        }
        public synchronized void accumulate() {
            j++;
        }
    }
    class A {
        JManager j =new JManager();
        public void main() {
            new A().call();
        }
        void call(){
            for(int i=0;i<2;i++) {
                new Thread(new Runnable(){
                    public void run(){
                        while(true){
                            j.accumulate();
                        }}}).start();

                new Thread(new Runnable(){
                    public void run(){
                        while(true){
                            j.subtract();
                        }}}).start();
            }
        }
    }


}


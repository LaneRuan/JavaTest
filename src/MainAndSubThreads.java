/*子线程循环10次，接着主线程循环100，
接着又回到子线程循环10次，接着再回到主线程又循环100，
如此循环50次，请写出程序。*/
public class MainAndSubThreads {
    public static void main(String[] args) {
        new MainAndSubThreads().init();
    }
    public void init() {
        final Business business =new Business();
        new Thread(
            new Runnable() {
                public void run() {
                    for(int i=0;i<50;i++) {
                            business.SubThread(i);
                        }
                    }
                }
        ).start();

        for(int i=0;i<50;i++) {
            business.MainThread(i);
        }
    }
    private class Business {
        boolean bShouldSub = true;//这里相当于定义了控制该谁执行的一个信号灯
        public synchronized void MainThread(int i) {
            if(bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j=0;j<100;j++) {
                System.out.println(Thread.currentThread().getName()+ ":i=" + i +",j=" + j);
            }
            bShouldSub =true;
            this.notify();
        }

        public synchronized void SubThread(int i) {
            if(!bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j=0;j<10;j++) {
                System.out.println(Thread.currentThread().getName()+ ":i=" + i +",j=" + j);
            }
            bShouldSub =false;
            this.notify();
        }
    }


    static class ThreadTest {
        private static boolean bShouldMain=false;
        public static void main(String[]args) {
        /*new Thread(){
            public void run(){
                for(int i=0;i<50;i++){
                    for(int j=0;j<10;j++){
                        System.out.println("i="+ i + ",j=" + j);
                    }
                }
            }
        }.start();*/
        //final String str = new String("");
            new Thread(new Runnable(){
                public void run() {
                    for(int i=0;i<50;i++){
                        synchronized(ThreadTest.class) {
                            if(bShouldMain){
                                try {
                                    ThreadTest.class.wait();
                                }
                                catch(InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            for(int j=0;j<10;j++) {
                                System.out.println(Thread.currentThread().getName()
                                        + "i="+ i + ",j=" + j);
                            }
                            bShouldMain= true;
                            ThreadTest.class.notify();
                        }
                    }
                }
            }).start();
            for(int i=0;i<50;i++) {
                synchronized (ThreadTest.class){
                    if(!bShouldMain) {
                        try {
                            ThreadTest.class.wait();
                        }
                        catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for(int j=0;j<5;j++) {
                        System.out.println(Thread.currentThread().getName()+
                                        "i=" + i +",j=" + j);
                    }
                    bShouldMain =false;
                    ThreadTest.class.notify();
                }
            }
        }
    }
}

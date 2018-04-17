public class TryCatchFinal {
//    public static void main(String[] args) {
//        System.out.println(new TryCatchFinal().test());
//        TryCatchFinal tcf = new TryCatchFinal();
//        System.out.println(tcf.get());
//    }
//    static int test(){
//        int x = 1;
//        try {
//            return x;
//        }
//        finally {
//            ++x;
//        }
//    }
    public int get() {
        try{
            return 1 ;
        }
        finally {
            return 2 ;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TryCatchFinal().test());;
    }
    int test(){
        try {
            return func1();
        }
        finally {
            return func2();
        }
    }
    int func1(){
        System.out.println("func1");
        return 1;
    }
    int func2() {
        System.out.println("func2");
        return 2;
    }
}

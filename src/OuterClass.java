public class OuterClass {
        int out_x = 0;
        public void method(){
            Inner1 inner1 = new Inner1();
            class Inner2{ //在方法体内部定义的内部类
                public void method(){
                    out_x = 3;
                }
            }
            Inner2 inner2 = new Inner2();
            inner2.method();
            inner1.method();
        }
        public class Inner1{ //在方法体外面定义的内部类
            public void method(){
                out_x = 2;
            }
        }
        public static void main(String[] args){
            OuterClass outerClass = new OuterClass();
            outerClass.method();
            System.out.println(outerClass.out_x);
//            OuterClass outer = new OuterClass();
//            OuterClass.Inner1 inner1 = outer.;
        }
}

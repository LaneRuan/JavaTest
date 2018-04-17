import java.util.Date;
public class SuperGetClass extends Date{
    public static void main(String[] args) {
        new SuperGetClass().test();
    }
    public void test(){
        System.out.println(super.getClass().getName());
        System.out.println(super.getClass().getSuperclass().getName());
        System.out.println(this.getClass().getSuperclass().getName());
    }
}


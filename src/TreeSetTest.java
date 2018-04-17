import java.util.TreeSet;
/*TreeSet里面放对象，
如果同时放入了父类和子类的实例对象，
那比较时使用的是父类的compareTo方法，
还是使用的子类的compareTo方法?*/
class Parent implements Comparable {
    private int age = 0;
    public Parent(int age){
        this.age = age;
    }
    public int compareTo(Object o){
        System.out.println("method of parent");
        Parent o1 = (Parent)o;
        return age>o1.age?1:age<o1.age?-1:0;
    }
}
class Child extends Parent {
    public Child(){
        super(3);
    }
    public int compareTo(Object o){
        System.out.println("method of child");
        // Child o1 = (Child)o;
        return 1;
    }
}

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(new Parent(3));
        set.add(new Child());
        set.add(new Parent(4));
        System.out.println(set.size());
    }
}


package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
/*从类似如下的文本文件中读取出所有的姓名，并打印出重复的姓名和重复的次数，并按重复次数排序*/
public class PrintTextName {
    public static void main(String[] args) {
        Map<String,Integer> results = new HashMap<String,Integer>();
        InputStream ips = PrintTextName.class.getResourceAsStream("info.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(ips));
        String line = null;
        try {
            while((line=in.readLine())!=null) {
                dealLine(line,results);
            }
            sortResults(results);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class User {
        public String name;
        public Integer value;
        public User(String name,Integer value) {
            this.name = name;
            this.value = value;
        }
        @Override
        public boolean equals(Object obj) {
            //下面的代码没有执行，说明往treeset中增加数据时，不会使用到equals方法。
            boolean result =super.equals(obj);
            System.out.println(result);
            return result;
        }
    }
    private static void sortResults(Map results) {
        TreeSet sortedResults =new TreeSet(new Comparator(){
            public int compare(Object o1, Object o2) {
                User user1 = (User)o1;
                User user2 = (User)o2;
                //如果compareTo返回结果0，则认为两个对象相等，新的对象不会增加到集合中去
                //所以，不能直接用下面的代码，否则，那些个数相同的其他姓名就打印不出来
                //return user1.value - user2.value;
                //return user1.value < user2.value?-1:user1.value==user2.value?0:1;
                if(user1.value<user2.value) {
                    return -1;
                }
                else if(user1.value>user2.value) {
                    return 1;
                }
                else{
                    return user1.name.compareTo(user2.name);
                }
            }
        });
        Iterator iterator =results.keySet().iterator();
        while(iterator.hasNext()) {
            String name = (String)iterator.next();
            Integer value =(Integer)results.get(name);
            if(value > 1) {
                sortedResults.add(new User(name,value));
            }
        }
        printResults(sortedResults);
    }

    private static void printResults(TreeSet sortedResults) {
        Iterator iterator = sortedResults.iterator();
        while(iterator.hasNext()) {
            User user = (User) iterator.next();
            System.out.println(user.name + ":" + user.value);
        }
    }
    public static void dealLine(String line,Map map) {
        if(!"".equals(line.trim())) {
            String [] results =line.split(",");
            for(String name:results){
                Integer value =(Integer)map.get(name);
                if(value ==null)
                    value = 0;
                map.put(name,value + 1);
            }
        }
    }
}

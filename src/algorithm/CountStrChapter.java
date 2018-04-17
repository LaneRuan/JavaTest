package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountStrChapter {
    public static void main(String[] args){
        String content = "中国aadf的111萨bbb菲的zz萨菲";
        //这是用来统计字符出现的次数
        HashMap map = new HashMap();
        for(int i=0;i<content.length();i++){
            char c =content.charAt(i);
            Integer num = (Integer) map.get(c);
            if(num == null)
                num = 1;
            else
                num = num +1;
            map.put(c,num);
        }
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.println(entry.getKey()+ ":" + entry.getValue());
        }
//        下面是用来统计中文字符、英文字符、数字字符数目
//        int englishCount = 0;
//        int chineseCount = 0;
//        int digitCount = 0;
//        for(int i=0;i < content.length();i++){
//            char ch = content.charAt(i);
//            if(ch>='0' && ch<='9'){
//                digitCount++;
//            }
//            else if((ch>='a'&& ch<='z') || (ch>='A' && ch<='Z')){
//                englishCount++;
//            }
//            else{
//                chineseCount++;
//            }
//        }
//        System.out.println("englishCount:"+englishCount+"\n chineseCount:"
//                +chineseCount+"\n digitCount:"+digitCount);
    }
}

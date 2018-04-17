import java.util.StringTokenizer;

public class StringSplit {
    public static void main(String[] args){
        String orgStr = "djsiofhe.fe.mflre,fglkfdgklg,fg,r,gr,glr,eld,dfgr,roe,r";
        StringTokenizer tokener = new StringTokenizer(orgStr,",");
        String [] result =new String[tokener.countTokens()];
        int i=0;
        while(tokener.hasMoreTokens()) {
            result[i++]= tokener.nextToken();
        }
        for (String e:result) {
            System.out.println(e);
        }
    }
}

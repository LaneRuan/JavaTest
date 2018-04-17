package JZOffer.Strings;
/*题目：请实现一个函数，把字符串中的每个空格替换成"%20"，
例如输入：“We are happy.”,则输出“We%20are%20happy.”*/

/*常见思路：从头到尾扫描字符串，每次碰到空格字符的时候做替换，于是把一个字符替换成三个字符，
必须把空格后的所有字符都向后移动两个字节，假设字符串长度为n,对每个空格字符，需要移动后面O(n)个字符，
因此对含有O(n)个空格字符的字符串而言总的时间效率为O(n2)*/

/*转变思路：从后向前替换！
* 1. 先遍历一次字符串，统计出字符串中空格的总数，并由此可以计算出替换之后的字符串总长度；
* 2. 从字符串后面开始复制和替换，准备两个指针P1和P2，P1指向原始字符串的末尾，P2指向替换之后的字符串末尾，
*      接下来向前移动指针P1，逐个把它指向的字符复制到P2指向的位置，直到碰到的一个空格为止。
* 3. 碰到第一个空格之后，把第一个指针P1向前移动一格，在P2之前插入字符串“%20”，把P2向前移动三格
* 4. 接着向前复制，直到P1、P2指向同一个位置，表明所有空格都已经替换完毕。
* 分析：所有的字符都只复制（移动）一次，所以时间效率是O(n)*/
public class ReplaceSpace {
    public static char[] ReplaceBlank(char[] string){
        if(string == null || string.length<0){
            return null;
        }
        int length = string.length;
        int numberOfBlank = 0;
        for(int i = 0;i<length;i++){
            if(string[i] == ' '){
                ++ numberOfBlank;
            }
        }
        /*替换后的长度*/
        int newLength = length + numberOfBlank * 2 ;
        char[] copy = new char[newLength];
        int indexOfOriginal = length-1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal>=0){
            if(string[indexOfOriginal] == ' '){
                copy[indexOfNew --] ='0';
                copy[indexOfNew --] ='2';
                copy[indexOfNew --] ='%';
            }
            else {
                copy[indexOfNew --] = string[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        return copy;
    }
    public static void main(String[] args){
        String str = "We are happy endding ";
        char[] string = str.toCharArray();
        System.out.println(ReplaceBlank(string));
    }
}

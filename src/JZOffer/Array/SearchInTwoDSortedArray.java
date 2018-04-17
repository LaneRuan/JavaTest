package JZOffer.Array;
/*题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，
* 请完成一个函数，输入这样的一个二维数组和整数，判断数组中是否含有该整数*/

/*样例：
*   1   2   8   9
*   2   4   9   12
*   4   7   10  13
*   6   8   11  15*/

/*分析规律：首先选取数组中右上角的数字：
（即：如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围剔除一行或一列。直到查找到这个数字或查找范围为空）
            如果该数字等于要查找的数字，查找过程结束；
            如果该数字大于要查找的数字，剔除这个数字所在的列；
            如果该数字小于要查找的数字，剔除这个数字所在的行。*/
public class SearchInTwoDSortedArray {
    public static boolean find(int[][] arr,int rows,int columns,int number){
        boolean found = false;
        if(arr!=null && rows>0 && columns>0){
            int row = 0 ;
            int column = columns - 1 ;
            while(row < rows && column >=0){
                //从右上角开始比较
                //如果从左上角开始的话，不方面缩小查找的范围
                if(arr[row][column] == number){
                    found = true;
                    break;
                }
                else if(arr[row][column] > number){
                    --column;
                }
                else{
                    ++row;
                }
            }
        }
        return found;
    }

    public static void main(String[] args){
        int[][] arr = {{1,2,8,9},
                        {2,4,9,12},
                        {4,7,10,13},
                        {6,8,11,15}};
        System.out.println(find(arr,4,4,20));
    }
}

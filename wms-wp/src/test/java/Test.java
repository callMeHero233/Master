import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        System.out.println(6^3);
//        char t = '喊';
//        int r = (int)'b';
//        System.out.println(t);

        int[] arr = {1,7,4,9,2};
        for(int i = 0;i<arr.length - 1;i++){
            for(int j = arr.length - 1;j>i;j--){
                int temp = arr[j];
                if(arr[j] < arr[j-1]){
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println(arr);
    }
}

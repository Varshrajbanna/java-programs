import java.util.*;

public class insertSort {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 7, 8, 1, 2, };
        int key = 0;
        int i = 0;

        for (int j = 2; j < arr.length; j++) {
            key = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;

        }
        System.out.println(Arrays.toString(arr));
    }

}

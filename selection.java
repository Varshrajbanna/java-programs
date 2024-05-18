import java.util.Arrays;

public class selection {
    public static void main(String[] args) {
        int arr[] = { 3, -2, -6, 7 };
        selectionsv(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionsv(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last + 1); // add 1 to include the last element
            swap(arr, maxIndex, last);
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
}
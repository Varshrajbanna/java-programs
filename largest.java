import java.util.Scanner;

public class largest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.next Int();
        if (a > b && a > c) {
            System.out.println(a);
        } else if (a < b && b > c) {
            System.out.println(b);
        } else {
            System.out.println(c);
        }

    }
}
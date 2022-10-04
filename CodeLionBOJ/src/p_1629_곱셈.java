import java.util.Scanner;

public class p_1629_곱셈 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        long temp;
        if(b/2 == 0){
            temp = b/2;
            b = b/2;
        }else{
            temp = b/2;
            b = b/2+b%2;
        }

        long h = (long) (Math.pow(a,b) + Math.pow(a,temp));


        System.out.println(h);
    }
}

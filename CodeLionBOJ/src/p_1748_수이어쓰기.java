import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class p_1748_수이어쓰기 {
    static int []map = {100000000,10000000,1000000,100000,10000,1000,100,10,1};
    static int [] count = new int[9];
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        math();
        int result =0;
        int temp = 9;
        for(int i = 0 ;i<9;i++){
            result += count[i] * temp;
            temp--;
        }
        System.out.println(result);
    }
    public static void math(){
        for(int i = 0; i<9;i++){
            if(m/map[i] != 0){
                count[i] = m - map[i]*(m/map[i]);
                m = m%map[i];
            }
        }
    }
}

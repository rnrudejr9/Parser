import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.file.CopyOption;
import java.util.*;

public class p_1026_보물 {
    static int n;
    static ArrayList<Integer> A = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] B = new int[n];
        for (int i = 0; i < n; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i<n;i++) {
            ArrayList<Integer> C = (ArrayList<Integer>) A.clone();
            rota(C,i);
        }

    }
    public static void rota(ArrayList<Integer> C,int i){
        for(int j = 0 ;j<n;j++) {
            Collections.rotate(C, i);
            int temp = C.get(0);
            C.remove(0);
            System.out.print("C : " + temp);
        }
        System.out.println("rotate");
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int[] nums;
    static List<List<Integer>> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, k) - 1;
        nums = new int[size];
        
        StringTokenizer st = new StringTokenizer(br.readLine());  
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }
        
        binarySearch(0, size, 0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int l : list.get(i)) {
                sb.append(l).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    public static void binarySearch(int start, int end, int depth) {
        if (k == depth) {
            return;
        }
        int mid = (start + end) / 2;
        list.get(depth).add(nums[mid]);
        binarySearch(start, mid - 1, depth + 1);
        binarySearch(mid + 1, end, depth + 1);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int n, r, temp, root;
    static List<List<Integer>> relation;

    public static void main(String[] args) throws IOException {
        /*
        * boj 1068 트리
        * 입력: 첫째 줄에 트리의 노드의 개수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 0번 노드부터 N-1번 노드까지, 각 노드의 부모가 주어진다. 만약 부모가 없다면 (루트) -1이 주어진다. 셋째 줄에는 지울 노드의 번호가 주어진다.
        * 출력: 첫째 줄에 입력으로 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력
        * 전체 리프 노드의 개수를 구한 다음, 노드 간의 관계를 정의한 리스트에서 dfs를 통해 리프 노드를 탐색하기
        * 삭제해야 하는 노드는 제외하고 탐색
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        relation  = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            relation.add(new ArrayList<>());
        }

        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (temp == -1) root = i; // root 노드 설정
            else relation.get(temp).add(i); // 관계를 표시한 리스트에 추가
        }

        r = Integer.parseInt(br.readLine());
        if (r == root) { // 현재 지워져야 할 노드가 root이면 0 리턴
            System.out.println(0);
            return;
        }

        System.out.println(dfs(root));
    }

    // dfs
    public static int dfs(int here) {
        int ret = 0;
        int child = 0;
        for (int there : relation.get(here)) {
            if (there == r) continue; // 현재 위치가 삭제해야 할 위치라면 pass하여 삭제 시작 노드를 아예 탐색 범위에서 제외
            ret += dfs(there); // dfs의 결과를 더하기
            child++; // 자식 노드의 개수 증가
        }
        return child == 0 ? 1 : ret; // 자식 노드가 없으면 리프 노드이므로 1 리턴, 있으면 반환되어 올라온 값 리턴
    }
}
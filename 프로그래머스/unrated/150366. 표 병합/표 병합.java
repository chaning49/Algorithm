import java.util.*;

class Solution {
    private static final int SIZE = 51;
    private String[][] table = new String[SIZE][SIZE];
    private Map<String, Set<String>> mergedCells = new HashMap<>();
    
    // 테이블 초기화
    public Solution() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                table[i][j] = "EMPTY";
            }
        }
    }
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        for (String command : commands) {
            String[] cmd = command.split(" ");
            switch (cmd[0]) {
                case "UPDATE":
                    if (cmd.length == 4) {
                        updateValue(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), cmd[3]);
                    } else if (cmd.length == 3) {
                        updateValue(cmd[1], cmd[2]);
                    }
                    break;
                case "MERGE":
                    mergeCells(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]),
                              Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]));
                    break;
                case "UNMERGE":
                    unmergeCells(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    break;
                case "PRINT":
                    answer.add(printCell(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2])));
                    break;
            }
        }
        
        return answer.toArray(new String[0]);
    }
    
    private void updateValue(int r, int c, String newValue) {
        String key = r + "," + c;
        if (mergedCells.containsKey(key)) {
            for (String mergedKey : mergedCells.get(key)) {
                String[] parts = mergedKey.split(",");
                table[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])] = newValue;
            }
        } else {
            table[r][c] = newValue;
        }
    }
    
    private void updateValue(String oldValue, String newValue) {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                if (table[i][j].equals(oldValue)) {
                    table[i][j] = newValue;
                }
            }
        }
    }
    
    private void mergeCells(int r1, int c1, int r2, int c2) {
        String key1 = r1 + "," + c1;
        String key2 = r2 + "," + c2;
        Set<String> cells1 = mergedCells.getOrDefault(key1, new HashSet<>());
        Set<String> cells2 = mergedCells.getOrDefault(key2, new HashSet<>());
        
        cells1.add(key1);
        cells2.add(key2);
        
        Set<String> allCells = new HashSet<>(cells1);
        allCells.addAll(cells2);
        
        String mergeValue = !table[r1][c1].equals("EMPTY") ? table[r1][c1] : table[r2][c2];
        
        for (String key : allCells) {
            String[] parts = key.split(",");
            int r = Integer.parseInt(parts[0]);
            int c = Integer.parseInt(parts[1]);
            table[r][c] = mergeValue;
            mergedCells.put(key, allCells); // r,c 좌표별로 병합된 셀들 업데이트
        }
    }
    
    private void unmergeCells(int r, int c) {
        String key = r + "," + c;
        String mergeValue = table[r][c];

        if (mergedCells.containsKey(key)) {
            for (String mergedKey : mergedCells.get(key)) {
                String[] parts = mergedKey.split(",");
                int r1 = Integer.parseInt(parts[0]);
                int c1 = Integer.parseInt(parts[1]);
                table[r1][c1] = "EMPTY";
                mergedCells.remove(mergedKey); // r,c에 해당하는 key를 제거해서 병합을 끊어준다.
            }
            table[r][c] = mergeValue;
        }
    }

    private String printCell(int r, int c) {
        return table[r][c];
    }
}

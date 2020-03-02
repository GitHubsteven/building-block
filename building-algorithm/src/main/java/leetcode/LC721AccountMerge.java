package leetcode;

import java.util.List;

/**
 * @Authoer: asa.x
 * @Date: 2020/3/1
 * @Descrition:
 */
public class LC721AccountMerge {
    public static void main(String[] args) {

    }

    void dfs(int index, boolean[][] matrix) {
        boolean[] isVisited = new boolean[]
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        boolean[][] adjacentMatrix = buildAdjacentMatrix(accounts);
        boolean[] isVisited = new boolean[accounts.size()];
        return null;
    }

    private boolean[][] buildAdjacentMatrix(List<List<String>> accounts) {
        int size = accounts.size();
        boolean[][] adjacentMatrix = new boolean[size][size];
        //O(n*n) to create adjacentMatrix
        for (int i = 0; i < size; i++) {
            List<String> account = accounts.get(i);
            for (int j = i; j < size; j++) {
                if (i == j) continue;
                if (isSameAccount(account, accounts.get(j))) adjacentMatrix[i][j] = true;
            }
        }
        return adjacentMatrix;
    }

    public boolean isSameAccount(List<String> first, List<String> merged) {
        for (int i = 1; i < merged.size(); i++) {
            if (first.contains(merged.get(i))) return true;
        }
        return false;
    }
}

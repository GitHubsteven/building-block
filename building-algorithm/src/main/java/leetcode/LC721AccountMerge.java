package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authoer: asa.x
 * @Date: 2020/3/1
 * @Descrition:
 */
public class LC721AccountMerge {
    public static void main(String[] args) {

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        boolean[][] adjacentMatrix = buildAdjacentMatrix(accounts);
        boolean[] isVisited = new boolean[accounts.size()];
        //loop and recurse
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int index = 0; index < accounts.size(); index++) {
            if (isVisited[index]) continue;
            List<Integer> sameAccountIndexes = new ArrayList<>();
            dfs(adjacentMatrix, isVisited, index, sameAccountIndexes);
            List<String> newAccount = mergeAllSameAccounts(accounts, sameAccountIndexes);
            mergedAccounts.add(newAccount);
        }
        return mergedAccounts;
    }

    private List<String> mergeAllSameAccounts(List<List<String>> allAccount, List<Integer> sameAccountIndex) {
        List<String> first = allAccount.get(0);
        for (int i = 1; i < sameAccountIndex.size(); i++) {
            List<String> second = allAccount.get(i);
            mergeAccount(first, second);
        }
        return first;
    }

    /**
     * merge two account
     *
     * @param first  account merged to
     * @param merged account to be merged
     */
    public void mergeAccount(List<String> first, List<String> merged) {
        String firstName = first.get(0);
        String mergedName = merged.get(0);
        if (firstName.compareTo(mergedName) > 0) first.set(0, mergedName);
        for (int index = 1; index < merged.size(); index++) {
            if (!first.contains(merged.get(index))) first.add(merged.get(index));
        }
    }

    public void dfs(boolean[][] adjacentMatrix, boolean[] isVisited, int start, List<Integer> visitor) {
        if (isVisited[start]) return;
        visitor.add(start);
        isVisited[start] = true;
        boolean[] directSameAccIndexes = adjacentMatrix[start];
        for (int idx = 0; idx < directSameAccIndexes.length; idx++) {
            if (directSameAccIndexes[idx] && !isVisited[idx])
                dfs(adjacentMatrix, isVisited, start, visitor);
        }
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

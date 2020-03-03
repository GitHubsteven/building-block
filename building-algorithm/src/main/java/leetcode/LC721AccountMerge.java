package leetcode;

import java.util.*;

/**
 * @Authoer: asa.x
 * @Date: 2020/3/1
 * @Descrition: url: https://leetcode.com/problems/accounts-merge/
 */
public class LC721AccountMerge {
    public static void main(String[] args) {
        LC721AccountMerge main = new LC721AccountMerge();
        String[][] accounts = {{"David", "David0@m.co", "David1@m.co"}, {"David", "David3@m.co", "David4@m.co"}, {"David", "David4@m.co", "David5@m.co"}, {"David", "David2@m.co", "David3@m.co"}, {"David", "David1@m.co", "David2@m.co"}};
        List<List<String>> accountsList = new ArrayList<>();
        for (String[] account : accounts) {
            accountsList.add(new ArrayList<>(Arrays.asList(account)));
        }
        List<List<String>> accountsMerged = main.accountsMerge(accountsList);
        System.out.println(accountsMerged);
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
        //distinct and sort
        List<List<String>> finalMergedAccount = new ArrayList<>();
        for (List<String> mergedAccount : mergedAccounts) {
            List<String> distinct = new ArrayList<>(new HashSet<>(mergedAccount));
            distinct.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            finalMergedAccount.add(distinct);
        }
        mergedAccounts.clear();
        return finalMergedAccount;
    }

    private List<String> mergeAllSameAccounts(final List<List<String>> allAccount, final List<Integer> sameAccountIndex) {
        if (sameAccountIndex.size() == 1) return allAccount.get(sameAccountIndex.get(0));
        List<String> first = new ArrayList<>(allAccount.get(sameAccountIndex.get(0)));
        for (Integer accountIndex : sameAccountIndex) {
            mergeAccount(first, allAccount.get(accountIndex));
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
        boolean[] accountsRelations = adjacentMatrix[start];
        for (int idx = 0; idx < accountsRelations.length; idx++) {
            if (idx != start && accountsRelations[idx] && !isVisited[idx])
                dfs(adjacentMatrix, isVisited, idx, visitor);
        }
    }

    /**
     * timeout
     *
     * @param adjacentMatrix
     * @param isVisited
     * @param start
     * @param visitor
     */
    public void bfs(boolean[][] adjacentMatrix, boolean[] isVisited, int start, List<Integer> visitor) {
        if (isVisited[start]) return;
        List<Integer> cursor = new ArrayList<>();
        cursor.add(start);
        List<Integer> temp = new ArrayList<>();
        while (!cursor.isEmpty()) {
            visitor.addAll(cursor);
            for (Integer idx : cursor) {
                isVisited[idx] = true;
                for (int i = 0; i < adjacentMatrix[idx].length; i++) {
                    if (i != idx && adjacentMatrix[idx][i] && !isVisited[i]) {
                        temp.add(i);
                    }
                }
            }
            cursor.clear();
            cursor.addAll(temp);
            temp.clear();
        }
    }


    private boolean[][] buildAdjacentMatrix(List<List<String>> accounts) {
        int size = accounts.size();
        boolean[][] adjacentMatrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            List<String> account = accounts.get(i);
            for (int j = i; j < size; j++) {
                if (i == j) continue;
                if (isSameAccount(account, accounts.get(j))) {
                    adjacentMatrix[i][j] = true;
                    adjacentMatrix[j][i] = true;
                }
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

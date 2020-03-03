package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Authoer: asa.x
 * @Date: 2020/2/11
 * @Descrition: url: https://leetcode.com/problems/accounts-merge/
 */
public class LC721 {
    public static void main(String[] args) {
        LC721 test = new LC721();
        String[][] accounts = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {
                "John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        List<List<String>> accountsList = new ArrayList<>();
        for (String[] account : accounts) {
            accountsList.add(new ArrayList<>(Arrays.asList(account)));
        }
        List<List<String>> accountsMerged = test.accountsMerge(accountsList);
        System.out.println(accountsMerged);
    }

    /**
     * @param accounts accounts
     * @return accounts after merged
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accounts) {
            //merge if the same, else add it
            boolean isMerged = false;
            for (List<String> newAccount : mergedAccounts) {
                if (isSameAccount(newAccount, account)) {
                    mergeAccount(newAccount, account);
                    isMerged = true;
                    break;
                }
            }
            if (!isMerged) mergedAccounts.add(account);
        }
        return mergedAccounts;
    }


    public boolean isSameAccount(List<String> first, List<String> merged) {
        for (int i = 1; i < merged.size(); i++) {
            if (first.contains(merged.get(i))) return true;
        }
        return false;
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
}

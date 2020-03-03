package leetcode;

import java.util.*;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://algorithms.tutorialhorizon.com/dynamic-programming-minimum-jumps-to-reach-to-end/
 * @Author asa.x
 * @Date: Created at 15:51 2020/3/3.
 */
public class LC721OnlineSolution {
    //this fun finds the root parent
    int findParent(int[] parent, int idx) {
        if (parent[idx] == -1)
            return idx;
        return findParent(parent, parent[idx]);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();

        HashMap<String, Integer> mail_map = new HashMap<>();
        int[] parent = new int[len];

        Arrays.fill(parent, -1);

        Iterator<List<String>> acc_iterator = accounts.iterator();
        int idx = 0;
        while (acc_iterator.hasNext()) {
            Iterator<String> mail_iterator = acc_iterator.next().iterator();
            mail_iterator.next(); //skipping the name

            while (mail_iterator.hasNext()) {
                String mail = mail_iterator.next();

                if (!mail_map.containsKey(mail))
                    mail_map.put(mail, idx);

                else {
                    int p_idx = mail_map.get(mail);
                    if (idx != p_idx) //if the same acc has multiple duplicate mails
                    {
                        if (parent[idx] != -1) //means this acc is already a duplicate one
                        {

                            /*
                                this would check if it already belongs to the same base acc or a different one
                                1. if the same then do nothing,
                                2. if diff then the two base accs should also be linked
                            */

                            p_idx = findParent(parent, p_idx);
                            int prev_p_idx = findParent(parent, idx);

                            if (p_idx != prev_p_idx) {
                                parent[p_idx] = prev_p_idx;
                            }
                        } else
                            parent[idx] = p_idx;

                    }
                }
            }

            idx++;
        }

        // System.out.println(mail_map);

        //now merging and marking to be merged accounts
        idx = 0;
        boolean[] to_remove = new boolean[len]; //this indicates if the acc is being merged

        while (idx < len) {
            int p_idx = findParent(parent, idx);

            if (p_idx != idx) //i.e., if this acc is to be merged with some other acc
            {
                accounts.get(p_idx).addAll(accounts.get(idx)); //merging
                to_remove[idx] = true;
            }
            idx++;
        }


        //now sorting and removing duplicate mails

        List<List<String>> updated_accs = new ArrayList<>();
        idx = 0;
        while (idx < len) {
            if (!to_remove[idx]) {
                updated_accs.add(new ArrayList(new TreeSet(accounts.get(idx))));
            }
            idx++;
        }

        // for(int i=0;i<len;i++)
        //     System.out.println(i+"-->"+parent[i]+"-->"+to_remove[i]);

        return updated_accs;
    }
}
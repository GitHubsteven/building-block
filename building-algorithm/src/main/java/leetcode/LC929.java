package leetcode;

import java.util.Objects;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 * @Date: Created at 20:23 2019/4/11.
 */
public class LC929 {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        char IGNORE_LATTER_LETTER_IN_LOCAL = '+';
        char IGNORE_SELF_LETTER_IN_LOCAL = '.';
        char LOCAL_DOMAIN_SPLIT = '@';

        String[] validateEmail = new String[emails.length];
        int num = 0;
        StringBuilder newEmail = new StringBuilder();
        for (String email : emails) {
            boolean isLocalName = true;
            boolean isIgnoreLatter = false;
            for (int i = 0; i < email.length(); i++) {
                char letter = email.charAt(i);
                if (letter == LOCAL_DOMAIN_SPLIT && isLocalName) {
                    isLocalName = false;
                    newEmail.append(letter);
                    continue;
                }
                if (isLocalName) {
                    if (isIgnoreLatter) continue;
                    if (letter == IGNORE_LATTER_LETTER_IN_LOCAL) {
                        isIgnoreLatter = true;
                        continue;
                    }
                    if (letter == IGNORE_SELF_LETTER_IN_LOCAL) continue;
                }
                newEmail.append(letter);
            }
            boolean isExisted = false;
            String nEmail = newEmail.toString();
            if (nEmail.length() == 0) continue;
            newEmail.setLength(0);
            for (int k = 0; k < validateEmail.length && validateEmail[k] != null; k++) {
                if (Objects.equals(validateEmail[k], nEmail)) {
                    isExisted = true;
                    break;
                }
            }
            if (!isExisted) {
                validateEmail[num++] = nEmail;
            }
        }
        return num;
    }
}
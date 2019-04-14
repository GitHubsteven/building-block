package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:48 2019/4/10.
 */
public class LC709 {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(toLowerCase(str));
    }

    /**
     * 大写和小写ASCII的值
     *
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ele = str.charAt(i);
            if (ele >= 'A' && ele <= 'Z') {
                sb.append((char) (ele + 32));
            } else {
                sb.append(ele);
            }
        }
        return sb.toString();
    }
}
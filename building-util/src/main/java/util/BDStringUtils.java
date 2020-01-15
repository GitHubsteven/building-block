package util;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 15:18 2020/1/13.
 */
public class BDStringUtils {
    public static void main(String[] args) {
        String str = "132,123Tes，2343";
        String[] strList = str.split("[,，\\-]");
        for (String ele : strList) {
            System.out.println(ele);
        }
    }
}
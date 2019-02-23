package data.structure.book;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 20:41 2019/2/22.
 */
public class Loop {
    public static void main(String[] args) {
        int[] data = new int[10];
        data[0] = 1;
        data[1] = 2;
        int val = 3;
        for (int i = 0; data[i] != 0; i++)
            data[i] = val;
        for (int ele : data) {
            System.out.print(ele + " ");
        }
    }
}
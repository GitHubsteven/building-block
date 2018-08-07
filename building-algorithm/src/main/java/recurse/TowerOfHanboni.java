package recurse;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/26
 * @Time: 13:12
 * @Description: In fact, computer algorithm here will not give the details to realize the target,what you need is to
 * abstract the steps and realize the loop
 * @version: 1.0.0
 */
public class TowerOfHanboni {
    public static void main(String[] args) {
//        TowerOfHanboni towersOfhanboni = new TowerOfHanboni();
        System.out.println("input the number of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();
        hanboni(discs, "start", "middle", "end");

    }

    public static void hanboni(int discs, String startTower, String middleTower, String endTower) {
        //如果是最后一个的话，那么把startTower的盘子移动到目标盘子
        if (discs == 1) {
            System.out.println(startTower + "->" + endTower);
            return;
        }
        //把n -1 个盘子从start移动到middle，然后endTower作为中间盘
        hanboni(discs - 1, startTower, endTower, middleTower);
        //(max disc)/start tower + (n-1)/middle tower
        System.out.println(startTower + "->" + endTower);
        //把n-1中的middle tower 作为start Tower，startTower 作为middleTower，endTower恢复为endTower
        hanboni(discs - 1, middleTower, startTower, endTower);
    }


}
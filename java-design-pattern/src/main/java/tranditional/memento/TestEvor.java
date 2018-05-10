package tranditional.memento;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 13:48 2018/5/10.
 */
public class TestEvor {
    public static void main(String[] args) {
        GamePlayer playerHere = new GamePlayer();
        playerHere.setBloodFlow(100);
        playerHere.setLevel(1);
        playerHere.setMagicFlow(100);
        playerHere.setScene("here");
        System.out.println(playerHere);
        System.out.println("============player fight with a ghost, cost 200 bp and 10 mp, now is in the fight scene============");
        CareTaker careTaker = new CareTaker();
        careTaker.addMemento(playerHere.memento());

        playerHere.setBloodFlow(-100);
        playerHere.setMagicFlow(80);
        playerHere.setLevel(3);
        playerHere.setScene("fight scene");
        System.out.println(playerHere.toString());

        if (playerHere.getBloodFlow() < 0) {
            System.out.println("player is dead! Player will be relived");
            playerHere.revert(careTaker.getMementoById(1));
        }
        System.out.println("player revert!");
        System.out.println(playerHere.toString());
    }
}

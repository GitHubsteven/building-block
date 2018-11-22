package jdk.generic;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:38 2018/11/22.
 */
public class SNBaseInvBody extends BaseMessageBody<InvItem> {
    @Override
    public void check() {
        for (int i = 0; i < items.size(); i++) {
            try {
                items.get(i).check();
            } catch (Exception e) {
                throw new IllegalArgumentException("第" + (i + 1) + "项" + e.getMessage());
            }
        }
    }
}
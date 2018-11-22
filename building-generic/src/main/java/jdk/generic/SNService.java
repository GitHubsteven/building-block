package jdk.generic;

import annotation.VOMQQueue;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Voyageone Inc.</p>
 *
 * @author holysky.zhao 2018/3/15 12:33
 * @version 1.0
 */
public class SNService {

    public void sendMoreMsgs(List<BaseMessageBody> records, String which) {
        Class<? extends BaseMessageBody> targetClz = getMap().get(which);
        records.forEach(record -> {
            try {
                //最终在这里，都可以转化，但是最终这个类是什么，那么他就是什么，无论是子类还是孙子类。
                BaseMessageBody target = targetClz.newInstance();
                //这里会出问题的，我无法知道BaseMessageBody这个类中的items的类，对于当前被实例化出来的实例来说，items的类型是object，可以被赋值成
                //任何类型的对象，无法保证数据类型的一致性，所以问题是什么呢？ 泛型/继承 和反射---->反射出来的东西不是子类，而是父类。
                BeanUtils.copyProperties(record, target);
                System.out.println("target class is: " + targetClz.getSimpleName() + " context is :" + target.getItems().get(0).toString());
                System.out.println("is annotation by VOMQQueue: " + target.getClass().isAnnotationPresent(VOMQQueue.class));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 获取子类，但是这个子类是孙子类
     *
     * @return
     */
    private Map<String, Class<? extends BaseMessageBody>> getMap() {
        Map<String, Class<? extends BaseMessageBody>> map = new HashMap<>();
        map.put("1", SNWeChatOverseaOrderBody.class);
        map.put("2", SNWeChatInvOverSeaBody.class);
        return map;
    }

    public void sendMoreMsgsTest() {
        InvItem invItem = new InvItem();
        invItem.setQuantity(1);
        invItem.setSkuCode("sku-code-001");
        BaseMessageBody<InvItem> invMsgBody = new BaseMessageBody<>();
        invMsgBody.setItems(Collections.singletonList(invItem));

        new SNService().sendMoreMsgs(Collections.singletonList(invMsgBody), "2");
    }

    public static void testSendOrderStatus() {
        OrderStatusItem orderStatusItem = new OrderStatusItem();
        orderStatusItem.setOrderNumber("order-number-001");
        orderStatusItem.setOrderStatus("shipped");
        orderStatusItem.setTrackingNumber("tracking-number-001");

        BaseMessageBody<OrderStatusItem> orderMsgBody = new BaseMessageBody<>();
        orderMsgBody.setItems(Collections.singletonList(orderStatusItem));
        new SNService().sendMoreMsgs(Collections.singletonList(orderMsgBody), "2");
    }

    public static void main(String[] args) {
        testSendOrderStatus();
    }
}

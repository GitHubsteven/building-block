package com.demo.asa.building.reflect.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 10:34 2019/11/13.
 */
public class ChangeAnnotationValue {

    private static ThreadLocal mqListCache = ThreadLocal.withInitial((Supplier<CopyOnWriteArrayList<MqMessageBody>>) CopyOnWriteArrayList::new);

    public static void main(String[] args) throws Exception {
        MqMessageBody msg = new MqMessageBody();
        MqMessageBody kofMsg = new MqMessageBody();
        kofMsg.setIsKof(true);
        changeAnn(msg);
        changeAnn(kofMsg);

        CopyOnWriteArrayList<MqMessageBody> messageBodies = (CopyOnWriteArrayList<MqMessageBody>) mqListCache.get();
        messageBodies.forEach(ChangeAnnotationValue::printAnnVal);
    }

    @SuppressWarnings("unchecked")
    public static void changeAnn(MqMessageBody message) throws Exception {
        VOMQQueue vomqQueue = message.getClass().getDeclaredAnnotation(VOMQQueue.class);
        if (message.getIsKof()) {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(vomqQueue);
            Field memberFields = invocationHandler.getClass().getDeclaredField("memberValues");
            memberFields.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) memberFields.get(invocationHandler);
            memberValues.put("value", "kof" + memberValues.get("value"));
            memberFields.setAccessible(false);
        }
        CopyOnWriteArrayList<MqMessageBody> mqList = (CopyOnWriteArrayList<MqMessageBody>) mqListCache.get();
        mqList.add(message);
    }

    private static void printAnnVal(MqMessageBody message) {
        VOMQQueue vomqQueue = message.getClass().getDeclaredAnnotation(VOMQQueue.class);
        System.out.println("value: " + vomqQueue.value());
    }
}
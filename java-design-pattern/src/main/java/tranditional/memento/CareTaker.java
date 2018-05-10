package tranditional.memento;

import java.util.TreeMap;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 13:35 2018/5/10.
 */
public class CareTaker {
    private static volatile Integer id = 1;
    private TreeMap<Integer, Memento> mementoTreeMap = new TreeMap<>();

    public Integer addMemento(Memento memento) {
        mementoTreeMap.put(id++, memento);
        return id;
    }

    public Memento getMementoById(Integer id) {
        return mementoTreeMap.get(id);
    }

    public Memento getMementByKey(Long longId) {
        return mementoTreeMap.values()
                .stream()
                .filter(it -> it.getLongId().equals(longId))
                .findAny()
                .orElse(null);
    }

}

package data.structure.custom;

import data.structure.book.BiNodePtr;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:15 2019/2/25.
 */
@Setter
@Getter
public class ThreadedBiTree<T> extends BiNodePtr<T> {
    /**
     * true 表示left_child 是前驱，false 表示是儿子
     */
    private boolean is_thread_left;
    /**
     * true 表示前驱，false表示是儿子
     */
    private boolean is_thread_right;
}
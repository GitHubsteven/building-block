package threads.work;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:05 2018/12/25.
 */
public interface ISplitOrder<T extends Comparable<T>> {

    /**
     * 按分配标准分为子订单，没有分配成目标类型
     *
     * @param resList   数据集合
     * @param amountMax 最大限制
     * @param goodsMax  数量限制
     * @return 子集合
     */
    List<List<T>> groupMeasure(List<T> resList, T amountMax, int goodsMax);

    /**
     * 将物品分组，并且把结果放在root节点中，构造一个树
     *
     * @param root         树根节点
     * @param dataSet      物品价格分组，
     * @param amountMax    最大金额数
     * @param add          数字加法准则
     * @param defaultValue 组合起始值，推荐为0
     * @param goodsMax     每组最大物品数，如果没有的话，推荐设置为Integer.maxValue
     */
    void group(OrderNode<T> root, List<T> dataSet, T amountMax, int goodsMax,
               BinaryOperator<T> add, T defaultValue);

    /**
     * 获取最接近limit的值
     *
     * @param dataSet      数据集合
     * @param max          最大值限制
     * @param goodsMax     数量限制
     * @param add          相加规则
     * @param defaultValue 默认值
     * @return
     */
    List<List<T>> getNearestValueCombines(List<T> dataSet, T max, int goodsMax,
                                          BinaryOperator<T> add, T defaultValue);

    /**
     * 获取未过滤的组合
     *
     * @param dataSet    数据集合
     * @param add        加法规则
     * @param max        最大值限制
     * @param defaultVal 默认值
     * @param count      排列组合中的选择元素
     * @return 组合集合
     */
    List<List<T>> listCombines(List<T> dataSet, BinaryOperator<T> add,
                               T max, T defaultVal, int count);

    /**
     * 查找树的最上层的叶子节点
     *
     * @param root 根
     * @return 最上层的叶子节点
     */

    List<OrderNode<T>> getTopLeaves(OrderNode<T> root);

    /**
     * 数据是否超过了标准
     *
     * @param compared 待比较的对象
     * @param limit    限制
     * @return 是否
     */
    boolean isBeyondLimit(T compared, T limit);

    class OrderNode<T> {
        /**
         * 这个订单下一个可能的订单
         */
        List<OrderNode<T>> subOrders;
        /**
         * 每个订单的物品数
         */
        List<T> value;

        /**
         * 父节点
         */
        OrderNode<T> parent;

        public List<OrderNode<T>> getSubOrders() {
            return subOrders;
        }

        public void setSubOrders(List<OrderNode<T>> subOrders) {
            this.subOrders = subOrders;
        }

        public List<T> getValue() {
            return value;
        }

        public void setValue(List<T> value) {
            this.value = value;
        }

        public OrderNode<T> getParent() {
            return parent;
        }

        public void setParent(OrderNode<T> parent) {
            this.parent = parent;
        }
    }

    /**
     * 加法法则
     *
     * @param o1 第一个数
     * @param o2 第二个数
     * @return
     */
    T selfAdd(T o1, T o2);

    /**
     * 获取默认值
     */
    T defaultVal();
}
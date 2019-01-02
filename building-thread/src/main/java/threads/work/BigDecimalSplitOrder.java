package threads.work;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 12:11 2018/12/27.
 */
public class BigDecimalSplitOrder extends ISplitOrderTemplate<BigDecimal> {
    private static BigDecimalSplitOrder self = new BigDecimalSplitOrder();

    private BigDecimalSplitOrder() {
    }

    public static BigDecimalSplitOrder instance() {
        return self;
    }

    /**
     * 数据是否超过了标准
     *
     * @param compared 待比较的对象
     * @param limit    限制
     * @return 是否
     */
    @Override
    public boolean isBeyondLimit(BigDecimal compared, BigDecimal limit) {
        return compared.compareTo(limit) > 0;
    }


    /**
     * 加法法则
     *
     * @param o1 第一个数
     * @param o2 第二个数
     * @return
     */
    @Override
    public BigDecimal selfAdd(BigDecimal o1, BigDecimal o2) {
        return o1.add(o2);
    }

    @Override
    public BigDecimal defaultVal() {
        return BigDecimal.ZERO;
    }


    /**
     * 按分配标准分为子订单，没有分配成目标类型
     *
     * @param resList   数据集合
     * @param amountMax 最大限制
     * @param goodsMax  数量限制
     * @return 子集合
     */
    @Override
    public List<List<BigDecimal>> groupMeasure(List<BigDecimal> resList, BigDecimal amountMax, int goodsMax) {
        return null;
    }

    /**
     * 将物品分组，并且把结果放在root节点中，构造一个树
     *
     * @param root         树根节点
     * @param dataSet      物品价格分组，
     * @param amountMax    最大金额数
     * @param goodsMax     每组最大物品数，如果没有的话，推荐设置为Integer.maxValue
     * @param add          数字加法准则
     * @param defaultValue 组合起始值，推荐为0
     */
    @Override
    public void group(OrderNode<BigDecimal> root, List<BigDecimal> dataSet, BigDecimal amountMax, int goodsMax, BinaryOperator<BigDecimal> add, BigDecimal defaultValue) {

    }
}
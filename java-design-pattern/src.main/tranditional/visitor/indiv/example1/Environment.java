package tranditional.visitor.indiv.example1;

import tranditional.bean.business.report.StockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Environment {
    public static void main(String[] args) {
        /* list is IData, stock[ArrayList] is concreteData, Interface Function is the
        interface tranditional.visitor and to lamada expression is the implement of the Function; OMG.
        */
        List<StockBean> stocks = new ArrayList<>();
        stocks.add(new StockBean().setChannelId("001").setOnHand(new BigDecimal(10)).setSku("sku1"));
        stocks.add(new StockBean().setChannelId("002").setOnHand(new BigDecimal(100)).setSku("sku2"));
        stocks.add(new StockBean().setChannelId("002").setOnHand(new BigDecimal(10)).setSku("sku2"));

        Function<StockBean,Boolean> sku2Filter = stockBean -> Objects.equals("sku2",stockBean.getSku());
        long count = stocks.stream().filter(sku2Filter::apply).count();
        System.out.println(count);
    }
}

package tranditional.strategy.company.business;

import tranditional.bean.business.JavaDevDirEnum;
import tranditional.bean.business.report.StockBean;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GetStockStrategy implements IGetDataServiceStrategy<StockBean> {
    @Override
    public String getType() {
        return JavaDevDirEnum.ReportType.Stock.getVal();
    }

    @Override
    public Map<String, Object> getTitle() {
        return null;
    }

    @Override
    public List<StockBean> getContextData() {
        return Collections.emptyList();
    }

    @Override
    public long getSize() {
        return 0;
    }
}

package tranditional.strategy.company.business;

import tranditional.bean.business.JavaDevDirEnum;
import tranditional.bean.business.report.LogictisBean;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GetLogictisStrategy implements IGetDataServiceStrategy<LogictisBean>{
    @Override
    public String getType() {
        return JavaDevDirEnum.ReportType.Logictis.getVal();
    }

    @Override
    public Map<String, Object> getTitle() {
        return null;
    }

    @Override
    public List<LogictisBean> getContextData() {
        return Collections.emptyList();
    }

    @Override
    public long getSize() {
        return 0;
    }
}

package tranditional.strategy.company.business;

import tranditional.bean.business.JavaDevDirEnum;

import java.util.HashMap;
import java.util.Map;

public class StrategyCreator {
    final static Map<JavaDevDirEnum.ReportType,IGetDataServiceStrategy> reportServiceMap = new HashMap<>();

    static {
        reportServiceMap.put(JavaDevDirEnum.ReportType.Logictis,new GetLogictisStrategy());
        reportServiceMap.put(JavaDevDirEnum.ReportType.Stock,new GetStockStrategy());
    }

    public static GetLogictisStrategy createLogictisStra(){
        return new GetLogictisStrategy();
    }

    public static GetStockStrategy createStockStra(){
        return new GetStockStrategy();
    }

    public static  IGetDataServiceStrategy getServiceByType(JavaDevDirEnum.ReportType reportType){
        return reportServiceMap.get(reportType);
    }

}

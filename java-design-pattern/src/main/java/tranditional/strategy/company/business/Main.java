package tranditional.strategy.company.business;

import tranditional.bean.business.JavaDevDirEnum;

public class Main {
    public static void main(String[] args) {

        ICreateReport createReportService = new ICreateReportServiceImpl();
        createReportService.createReport(StrategyCreator.reportServiceMap.get(JavaDevDirEnum.ReportType.Logictis));
    }
}

package tranditional.strategy.company.business;

public abstract class AbstractCreateReport implements ICreateReport {
    @Override
    public void createReport(IGetDataServiceStrategy getDataServiceStrategy) {
        if(null == getDataServiceStrategy){
            throw new RuntimeException("tranditional.strategy is null");
        }
        System.out.println("create report " + getDataServiceStrategy.getType() + "...");
        System.out.println("report tittle context is : "+ getDataServiceStrategy.getTitle());
        System.out.println("report size is : " + getDataServiceStrategy.getSize());
        System.out.println("report data is : " + getDataServiceStrategy.getContextData());
        System.out.println("report create end  ");
    }
}

package tranditional.responsibility.example2;

public class Environment {
    public static void main(String[] args) {
        FilterParam param = new FilterParam();
        param.setId(999L);
        AbstractIndivFilter chain = new ClientOrderIndivFilter();
        ClientOrderDetailCheckFilter detailCheckFilter = new ClientOrderDetailCheckFilter();
        detailCheckFilter.setLastFilter(true);
        chain.setNextFilter(detailCheckFilter);
        chain.check(param);
    }
}

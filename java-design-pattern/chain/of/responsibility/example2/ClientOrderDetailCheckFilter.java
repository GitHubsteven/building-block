package chain.of.responsibility.example2;

public class ClientOrderDetailCheckFilter extends AbstractIndivFilter {
    @Override
    public IndivFilter check(FilterParam param) {
        Long id = param.getId();
        System.out.println(String.format("filer is checking clientOrder[id:%s] details", id));
        if (id > 888) {
            String message = String.format("clientOrder[id: %s] has no reservations", id);
            System.out.println(message);
            throw new RuntimeException(message);
        } else {
            System.out.println(String.format("filer is check clientOrder[id:%s] has reservations and pass this check filter", id));
            if (!isLastFilter()) {
                return getNextFilter().check(param);
            } else {
                return null;
            }
        }
    }
}

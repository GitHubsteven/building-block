package tranditional.responsibility.example2;

public class ClientOrderIndivFilter extends AbstractIndivFilter {
    @Override
    public IndivFilter check(FilterParam param) {
        Long id = param.getId();
        System.out.println(String.format("check the clientOrder [id: %s]", id));
        if (id >= 1000) {
            System.out.println(String.format("client order[id:%s] does not exists, stop check here and will throw a exception", id));
            throw new RuntimeException(String.format("clientOrder[Id: %s] does not exist", id));
        } else {
            System.out.println(String.format("client order[id:%s] exists, continue next check!", id));
            if (!isLastFilter()) {
                return getNextFilter().check(param);
            } else {
                return null;
            }
        }
    }
}

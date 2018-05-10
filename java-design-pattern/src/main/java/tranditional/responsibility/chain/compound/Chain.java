package tranditional.responsibility.chain.compound;

import tranditional.responsibility.example2.AbstractIndivFilter;
import tranditional.responsibility.example2.FilterParam;
import tranditional.responsibility.example2.IndivFilter;

/**
 * 这个链有点坑啊，好像不怎么正确，lol
 */
public class Chain {

    private AbstractIndivFilter head;

    Chain(AbstractIndivFilter head) {
        this.head = head;
    }

    Chain() {
        this.head = createClientOrderChain();
    }

    /**
     * 链的创建不够成熟
     *
     * @return 拦截链
     */
    public static AbstractIndivFilter createClientOrderChain() {
        ClientOrderNumberCheckFilter numberCheckFilter = new ClientOrderNumberCheckFilter();
        AbstractIndivFilter trackingFilter = new ClientOrderTrackingFilter().setLastFilter(true);
        numberCheckFilter.setNextFilter(trackingFilter);
        return numberCheckFilter;
    }

    public Chain addFilter(AbstractIndivFilter filter) {
        AbstractIndivFilter currentNode = head;
        while (currentNode.getNextFilterNullable() != null) {
            currentNode = currentNode.getNextFilter();
        }
        currentNode.setNextFilter(filter);
        return this;
    }

    public void check(FilterParam param) {
        try {
            head.check(param);
        } catch (Exception e) {
            System.out.println(String.format("client OrderId[id: %s] check completed, result is illegal", param.getId()));
        }
    }


    public boolean delFilter(AbstractIndivFilter filter) {
        //todo 这里的链删除可能要用到增加equals方法，暂时不实现，链查找和删除插入是另外的事情
        return false;
    }


    public static class ClientOrderNumberCheckFilter extends AbstractIndivFilter {

        @Override
        public IndivFilter check(FilterParam param) {
            Long id = param.getId();
            if (id > 10) {
                System.out.println("clientOrder number is normal, continue next filter!");
                return isLastFilter() ? null : getNextFilter().check(param);
            } else {
                System.out.println("clientOrder number is abnormal, stop checking!");
                return null;
            }
        }
    }

    public static class ClientOrderTrackingFilter extends AbstractIndivFilter {

        @Override
        public IndivFilter check(FilterParam param) {
            Long id = param.getId();
            if (id > 10 && id < 50) {
                System.out.println("clientOrder tracking is normal, continue next filter!");
                return isLastFilter() ? null : getNextFilter().check(param);
            } else {
                System.out.println("clientOrder number is abnormal, stop checking!");
                return null;
            }
        }
    }
}

package chain.of.responsibility.example2;

public abstract class AbstractIndivFilter implements IndivFilter {
    private boolean isLastFilter = false;
    private AbstractIndivFilter nextFilter;

    public AbstractIndivFilter getNextFilter() {
        ensureNextFilter();
        return nextFilter;
    }
    public AbstractIndivFilter getNextFilterNullable(){
        return nextFilter;
    }

    public AbstractIndivFilter setNextFilter(AbstractIndivFilter nextFilter) {
        this.nextFilter = nextFilter;
        return this;
    }

    public AbstractIndivFilter setLastFilter(boolean lastFilter) {
        isLastFilter = lastFilter;
        return this;
    }

    public boolean isLastFilter() {
        return isLastFilter;
    }

    private void ensureNextFilter() {
        /*
          如果不是最后一个filter，那么如果没有nextFiler 就抛出异常
         */
        if (!isLastFilter && nextFilter == null) {
            throw new RuntimeException("Lack next filter");
        } else {
            System.out.println("[Last filter]");
        }
    }
}

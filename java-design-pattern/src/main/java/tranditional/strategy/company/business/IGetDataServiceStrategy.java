package tranditional.strategy.company.business;

import java.util.List;
import java.util.Map;

public interface IGetDataServiceStrategy<T> {

    String getType();

    Map<String,Object> getTitle();

    List<T> getContextData();

    long getSize();
}

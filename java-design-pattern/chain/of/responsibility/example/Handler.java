package chain.of.responsibility.example;

import bean.common.DesignPatRequest;

/**
 *Handler interface in the design pattern, Have no idea of which is better of interface and abstract class。 Define a
 * common handler interface or abstract so that we call have a common method interface to call.
 */
public interface Handler {
    /**
     * handler process method.
     *
     * @return next Handler, nullable.
     */
    Handler process(DesignPatRequest request);
}

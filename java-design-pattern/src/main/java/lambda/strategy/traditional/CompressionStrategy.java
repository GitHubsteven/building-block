package lambda.strategy.traditional;

import java.io.OutputStream;

/**
 * compression stratety
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public interface CompressionStrategy {
    OutputStream compress(OutputStream data) throws Exception;
}

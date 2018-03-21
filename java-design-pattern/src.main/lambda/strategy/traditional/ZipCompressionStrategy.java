package lambda.strategy.traditional;

import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * ZipCompressionStrategy
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class ZipCompressionStrategy implements CompressionStrategy {
    @Override
    public OutputStream compress(OutputStream data) throws Exception {
        return new ZipOutputStream(data);
    }
}

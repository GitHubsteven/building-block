package lambda.strategy.traditional;

import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Main
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class Main {
    public static void main(String[] args) {

    }

    void traditionalStrategy(){
        //you can define the compression strategy you want
//        CompressionStrategy compressionStrategy = new GZipCompressionStrategy();
//        Compressor compressor = new Compressor(compressionStrategy);
//        compressor.compress();
    }

    void lambdaStrategy(){
        //you can even delete the strategy if the real realized sub strategy  existed;
        Compressor compressor_gzip = new Compressor(GZIPOutputStream::new);
        Compressor compressor_zip = new Compressor(ZipOutputStream::new);

    }
}

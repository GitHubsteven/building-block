package lambda.strategy.traditional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Compressor
 * Created by rongbin.xie on 2018/3/21.
 */
public class Compressor {

    private final CompressionStrategy compressionStrategy;

    public Compressor(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    public void compress(Path inFile, File outFile) throws Exception {
        try (OutputStream outputStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, compressionStrategy.compress(outputStream));
        }
    }
}

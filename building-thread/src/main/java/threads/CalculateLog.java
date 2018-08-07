package threads;

import javafx.util.Pair;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateLog {
    public static void main(String[] args) {
        Path logPath = Paths.get("C:\\Users\\asa-x\\Desktop", "lg.txt");
        File logFile = logPath.toFile();
        if (!logFile.exists()) return;
        try {
            String logContext = FileUtils.readFileToString(logFile, "utf-8");
            String[] lines = logContext.split("\r\n");
            if (lines.length != 500) {
                System.out.println("log lines does not eequal 500");
            } else {
                List<Pair<String, String>> values = new ArrayList<>();
                Arrays.stream(lines).forEach(line -> {
                    String[] keyAndvalue = line.split("\\|");
                    if (keyAndvalue.length >= 2) {
                        values.add(new Pair<>(keyAndvalue[0], keyAndvalue[1]));
                    }
                });

                Map<String, Long> key2NumbesrMap = values.stream()
                        .collect(Collectors.groupingBy(it -> it.getKey(), Collectors.counting()));
                key2NumbesrMap.forEach((threadName, outTime) -> {
                    if (outTime != 5) {
                        System.out.println("------" + threadName);
                    } else {
                        System.out.println("thread:" + threadName + " value " + outTime);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

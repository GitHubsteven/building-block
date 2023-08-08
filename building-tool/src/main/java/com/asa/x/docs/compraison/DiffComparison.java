/**
 * @author: asx
 * @date: 2023/8/8
 * @descrition:
 */
package com.asa.x.docs.compraison;

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.github.difflib.algorithm.DiffAlgorithmI;
import com.github.difflib.algorithm.myers.MeyersDiffWithLinearSpace;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 * @author: asx
 * @date: 2023/8/8
 * @descrition:
 */
public class DiffComparison {
    private static String oldPath = "C:\\Users\\xrb16\\Desktop\\workspace\\contract-x-old.txt";
    //对比文件
    private static String newPath = "C:\\Users\\xrb16\\Desktop\\workspace\\contract-x.txt";

    public static void main(String[] args) throws IOException {
        //原始文件
        List<String> original = Files.readAllLines(new File(oldPath).toPath(), Charset.forName("GB2312"));

        List<String> revised = Files.readAllLines(new File(newPath).toPath(), Charset.forName("GB2312"));
        //两文件的不同点
        Patch<String> patch = DiffUtils.diff(original, revised);
//        for (AbstractDelta<String> delta : patch.getDeltas()) {
//            System.out.println(delta);
//        }

        //生成统一的差异格式
        List<String> unifiedDiff = UnifiedDiffUtils.generateUnifiedDiff("contract-x-old.txt", "contract-x.txt", original, patch, 0);
        unifiedDiff.forEach(System.out::println);
    }
}

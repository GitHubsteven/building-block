package util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/13
 * @Time: 10:46
 * @Description:
 * @version: 1.0.0
 */
public class ZipUtil {
    public static void main(String[] args) {
//        extractZip();
        try {
            example2();
            System.out.println("succeed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractZip() {
        Path root = Paths.get("D:\\download");
        File[] srcFile = new File[2];
        for (int i = 1; i < 3; i++) {
            Path filePath = root.resolve("E-Finest Co.,Ltd._" + i + ".xlsx");
            File tmp = filePath.toFile();
            srcFile[i - 1] = tmp;
        }
        Path zipPath = root.resolve("testzipCo.zip");
        ZipFiles(srcFile, zipPath.toFile());
    }

    //压缩文件
    public static void ZipFiles(File[] srcfile, File zipfile) {
        byte[] buf = new byte[1024];
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    zipfile));
            for (int i = 0; i < srcfile.length; i++) {
                FileInputStream in = new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void example2() throws IOException {
        //文件流的目的，这里可以用outpuStream缓存
        File file = new File("D:\\f.zip");
        FileOutputStream fos = new FileOutputStream(file);
        //指定zip流的输出目的点
        ZipOutputStream zip = new ZipOutputStream(fos);
        //包增加一个文件条目，初始化输入名称
        ZipEntry entry = new ZipEntry("test.txt");
        zip.putNextEntry(entry);
        //输入字节流作为文件条目的来源
        zip.write("a simple txt".getBytes());
        //同上
        ZipEntry entry2 = new ZipEntry("test2.txt");
        zip.putNextEntry(entry2);
        zip.write("a simple file2".getBytes());
        //关闭文件条目的输入点
        zip.closeEntry();
        //关闭zip流
        zip.close();
    }


}
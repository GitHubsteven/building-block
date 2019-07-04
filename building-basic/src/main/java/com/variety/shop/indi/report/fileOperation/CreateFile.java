package com.variety.shop.indi.report.fileOperation;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by rongbin.xie on 2017/5/3.
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class CreateFile {
    public static void main(String[] args) throws IOException {
        String dateStr = "2017-04-12";
        String[] dateStrs = dateStr.split("-");
        String str1= dateStr.replace("-","/");
        System.out.println(str1);
        Path isPath = Paths.get("E:/biReport");
        Path path = Paths.get("E:/noThisDir");
//        String subPath = "test.txt";
        Path path2 = path.resolve(str1);
        System.out.println(path2.toString());

        File file =new File(path2.toString());
//        if(!file.exists()){
//            file.mkdirs();
//        }
        String fileName = "test1.txt";
        Path path3= path2.resolve(fileName);
        File targetFile = new File(path3.toString());
        String context = "hello,world!";
//        InputStream ios = new ;
        byte[] buffer = context.getBytes();


//        InputStream ios = new FileInputStream(path.toString());
        if(!path2.toFile().exists()) path2.toFile().mkdirs();
        File tewst= new File(path3.toString());
//        OutputStream outputStream = new FileOutputStream(path3.toFile(),true);
//        OutputStream out = new FileOutputStream(path3.toString());
//        byte[] buffer = new byte[100];
//        ios.read(buffer);
//        outputStream.write(buffer);

//        if(!targetFile.exists()) targetFile.createNewFile();
//        if(targetFile.exists()){
//            targetFile.delete();
//        }

//        path2.

//        if()

        //define the fixed path
//        Path base = Paths.get("C:/rafaelnadal/tournaments/2009");

        //resolve BNP.txt file
//        Path path_1 = base.resolve("BNP.txt");
        //output: C:\rafaelnadal\tournaments\2009\BNP.txt
//        System.out.println(path_1.toString());

        //resolve AEGON.txt file
//        Path path_2 = base.resolve("AEGON.txt");
        //output: C:\rafaelnadal\tournaments\2009\AEGON.txt
//        System.out.println(path_2.toString());
    }
}

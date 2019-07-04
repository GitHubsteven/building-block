package com.variety.shop.indi.report.slqParseTool;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongbin.xie on 2017/6/1.
 */
public class SqlLogParseTool {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("D:\\logForLearn\\log.txt");
        File logFile = filePath.toFile();
        if (!logFile.exists()) {
            System.out.println("not find log.txt");
            return;
        }
        String test = "abc?abde?ab?";
        String re = "?";
        int index = test.indexOf(re);
        while(index != -1){
            System.out.println(index);
            index = test.indexOf(re,index+re.length());
        }


//        FileReader fr = new FileReader(logFile);
//        BufferedReader bf = new BufferedReader(fr);
//        String line = bf.readLine();
//        while (line != null) {
//            System.out.println(line);
//            line = bf.readLine();
//        }
    }

    public  static List<Integer> parseLogLine(String line,String re){
        String PARAMETERS ="Parameters";
        String PREPARING = "Preparing";
        String logLineSplitMark = "| =>";
        String  placeHolder = "?";

        List<Integer>  placeHolderIndex= new ArrayList<>();


        String[] firstLineParse =  line.split(logLineSplitMark);
        if(firstLineParse.length >= 2){
            String sqlWithPrefix = firstLineParse[1];
            if(sqlWithPrefix.contains(PREPARING)){
                String sql = sqlWithPrefix.split("Parameters")[1].trim();
                int index = sql.indexOf(placeHolder);
                while(index != -1){
                    placeHolderIndex.add(index);
                    index = sql.indexOf(placeHolder,index+placeHolder.length());
                }
            }
        }
        return placeHolderIndex;
    }

}

package com.demo.asa.building.reflect.classloader;

import java.io.File;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/27
 * @Time: 20:44
 * @Description:
 * @version: 1.0.0
 */
public class ClassLoderTest {
    public static void main(String[] args) {
        File[] extDirs = getExtDirs();
        for (File extDir : extDirs) {
            System.out.println("====:" + extDir.getName());
        }
    }

    public static File[] getExtDirs() {
        //load java lib/jar stored in java_home/lib/ext
        String extDirs = System.getProperty("java.ext.dirs");
        File[] dirs;
        if (extDirs != null) {
            StringTokenizer st = new StringTokenizer(extDirs, File.pathSeparator);
            int count = st.countTokens();
            dirs = new File[count];
            for (int i = 0; i < count; i++) {
                dirs[i] = new File(st.nextToken());
            }
        } else {
            dirs = new File[0];
        }
        return dirs;
    }
}
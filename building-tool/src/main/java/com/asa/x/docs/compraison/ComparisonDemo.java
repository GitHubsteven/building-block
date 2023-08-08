/**
 * @author: asx
 * @date: 2023/8/8
 * @descrition:
 */
package com.asa.x.docs.compraison;

import com.groupdocs.comparison.Comparer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;

/**
 * @author: asx
 * @date: 2023/8/8
 * @descrition:
 */
public class ComparisonDemo {
    public static void main(String[] args) {
        try (Comparer comparer = new Comparer(new FileInputStream("C:\\Users\\xrb16\\Desktop\\workspace\\contract-x-old.doc"))) {
            comparer.add(new FileInputStream("C:\\Users\\xrb16\\Desktop\\workspace\\contract-x.doc"));
            comparer.compare(new FileOutputStream("C:\\Users\\xrb16\\Desktop\\workspace\\result.doc"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

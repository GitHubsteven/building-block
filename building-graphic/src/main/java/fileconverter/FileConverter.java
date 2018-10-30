package fileconverter;

import com.sun.imageio.plugins.common.ImageUtil;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:30 2018/10/23.
 */
public class FileConverter {
    private final static BASE64Encoder encoder = new BASE64Encoder();

    private final static BASE64Decoder decoder = new BASE64Decoder();

    private static int number = 1;

    public static void fromBase64(String base64Context) throws IOException {


    }

    public static void base642Pdf(String base64Context) throws IOException {
        byte[] contextByte = decoder.decodeBuffer(base64Context);

    }

    public static void pdf2jpg() {

    }

    public static String jpg2Base64() {
        return null;
    }

    public static void main(String[] args) throws IOException {
        /**
         * 设计：文本--->
         */
        String pdfBase64Text = PdfTest.file2Base64("E:\\pdf-test\\TB1.pdf");
        //把文本转化成pdf
        base64TextFromPdf2JPG(pdfBase64Text);
        return;
    }

    /**
     * 从pdf的base64编码转化为jpg的pdf的base64编码
     *
     * @param pdfBase64Text pdf的编码
     * @return jpg的base64编码集合（一张图片，一页pdf，一个数据）
     */
    private static List<String> base64TextFromPdf2JPG(String pdfBase64Text) throws IOException {
        final int defaultWidth = 792;
        final int defaultHeight = 1182;
        return base64TextFromPdf2JPG(pdfBase64Text, defaultWidth, defaultHeight);
    }

    /**
     * 从pdf的base64编码转化为jpg的pdf的base64编码
     *
     * @param pdfBase64Text pdf的编码
     * @param width         目标的jpg的宽度
     * @param height        目标的jpg的高度
     * @return jpg的base64编码集合（一张图片，一页pdf，一个数据）
     */
    private static List<String> base64TextFromPdf2JPG(String pdfBase64Text, int width, int height) throws IOException {
        //开始处理业务
        byte[] pdfTextBytes = decoder.decodeBuffer(pdfBase64Text);
        //创造byteBuffer文件
        ByteBuffer byteBuffer = ByteBuffer.wrap(pdfTextBytes);
        //创造pdf文件
        PDFFile pdfFile = new PDFFile(byteBuffer);
        List<String> jpgBase64Texts = new ArrayList<>();
        // 图片宽度
        for (int i = 1; i <= pdfFile.getNumPages(); i++) {
            PDFPage page = pdfFile.getPage(i);
            // get the width and height for the doc at the default zoom
            int recWidth = (int) page.getBBox().getWidth();
            int recHeight = (int) page.getBBox().getHeight();
            Rectangle rect = new Rectangle(0, 0, recWidth, recHeight);
            // generate the image，drawbg:fill background with white,wait:block until drawing is done
            Image img = page.getImage(width, height, rect, null, true, true);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(img, 0, 0, width, height, null);
            //保存到byteOutputStream中
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(tag, "JPEG", bos);
            jpgBase64Texts.add(encoder.encode(bos.toByteArray()));
            bos.close();
        }
        return jpgBase64Texts;
    }
}
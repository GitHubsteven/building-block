package fileconverter;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:52 2018/10/23.
 */
public class PdfTest {
    private final static BASE64Encoder encoder = new BASE64Encoder();

    private final static BASE64Decoder decoder = new BASE64Decoder();

    /**
     * 保存面单.
     *
     * @param pdfUrl      pdf路径
     * @param saveFileDir 保存的本地路径
     * @return 保存的本地路径
     */
    private static String saveWaybill(String pdfUrl, String saveFileDir) throws Exception {

//        String saveDir = WmsPathUtil.getWaybillSybPath().resolve(saveFileDir).toString();
        String saveDir = "E:\\dir4pdftest";
        File file = new File(saveDir);
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdirs();
        }
        InputStream inStream = null;


        if (pdfUrl.contains("https")) {
            URL fileURL = new URL(pdfUrl);
            inStream = fileURL.openStream();
        } else {
            inStream = new FileInputStream(pdfUrl);
        }
        return inputStream2Jpg(saveFileDir, saveDir, inStream);
    }

    private static String inputStream2Jpg(String saveFileDir, String saveDir, InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();

        byte[] b = new byte[1024 * 1024];
        int len;
        String fileName = new Date().getTime() + "";
        while ((len = inStream.read(b)) != -1) {
            swapStream.write(b, 0, len);
        }
        String outFimeName = saveDir + "/" + fileName + ".jpg";
        saveFileDir = saveFileDir + fileName + ".jpg";
        ByteBuffer buff = ByteBuffer.wrap(swapStream.toByteArray());
        PDFFile pdffile = new PDFFile(buff);

        // 图片宽度
        //int width = 812;
        // 图片长度
        //int height = 1218;

        // 图片宽度
        //int width = 810;
        // 图片长度
        //int height = 1217;

        // 图片宽度
        int width = 792;
        // 图片长度
        int height = 1182;

        for (int i = 1; i <= pdffile.getNumPages(); i++) {
            // draw the first page to an image
            PDFPage page = pdffile.getPage(i);

            // get the width and height for the doc at the default zoom
            Rectangle rect = new Rectangle(0, 0, (int) page.getBBox()
                    .getWidth(), (int) page.getBBox().getHeight());

            // generate the image
            Image img = page.getImage(width, height, // width &
                    // height
                    rect, // clip rect
                    null, // null for the ImageObserver
                    true, // fill background with white
                    true // block until drawing is done
            );

            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(img, 0, 0, width, height, null);
//			FileOutputStream out = new FileOutputStream(saveDir + fileName + i
//					+ ".jpg"); // 输出到文件流

            //FileOutputStream out = new FileOutputStream(saveDir + fileName + ".jpg"); // 输出到文件流
            FileOutputStream out = new FileOutputStream(outFimeName); // 输出到文件流

//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//            JPEGEncodeParam param2 = encoder.getDefaultJPEGEncodeParam(tag);
//            param2.setQuality(1f, true);
//            encoder.setJPEGEncodeParam(param2);
//            encoder.encode(tag); // JPEG编码

            //
            ImageIO.write(tag, "JPEG", out);
            out.close();
        }

        swapStream.flush();
        swapStream.close();
        inStream.close();
        return saveFileDir;
    }

    public static String file2Base64(String jpgUrl) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
//        encoder.encode();
        //获取byte流
        byte[] jpgByte = FileUtils.readFileToByteArray(new File(jpgUrl));
        return encoder.encode(jpgByte);
    }

    //base64字符串转化成图片
    public static boolean generateImage(String imgStr,String imgFilePath)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static void str2pdf(String base64Text, String targetFile) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] textBytes = decoder.decodeBuffer(base64Text);

        ByteArrayInputStream bis = new ByteArrayInputStream(textBytes);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(bis);

        File file = new File(targetFile);
        FileOutputStream fos = new FileOutputStream(file);

        BufferedOutputStream bfos = new BufferedOutputStream(fos);
        byte[] buffer = new byte[1024];

        int length = bufferedInputStream.read(buffer);
        while (length != -1) {
            bfos.write(buffer, 0, length);
            length = bufferedInputStream.read(buffer);
        }
        bfos.flush();
    }


    public static void jpg2Base64() {
        String str = "Man";
        BASE64Encoder encoder = new BASE64Encoder();

        BASE64Decoder decoder = new BASE64Decoder();
//        decoder.decodeBuffer()
        String base64Str = encoder.encode(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(base64Str);
    }

    public static void main(String[] args) throws Exception {
//        jpg2Base64();


        String saveFileDir = "E:\\dir4pdftest\\jpg";
        String pdfUrl = "E:\\pdf-test\\TB1.pdf";
        String targetPdfUrl = "E:\\pdf-test\\TB1_2.pdf";
//        saveWaybill(pdfUrl, saveFileDir);
        String sourceJpg = "E:\\dir4pdftest\\123.jpg";
        String targetJpg = "E:\\dir4pdftest\\123_fromPdf2.jpg";
//        String jpgBase64Str = file2Base64(sourceJpg);
//        System.out.println(jpgBase64Str);
//        JpgTest.str2jpg(jpgBase64Str, targetJpg);

        String pdfBase64Str = file2Base64(pdfUrl);
//        str2pdf(pdfBase64Str,targetPdfUrl);
//        JpgTest.str2jpg(jpgBase64Str, targetJpg);
        System.out.println(pdfBase64Str);
        /**
         * 已知数据：pdf的base64的String，
         * 分析：base644pdf--->.pdf---->.jpg------>base644jpg
         *
         *
         *
         *
         * 求：jpg的base64的String
         */

//        BufferedImage imageBuffer = ImageIO.read(new File(""));
//        ImageIO.write(imageBuffer, "", new FileOutputStream(""));
        String pdfBase64str = "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ODE0IDkzOSA1MDAgNzcxMiBbIDUwMCBdIDc3MTYgWyA1MDAgXSBdDQo+Pg0KZW5kb2JqDQo1IDAgb2JqDQo8PA0KL1R5cGUgL0ZvbnQNCi9OYW1lIC9GMQ0KL0Jhc2VGb250IC8jQ0IjQ0UjQ0MjRTUsQm9sZA0KL1N1YnR5cGUgL1R5cGUwDQovRGVzY2VuZGFudEZvbnRzIFs5IDAgUl0NCi9FbmNvZGluZyAvR0JLLUVVQy1IDQo+Pg0KZW5kb2JqDQo5IDAgb2JqDQo8PA0KL1R5cGUgL0ZvbnQNCi9TdWJ0eXBlDQovQ0lERm9udFR5cGUyDQovQmFzZUZvbnQgLyNDQiNDRSNDQyNFNSxCb2xkDQovV2luQ2hhclNldCAxMzQNCi9Gb250RGVzY3JpcHRvciA8PA0KL1R5cGUgL0ZvbnREZXNjcmlwdG9yDQovRm9udE5hbWUgLyNDQiNDRSNDQyNFNSxCb2xkDQovRmxhZ3MgNg0KL0ZvbnRCQm94IFstOCAtMTQxIDEwMDAgODU5IF0NCi9TdHlsZSA8PCAvUGFub3NlIDwwMTA1MDIwMjA0MDAwMDAwMDAwMDAwMDA+ID4+DQovQXNjZW50IDg1OQ0KL0Rlc2NlbnQgLTE0MQ0KL0NhcEhlaWdodCAxMDAwDQovU3RlbVYgMTY2DQovSXRhbGljQW5nbGUgMA0KPj4NCi9DSURTeXN0ZW1JbmZvDQo8PA0KL1JlZ2lzdHJ5KEFkb2JlKQ0KL09yZGVyaW5nKEdCMSkNCi9TdXBwbGVtZW50IDINCj4+DQovRFcgMTAwMA0KL1cgWyAxIDk1IDUwMCA4MTQgOTM5IDUwMCA3NzEyIFsgNTAwIF0gNzcxNiBbIDUwMCBdIF0NCj4+DQplbmRvYmoNCjYgMCBvYmoNCjw8DQovVHlwZSAvRm9udA0KL05hbWUgL0YyDQovQmFzZUZvbnQgL01TIzIwU2hlbGwjMjBEbGcNCi9TdWJ0eXBlIC9UeXBlMA0KL0Rlc2NlbmRhbnRGb250cyBbMTAgMCBSXQ0KL0VuY29kaW5nIC9HQkstRVVDLUgNCj4+DQplbmRvYmoNCjEwIDAgb2JqDQo8PA0KL1R5cGUgL0ZvbnQNCi9TdWJ0eXBlDQovQ0lERm9udFR5cGUyDQovQmFzZUZvbnQgL01TIzIwU2hlbGwjMjBEbGcNCi9XaW5DaGFyU2V0IDEzNA0KL0ZvbnREZXNjcmlwdG9yIDw8DQovVHlwZSAvRm9udERlc2NyaXB0b3INCi9Gb250TmFtZSAvTVMjMjBTaGVsbCMyMERsZw0KL0ZsYWdzIDYNCi9Gb250QkJveCBbLTU4MCAtMjU3IDE0NzMgMTAwMyBdDQovU3R5bGUgPDwgL1Bhbm9zZSA8MDEwNTAyMDIwNDAwMDAwMDAwMDAwMDAwPiA+Pg0KL0FzY2VudCA3MjgNCi9EZXNjZW50IC0yMTANCi9DYXBIZWlnaHQgMTEzMg0KL1N0ZW1WIDg4DQovSXRhbGljQW5nbGUgMA0KPj4NCi9DSURTeXN0ZW1JbmZvDQo8PA0KL1JlZ2lzdHJ5KEFkb2JlKQ0KL09yZGVyaW5nKEdCMSkNCi9TdXBwbGVtZW50IDINCj4+DQovRFcgMTAwMA0KL1cgWyAxIDk1IDUwMCA4MTQgOTM5IDUwMCA3NzEyIFsgNTAwIF0gNzcxNiBbIDUwMCBdIF0NCj4+DQplbmRvYmoNCjEgMCBvYmoNCjw8DQovVHlwZSAvUGFnZXMNCi9LaWRzIFs3IDAgUiBdDQovQ291bnQgMQ0KPj4NCmVuZG9iag0KMTEgMCBvYmoNCjw8DQovUHJvZHVjZXIgPEZFRkYwMDQ3MDA3MjAwNjkwMDY0MDAyQjAwMkIwMDUyMDA2NTAwNzAwMDZGMDA3MjAwNzQwMDM1MDAyRTAwMzg+DQovQXV0aG9yIDxGRUZGOTUxMDZENkE4RjZGNEVGNjAwMjAwMDJEMDAyMDAwNjgwMDc0MDA3NDAwNzAwMDNBMDAyRjAwMkYwMDc3MDA3NzAwNzcwMDJFMDA3MjAwNzUwMDYyMDA3OTAwNkMwMDZGMDA2RTAwNjcwMDJFMDA2MzAwNkU+DQovU3ViamVjdCA8RkVGRjAwNDcwMDcyMDA2OTAwNjQwMDJCMDAyQjAwNTIwMDY1MDA3MDAwNkYwMDcyMDA3NDAwMzUwMDJFMDAzODAwMjAwMDQ1MDA3ODAwNzAwMDZGMDA3MjAwNzQwMDIwMDA1MDAwNDQwMDQ2Pg0KL0NyZWF0b3IgPEZFRkYwMDQ3MDA3MjAwNjkwMDY0MDAyQjAwMkIwMDUyMDA2NTAwNzAwMDZGMDA3MjAwNzQ+DQovVGl0bGUg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";
//        str2pdf(pdfBase64str, targetPdfUrl);
        String targetPdfUrl_backup = "E:\\pdf-test\\TB1_2_backup4.pdf";
        changePdfVersion(pdfBase64str, targetPdfUrl_backup);
//        String targetjpgUrl_backup = "E:\\pdf-test\\TB1_2_backup3.jpg";
//        convertByPdfBox(pdfBase64str, targetjpgUrl_backup);
    }


    public static void changePdfVersion(String source, String dest) {
        try {
//            File destFile = new File(dest);
            FileOutputStream fout = new FileOutputStream(dest);
            PdfReader reader = new PdfReader(decoder.decodeBuffer(source));

            PdfStamper stamper = new PdfStamper(reader, fout);
            stamper.getWriter().setPdfVersion(PdfWriter.PDF_VERSION_1_4);
            stamper.close();
            reader.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

//    public static void convertByPdfBox(String source, String targetFile) throws IOException {
////        PDDocument document = PDDocument.loadNonSeq(new File(pdfFilename), null);
//        PDDocument document = PDDocument.load(decoder.decodeBuffer(source));
//        PDFRenderer pdfRenderer = new PDFRenderer(document);
//        for (int page = 0; page < document.getNumberOfPages(); ++page) {
//            BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 1000, ImageType.RGB);
//
//            // suffix in filename will be used as the file format
//            ImageIO.write(bim, "JPG", new FileOutputStream(targetFile));
//        }
//        document.close();
//    }

}
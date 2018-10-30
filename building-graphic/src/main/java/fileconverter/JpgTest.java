package fileconverter;

import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:52 2018/10/23.
 */
public class JpgTest {

    public static void main(String[] args) {
        createPng();
    }

    private static void createPng() {
        try {
            String sourceData = "";
//            test(sourceData);
            str2jpg(sourceData, "D:\\1620.jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test(String sourceData) throws IOException {
        // tokenize the data
        String[] parts = sourceData.split(",");
        String imageString = parts[1];

        // create a buffered image
        BufferedImage image;
        byte[] imageByte;

        BASE64Decoder decoder = new BASE64Decoder();
        imageByte = decoder.decodeBuffer(imageString);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        image = ImageIO.read(bis);
        bis.close();

        // write the image to a file
        File outputfile = new File("E:\\dir4pdftest\\image.png");
        ImageIO.write(image, "png", outputfile);
    }

    public static void str2jpg(String base64jpg, String outputFile) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(base64jpg);

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage = ImageIO.read(bis);
        FileOutputStream fout = new FileOutputStream(new File(outputFile));

//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "JPEG", fout);
        bis.close();
        ;
        fout.close();
    }


}
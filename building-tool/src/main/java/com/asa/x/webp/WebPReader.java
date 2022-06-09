package com.asa.x.webp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/5/26
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class WebPReader {
    private static final String img_url = "https://fr.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-sac-petite-bo%C3%AEte-chapeau-cuir-de-crocodile-brillant-sacs-%C3%A0-main--N96253_PM2_Front%20view.jpg";

    public static void main(String[] args) throws Exception {
        URL url = new URL(img_url);
        BufferedImage imageReader = ImageIO.read(url);
        System.out.println(imageReader.getWidth());
    }
}

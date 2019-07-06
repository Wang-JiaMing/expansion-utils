package com.expansion.file;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;

/**
 * @projectName:expansion-utils
 * @packageName:com.expansion.file
 * @authorName:wangjiaming
 * @createDate:2019-06-22
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class FileUtils {

    public static void main(String[] args) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");


            File f = new File("/Users/wangjiaming/Downloads/1.png");
            BufferedImage bi;

            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            md.update(bytes);

            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

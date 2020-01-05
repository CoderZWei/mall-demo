package com.zw.malldemo.util;

import com.zw.malldemo.dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    //private static String sBasePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static String sBasePath =ImageUtil.class.getClassLoader().getResource(".").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将CommonsMultipartFile转换成File类
     *
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IllegalStateException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 处理缩略图，并返回新生成图片的相对值路径
     *
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
        // 获取不重复的随机名
        String readFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAddr);
        logger.info("target:"+targetAddr);
        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = targetAddr + readFileName + extension;

        File destFile = new File(PathUtil.getImageBasePath() + relativeAddr);
        // 调用Thumbnails生成带有水印的图片
        try {
            Thumbnails.of(thumbnail.getImage()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(sBasePath + "\\watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(destFile);
        } catch (IOException e) {
            logger.error("error:"+sBasePath);
            throw new RuntimeException();
            //e.printStackTrace();
        }
        // 返回图片相对路径地址
        return relativeAddr;
    }

    public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
        // 获取不重复的随机名
        String realFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAddr);
        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = targetAddr + realFileName + extension;
        File destFile = new File(PathUtil.getImageBasePath() + relativeAddr);
        // 调用Thumbnails生成带有水印的图片
        try {
            Thumbnails.of(thumbnail.getImage()).size(337, 640)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(sBasePath + "\\watermark.jpg")), 0.25f)
                    .outputQuality(0.9f).toFile(destFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        // 返回图片相对路径地址
        return relativeAddr;
    }

    public static String getRandomFileName() {
        // 获取随机的五位数
        int randNum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + randNum;
    }

    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImageBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    public static void main(String[] args) {
        try {
            Thumbnails.of(new File("D:\\webapp\\imgDir\\pic.jpg")).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(sBasePath + "\\watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile("D:\\webapp\\imgDir\\picNew.jpg");
        } catch (IOException e) {
            logger.error(sBasePath);
            e.printStackTrace();
        }
    }

    public static void deleteFileOrPath(String storePath){
        File fileOrPath = new File(PathUtil.getImageBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

}

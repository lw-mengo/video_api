package com.mengo.api.video.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 处理文件存储
 */
public class FileSaveUtil {
    private static final String PATH_URL = "F:\\upload\\";
    public static String getFilePath(String fileName) {
        if (fileName.contains("\\")){
            int pos = fileName.lastIndexOf("\\")+1;
            fileName = fileName.substring(pos);
        }
        String filePath =  fileName;
        return filePath;
    }

    public static void saveFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.contains("\\")){
            int pos = fileName.lastIndexOf("\\")+1;
            fileName = fileName.substring(pos);
        }
        File f = new File(PATH_URL + fileName);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdir();
        } else {
            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

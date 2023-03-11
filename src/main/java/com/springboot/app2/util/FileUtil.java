package com.springboot.app2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtil {

    public static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static String loadAsString(String path) {
        try {
            File resource = new ClassPathResource(path).getFile();
            return new String(Files.readAllBytes(resource.toPath()));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

}

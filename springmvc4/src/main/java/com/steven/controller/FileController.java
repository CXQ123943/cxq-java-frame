package com.steven.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author CXQ
 * @version 1.0
 */
@Controller
@RequestMapping("/api/file")
public class FileController {
    
    @ResponseBody
    @RequestMapping("upload")
    public String upload(@RequestParam("avatar") MultipartFile avatar) throws IOException {
        String descPath = "E:" + File.separator + "upload" + File.separator
                + System.currentTimeMillis() + avatar.getOriginalFilename();

        File descFile = new File(descPath);
        if (!descFile.getParentFile().exists()) {
            System.out.println(descFile.getParentFile().mkdirs());
        }
        if (!avatar.isEmpty()) {
            avatar.transferTo(descFile);
        }
        return "ok";
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(String file) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(new File("E:\\upload\\" + file));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", file);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }
}
package com.tonny.first.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);
    @GetMapping("/upload")
    public String upload()
    {
        return "upload";
    }
    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file)
    {
        if(file.isEmpty())
        {
            return "upload file failure!";
        }
        String fileName =file.getOriginalFilename();
        String filePath ="E:/tonny/file/";
        File dest =new File(filePath+fileName);
        try{
            file.transferTo(dest);
            LOG.info("----print io upload file success!");
            return "upload success!";
        }catch(IOException e )
        {
            e.printStackTrace();
        }
        return "upload failure!";
    }
}

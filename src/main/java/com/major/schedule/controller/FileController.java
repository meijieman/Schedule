package com.major.schedule.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller("/")
public class FileController {

    public static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${downloadfile.dir}")
    private String dir;

    // http://localhost:8080/download?filename=XFRB303_A004_APP_debug_1.0.1201-8b6538c37e99aec03eec2d9d44381c98.bin
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(@RequestParam("filename") String filename, HttpServletResponse res) {
        log.info("请求下载 " + filename);
        File file = new File(dir, filename);
        log.info("下载地址 path " + file.getAbsolutePath());
        if (!file.exists()) {
            throw new RuntimeException("file not exist");
        }
        long length = file.length();
        log.info("文件大小 " + length);

        res.setHeader("content-type", "application/octet-stream");
        res.setContentLength((int) length);
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + filename);
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buff = new byte[1024];
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, i);
                i = bis.read(buff);
            }
            log.info("成功");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("出错 " + e);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

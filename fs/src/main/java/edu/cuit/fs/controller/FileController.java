package edu.cuit.fs.controller;

import com.google.gson.Gson;
import edu.cuit.fs.domain.data;
import edu.cuit.fs.utils.FileSystemUtil;
import edu.cuit.fs.utils.fileUtil;
import edu.cuit.fs.utils.userFiles;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class FileController {

    @Autowired
    private Gson gson;


    @RequestMapping(value = "/upload",  method = RequestMethod.POST, produces = "multipart/form-data")
    @ResponseBody
    public String uploadFile(@RequestParam MultipartFile file, @RequestParam String username, @RequestParam String  hash, @RequestParam String  location) throws URISyntaxException, IOException, InterruptedException, FileUploadException {
        data res = new data();
        fileUtil FU = new fileUtil();
        try {
            res.data.add(file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            String md5 = DigestUtils.md5DigestAsHex(bytes);
            System.out.println(md5);
            if (!hash.equals(md5)){
                res.code = -1;
                res.description = "文件校验失败，检测网络环境后请重新上传";
                return gson.toJson(res);
            }
            System.out.println(location);
            FileSystemUtil fileSystemUtil = new FileSystemUtil();
            FileSystemUtil.init();
            String  path = FU.getPath(hash);
            FSDataOutputStream fos = (FSDataOutputStream) fileSystemUtil.getOutputStream(path);
            fos.write(bytes,0,bytes.length);
            res.code = 0;
            res.description = "文件上传成功！";
        }catch (Exception e){
            e.printStackTrace();
            res.code = -2;
            res.description = "有人拔掉了服务器的网线";
        }finally {
            FileSystemUtil.close();
        }
        return gson.toJson(res);
    }
}

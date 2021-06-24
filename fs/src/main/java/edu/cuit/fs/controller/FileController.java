package edu.cuit.fs.controller;

import com.google.gson.Gson;
import edu.cuit.fs.domain.data;
import edu.cuit.fs.utils.FileSystemUtil;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.URISyntaxException;

@CrossOrigin
@RestController
public class FileController {

    @Autowired
    private Gson gson;

    @RequestMapping(value = "/upload",  method = RequestMethod.POST, produces = "multipart/form-data")
    @ResponseBody
    public String uploadFile(@RequestParam MultipartFile file, @RequestParam String username, @RequestParam String  hash) throws URISyntaxException, IOException, InterruptedException, FileUploadException {
        data res = new data();
        try {
            res.data.add(file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            FileSystemUtil fileSystemUtil = new FileSystemUtil();
            FileSystemUtil.init();
            FSDataOutputStream fos = (FSDataOutputStream) fileSystemUtil.getOutputStream("/" + file.getOriginalFilename());
            fos.write(bytes,0,bytes.length);
            FileSystemUtil.close();
            res.code = 0;
        }catch (Exception e){
            e.printStackTrace();
            res.code = -2;
            FileSystemUtil.close();
        }finally {
            FileSystemUtil.close();
        }
        return gson.toJson(res);
    }
}

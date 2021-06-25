package edu.cuit.fs.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class FileSystemUtil {
    private static final String IP = "192.168.10.132";
    private static final String PATH = "hdfs://"+ IP +":9000";
    public static FileSystem fs = null;
    public static void init(){
        try {
            URI uri = new URI(PATH);
            fs = FileSystem.get(uri, new Configuration());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(){
        try {
            if (fs != null)  fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mkdir(String path){
        Path srcPath = new Path(path);
        try {
            fs.mkdirs(srcPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OutputStream getOutputStream(String path){
        FSDataOutputStream outputStream = null;
        Path srcPath = new Path("/user" + path);
        try {
            outputStream = fs.create(srcPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    public static void rename(String oldName, String newName){
        Path olePath = new Path(oldName);
        Path newOath = new Path(newName);
        try {
            fs.rename(olePath, newOath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getData(String src){
        Path path = new Path(src);
        FSDataInputStream inputStream = null;
        try {
            inputStream = fs.open(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

}

package edu.cuit.fs.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class FileSystemUtil {
    private static final String IP = "192.168.10.131";
    private static final String PATH = "hdfs://"+ IP +":9000";
    public static FileSystem fs = null;
    static {
        try {
            URI uri = new URI(PATH);
            fs = FileSystem.get(uri, new Configuration());
        }catch (Exception e){
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

    public static void createFiles(String path, byte[] contents){
        FSDataOutputStream outputStream = null;
        Path srcPath = new Path(path);
        try {
            outputStream = fs.create(srcPath);
            outputStream.write(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public static InputStream getData(String src){
        Path path = new Path(src);
        try {
            FSDataInputStream in = fs.open(path);
            return in;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

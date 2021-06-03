package edu.cuit.fs.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.net.URI;

public class FileSystemUtil {
    private static final String PATH = "hdfs://192.168.10.128:9000";
    public static FileSystem fs = null;
    static {
        try {
            URI uri = new URI(PATH);
            fs = FileSystem.get(uri, new Configuration());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package edu.cuit.fs.utilTest;

import edu.cuit.fs.domain.file;
import edu.cuit.fs.utils.userFiles;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class userFilesTest {

    @Test
    public void test(){
        userFiles ufs = new userFiles("123456");
        List<file> list = new LinkedList<>();
        file f = new file();
        f.setLocation(list.size() + 1 + "");
        f.setFilename("demoTest");
        f.setDir(false);
        List<file> t = new LinkedList<>();
        t.add(f);
        list.add(f);

        f.setLocation(list.size() + 1 + "");
        f.setFilename("demoTest1");
        f.setDir(true);
        f.setList(t);
        ufs.setFiles(list).insertFiles();
    }

}

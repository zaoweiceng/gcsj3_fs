package edu.cuit.fs.utilTest;

import edu.cuit.fs.domain.file;
import edu.cuit.fs.utils.userFiles;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class userFilesTest {

    @Test
    public void test() {
        userFiles usf = new userFiles("123456");
        String res = usf.setFiles(new LinkedList<>())
                .insertFiles(false, "demo.txt", "0", "asdasdasd")
                .insertFiles(false, "text.txt", "0", "asdasdasd")
                .insertFiles(true, "A", "1", 0)
                .insertFiles(true, "b", "2", 0)
                .insertFiles(true, "C", "1_2", 0)
                .insertFiles(true, "D", "1_3", 0)
                .insertFiles(false, "b.aaa", "1_1", "asasdasd")
                .insertFiles(false, "asda", "1_2_1", "asasdasd")
                .toString();
        System.out.println(res);
    }

    @Test
    public void saveTest() {
        userFiles usf = new userFiles("zaoweiceng");
        usf.setFiles(new LinkedList<>())
                .insertFiles(false, "demo.txt", "0", "asdasdasd")
                .insertFiles(false, "text.txt", "0", "asdasdasd")
                .insertFiles(true, "A", "1", 0)
                .insertFiles(true, "b", "2", 0)
                .insertFiles(true, "C", "1_2", 0)
                .insertFiles(true, "D", "1_3", 0)
                .insertFiles(false, "b.aaa", "1_1", "asasdasd")
                .insertFiles(false, "asda", "1_2_1", "asasdasd")
                .saveFileInfo();
    }

    @Test
    public void getTest(){
        userFiles usf = new userFiles("zaoweiceng");
        System.out.println(usf.init().toString());
    }

}

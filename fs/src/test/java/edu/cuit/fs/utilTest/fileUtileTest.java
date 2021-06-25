package edu.cuit.fs.utilTest;

import edu.cuit.fs.utils.fileUtil;
import org.junit.Test;

public class fileUtileTest {

    @Test
    public void test(){
        fileUtil fu = new fileUtil();
        String path = fu.getPath("456cdee4717c158ca09e84a18b8c66a2");
        System.out.println(path);
    }
}

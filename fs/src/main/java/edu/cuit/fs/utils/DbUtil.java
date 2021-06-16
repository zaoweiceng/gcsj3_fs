package edu.cuit.fs.utils;
import edu.cuit.fs.domain.userInfo;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class DbUtil {

    private static final String IP = "192.168.10.132";
    private static final String HOST = "hdfs://" + IP +":9000/hbase";
    private static final String ZK_PORT = "2181";
    public static Configuration configuration = null;
    public static Connection connection = null;
    public static Admin admin = null;

    public static String getData(String tableName, String rowKey, String colFamily, String col) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(rowKey.getBytes());
        get.addColumn(colFamily.getBytes(), col.getBytes());
        Result result = table.get(get);
        String res = new String(result.getValue(colFamily.getBytes(), col.getBytes()));
        table.close();
        return res;
    }

    public static void insertData(String tableName, String rowKey, String colFamily, String col, String val) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(rowKey.getBytes());
        put.addColumn(colFamily.getBytes(), col.getBytes(), val.getBytes());
        table.put(put);
        table.close();
    }

    public static void createTable(String tableName, String[] colName) throws IOException {
        TableName tbName = TableName.valueOf(tableName);
        if (admin.tableExists(tbName)){
            System.out.println("table exist");
        }else {
            HTableDescriptor hTableDescriptor = new HTableDescriptor(tbName);
            for (String str: colName){
                HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(str);
                hTableDescriptor.addFamily(hColumnDescriptor);
            }
            admin.createTable(hTableDescriptor);
        }
    }

    public static void close(){
        try {
            if (admin != null){
                admin.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void init(){
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.rootdir", HOST);
        configuration.set("hbase.zookeeper.quorum", IP);
        configuration.set("hbase.zookeeper.property.clientPort", ZK_PORT);
        try {
            connection = ConnectionFactory.createConnection(configuration);
            admin = connection.getAdmin();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

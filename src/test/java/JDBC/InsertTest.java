package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author pzy
 * @create 2023-11-10-14:17
 * @function
 * PrepareStatement实现数据的批量操作
 */
public class InsertTest {
//    在MySQL配置文件url后面添加?rewriteBatchedStatements=true开启MySQL的批处理操作
    @Test
    public void insertdate(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            String sql = "insert into new_table(`id`) values (?)";
            ps = connection.prepareStatement(sql);
            for (int i = 0; i <= 100000; i++) {
                ps.setObject(1,i);
                ps.addBatch();
                if (i % 500 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            long stop = System.currentTimeMillis();
            System.out.println(stop - start);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection,ps);
        }
    }
}

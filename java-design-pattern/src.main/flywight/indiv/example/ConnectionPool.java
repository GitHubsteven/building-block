package flywight.indiv.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.stream.IntStream;

public class ConnectionPool {
    private Vector<Connection> pool;

    /*公有属性*/
    private String url = "you url";
    private String root = "root";
    private String password = "123456";

    private String driverClassName = "com.mysql.jdbc.Driver";

    private int POOL_SIZE = 100;
    private static ConnectionPool instance = null;
    Connection connection = null;

    ConnectionPool() {
        pool = new Vector<>(POOL_SIZE);
        IntStream.range(0, POOL_SIZE).forEach(i -> {
            try {
                Class.forName(driverClassName);
                connection = DriverManager.getConnection(url, root, password);
                pool.add(connection);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 返回连接到连接池
     */
    public synchronized void relase() {
        pool.add(connection);
    }

    /**
     * 为什么要建立多个相同的链接呢？连接池中有多个相同的链接，有意义吗？
     * 拓展：链接jdbc中，一个连接不会不能重用吗？java和sql之间的并发是通过多线程来是实现的吗?
     *
     * @return 获取一个链接
     */
    public synchronized Connection getConnection() {
        if (pool.size() <= 0) return null;
        Connection con = pool.get(0);
        pool.remove(con);
        return con;
    }

}

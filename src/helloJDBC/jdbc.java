package helloJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

    public static void main(String[] args) throws Exception {
        //要连接的数据库URL
        String url = "jdbc:mysql://127.0.0.1:3306/test/dongnao";
        //连接的数据库时使用的用户名
        String username = "root";
        //连接的数据库时使用的密码
        String password = "";
        //JDBC Driver命名
        final String JDBC_DRIVER="com.mysql.jdbc.Driver";
        
        Connection conn=null;
        Statement st=null;
        ResultSet rs =null;
        
        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());不推荐使用这种方式来加载驱动
        //Class.forName("com.mysql.jdbc.Driver");//推荐使用这种方式来加载驱动
        Class.forName(JDBC_DRIVER);
        //2.获取与数据库的链接
        conn = DriverManager.getConnection(url, username, password);
        
        //3.获取用于向数据库发送sql语句的statement

        try {
//        String sql1 = "insert into user(id,name,address) values(5,'aaa','address1')";
//        String sql2 = "insert into user(id,name.address) values(6,'bbb','address2')";
//        String sql3 = "insert into user(id,name) values(7,'CCC')";
//        String sql4 = "insert into user(id,name) values(8,'DDD')";
//        String sql5 = "update user set name='gacl' where id=1";
//        String sql6 = "insert into user(id,name) values(5,'FFF')";
//        String sql7 = "delete from user where id=2";
        //添加要批量执行的SQL
        st = conn.createStatement();
//        st.addBatch(sql1);
        rs=st.executeQuery("SELECT * FROM `test`;");
        //4.向数据库发sql,并获取代表结果集的resultset
//        st.executeBatch();
//        st.clearBatch();

        //5.取出结果集的数据
        System.out.println("--------------");
        while(rs.next()){
           
            System.out.print(rs.getObject("id"));
            System.out.println();
        }}catch (SQLException e) {
			// TODO: handle exception
        	e.printStackTrace();
		}finally {
			//对程序的异常处理
			//6.关闭链接，释放资源
			conn.close();
			rs.close();
	        st.close();       
    
}}}
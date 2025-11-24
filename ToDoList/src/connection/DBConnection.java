package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection con=null;
    String url="jdbc:mysql://localhost:3306/task";
    String username="root";
    String password="root";
    public Connection getConnection() throws SQLException
    {
        con=DriverManager.getConnection(url, username, password);
        return con;
    }

    public void CloseConnection() throws SQLException
    {
        con.close();
    }


    
}

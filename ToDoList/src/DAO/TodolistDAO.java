package DAO;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Todo;
import connection.DBConnection;

public class TodolistDAO{
    DBConnection connection=new DBConnection();

    public boolean addTask(Todo t) throws SQLException
    {
        String task_name=t.getTask_name();
        String author_name=t.getAuthor_name();
        String task_status=t.getTask_status();
        Connection con=connection.getConnection();
        String query="insert into Todo(task_name, author_name, task_status) values(?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,task_name);
        ps.setString(2, author_name);
        ps.setString(3, task_status);
        if(ps.executeUpdate()>0)
            return true;
        else
            return false;

    }
    public void viewTask()
    {
        try
        {
        Connection con=connection.getConnection();
        String query="select * from Todo";
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery(query);
        while(rs.next())
        {
            System.out.println(rs.getInt("task_id")+"\t"+rs.getString("task_name")+"\t"
        +rs.getString("author_name")+"\t"+rs.getString("task_status"));
        }
        rs.close();
        s.close();
        con.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }

    public boolean deleteTask(int task_id) throws SQLException
    {
        Connection con=connection.getConnection();
        String query="delete from todo where task_id=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1, task_id);
        if(ps.executeUpdate()>0)
            return true;
        else
            return false;
    }

    public boolean updateTask(int task_id, String task_status) throws SQLException
    {
        Connection con=connection.getConnection();
        String query1="update todo set task_status=? where task_id=?";
        PreparedStatement ps=con.prepareStatement(query1);
        ps.setString(1, task_status);
        ps.setInt(2, task_id);
        if(ps.executeUpdate()>0)
            return true;
        else
            return false;
   }


    
}



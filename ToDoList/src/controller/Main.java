package controller;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.TodolistDAO;
import Model.Todo;

public class Main {
    public static void main(String args[]) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
       
        TodolistDAO tdao=new TodolistDAO();
        int choice;
        

        do{
            System.out.println("****** Welcome to To Do List ******");
            System.out.println("1. Add New Task");
            System.out.println("2. View Task");
            System.out.println("3. Delete Task");
            System.out.println("4.Update Task");
            System.out.println("5.Exit");
            System.out.println("**************************");   
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            sc.nextLine();  

        switch(choice){
            case 1:
                Todo t=new Todo();
                System.out.println("Add new Task");
                System.out.println("Enter task name:");
                String task_name=sc.next();
                System.out.println("Enter Author name:");
                String author_name=sc.next();
                System.out.println("Enter Status of task:");
                String task_status=sc.next();
                t.setTask_name(task_name);
                t.setAuthor_name(author_name);
                t.setTask_status(task_status);
                if(tdao.addTask(t))
                    System.out.println("Task Added Successfully!!!");
                break;
            case 2:
                System.out.println("View Tasks");
                tdao.viewTask();
                break;
           
            case 3:
                System.out.println("Delete task");
                System.out.println("Enter task id to be deleted:");
                int task_id=sc.nextInt();
                if(tdao.deleteTask(task_id))
                    System.out.println("Task deleted Successfully");
                else
                    System.out.println("Error");
                break;
            case 4:
                System.out.println("Task Update");
                System.out.println("Enter the task_id to be updated:");
                task_id=sc.nextInt();
                System.out.println("Enter the task status to be updated:");
                task_status=sc.next();
                if(tdao.updateTask(task_id, task_status))
                    System.out.println("Task updated Sucessfully");
                else
                    System.out.println("Error");
                break;

            default:
                System.out.println("Invalid Choice");
           
        }
}while(choice!=5);
sc.close();
        
    }

}

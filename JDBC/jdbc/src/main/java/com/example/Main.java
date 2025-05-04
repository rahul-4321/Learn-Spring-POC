package com.example;

//import packages
import java.sql.*;

//import org.postgresql.Driver;


public class Main {
    public static void main(String[] args) throws SQLException {
        //Class.forName("org.postgresql.Driver");

        System.out.println("Hello world!");
        String url="jdbc:postgresql://localhost:5432/postgres";
        String user="postgres";
        String password="rahul";

        Connection conn=DriverManager.getConnection(url, user , password);
        //System.out.println(conn);

        Statement st=conn.createStatement();


        /*---------------------------------------------------Read--------------------------------------------------------------*/
        /*
        String query="select sname from student where sid=1";

        ResultSet res=st.executeQuery(query);

        //System.out.println(res.next()); //.next() gives the boolean value for the existance of the next data, it points the cursor to the next line. If it has next data, true is returned else false

        res.next();//As the cursor will be at before the data
        System.out.println(res.getString("sname"));

        //To get all the data from a table

        String q="select * from student order by sid asc";
        ResultSet res1=st.executeQuery(q);
        while(res1.next()){
            System.out.println(res1.getInt("sid")+"  "+res1.getString("sname")+"   "+res1.getInt("marks"));
        }
        */

/*---------------------------------------------------Create--------------------------------------------------------------*/
        /*
        String q2="insert into student values (12,'Rohit',10000)";
        Boolean status=st.execute(q2);
        System.out.println(status);
        */


/*---------------------------------------------------Update--------------------------------------------------------------*/
        /*
        String q3="update student set marks=500 where sname='Prince'";
        Boolean status=st.execute(q3);
        System.out.println(status);
        */

/*---------------------------------------------------Delete--------------------------------------------------------------*/
/*
        String q4="delete from student where sid=4";
        Boolean status=st.execute(q4);
        System.out.println(status);


 */
/*---------------------------------------------------Problem with 'Statement'--------------------------------------------------------------*/
        //when we want to insert user input data then we can't do it with Statement.execute() as it will think the variables it self as the data to be recorded
        //A walkaround solution is using alternate "+ va1+ " and '+var2+' 

                //Statement uses
                /*
                * structuring the table (alter, drop)
                * select queries
                * Always use PreparedStatement for select with where clause
                */
                //Others use PreparedStatement

        //A better solution is PreparedStatement

        String query5="insert into student values (?,?,?)";//we need to use '?' for dynamic data
        int sid=14;
        String sname="Bikash";
        int marks=1000;

        PreparedStatement pst=conn.prepareStatement(query5);
        pst.setString(2, sname);
        pst.setInt(1, sid);
        pst.setInt(3, marks);
        
        pst.execute();




        conn.close();
    }
}
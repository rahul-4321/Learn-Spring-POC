package com.rahul.springjdbc.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;


import java.util.List;


import com.rahul.springjdbc.model.Student;

@Repository
public class StudentRepo {

    JdbcTemplate jdbc;
    
    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    
    public void save(Student s){

        String sql="insert into student(roll_no,Sname, marks) values(?,?,?)";
        int x=jdbc.update(sql, s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(x+" row Added");
    }

    public List<Student> findAll(){

        String sql="select * from student";

       
        // RowMapper<Student> rowMapper=new RowMapper<Student>(){

        //     @Override
        //     public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        //         Student s=new Student();
        //         s.setRollNo(rs.getInt(1));
        //         s.setName(rs.getString(2));
        //         s.setMarks(rs.getInt(3));
        //         return s;
        //     }

        // };

        //lambda expression
        RowMapper<Student> rowMapper=(ResultSet rs, int rowNum) ->{
                Student s=new Student();
                s.setRollNo(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setMarks(rs.getInt(3));
                return s;
        };

        return jdbc.query(sql,rowMapper);

    }
}

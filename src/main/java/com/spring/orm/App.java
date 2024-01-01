package com.spring.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        //adding student in DB
        Student student =  new Student(5,"dani","usa");
        int result = studentDao.insert(student);
        System.out.println("Student added: "+result);
        
        //getting all students
        List<Student> allStudents = studentDao.getAllStudent();
        System.out.println("All Students: "+ allStudents);
        
        //getting student with id
        System.out.println(studentDao.getStudent(2));
        
        //updating student
        Student updatedStudent = new Student(3,"mia","usa");
        System.out.println(studentDao.update(updatedStudent));
        
        //deleting student with id
        studentDao.delete(4);
    }
}

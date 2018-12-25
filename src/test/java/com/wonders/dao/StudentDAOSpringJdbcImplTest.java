package com.wonders.dao;

import com.wonders.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentDAOSpringJdbcImplTest {

    private ApplicationContext applicationContext=null;
    private StudentDAO studentDAO=null;

    @Before
    public void setup(){
        applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        studentDAO= (StudentDAO) applicationContext.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        applicationContext = null;
        System.out.println("tearDown");
    }

    @Test
    public void testQuery() {
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " , name:" + student.getName()
                    + ", age:" + student.getAge());
        }

    }

    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("test-spring-jdbc");
        student.setAge(40);

        studentDAO.save(student);
    }

}

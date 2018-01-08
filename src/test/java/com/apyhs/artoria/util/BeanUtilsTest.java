package com.apyhs.artoria.util;

import com.apyhs.artoria.beans.BeanUtils;
import com.apyhs.artoria.entity.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BeanUtilsTest {

    @Test
    public void ifNull() {
    }

    @Test
    public void isNull() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void isArray() {
    }

    @Test
    public void cloneTest() {
    }

    @Test
    public void deepClone() {
    }

    @Test
    public void copyProperties() {
    }

    @Test
    public void copy1() {
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(19);
        student.setHeight(176d);
        student.setScore(89);
        student.setEmail("zhangsan@email.com");
        Map<String, Object> map = new HashMap<String, Object>();
        BeanUtils.copy(student, map);
        System.out.println(map);

        Student student1 = new Student();
        BeanUtils.copy(map, student1);
        System.out.println(student1);
    }

    @Test
    public void copy2() {
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(19);
        student.setHeight(176d);
        student.setScore(89);
        student.setEmail("zhangsan@email.com");
        System.out.println(student);

        Student student1 = new Student();
        BeanUtils.copy(student, student1);
        System.out.println(student1);

        student1.setAge(23);
        System.out.println(student);
        System.out.println(student1);
    }
}
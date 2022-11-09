package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {
    @Test
    public void testGetStudentsByScore(){
        Double[] s1Scores = {10.0,15.0,5.0};
        Student s1 = new Student("John","K",s1Scores);
        Double[] s2Scores = {10.0,30.0,20.0};
        Student s2 = new Student("Kevin", "P",s2Scores);
        Student s3 = new Student("Alex", "L",s1Scores);
        Student[] addThese = {s1,s2,s3};
        Classroom testClass = new Classroom(addThese);
//        testClass.addStudent(s1);
//        testClass.addStudent(s2);
//        testClass.addStudent(s3);
        Student [] actual = testClass.getStudentsByScore();
        Student [] expected = {s2,s3,s1};
        Assert.assertArrayEquals(expected,actual);
    }
}

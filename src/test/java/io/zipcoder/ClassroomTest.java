package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
    @Test
    public void testConstructorWithMax(){
        int max = 30;
        Classroom testClass = new Classroom(30);
        Assert.assertEquals(max,testClass.getStudents().length);
    }
    @Test
    public void testConstructorWithArray(){
        Student[] studentArr = new Student[0];
        Classroom testClass = new Classroom(studentArr);
        Assert.assertEquals(testClass.getStudents(),studentArr);
    }
    @Test
    public void testNullaryConstructor(){
        int len = 30;
        Classroom testClass = new Classroom();
        Assert.assertEquals(testClass.getStudents().length, len);
    }
    @Test
    public void testGetStudents(){
        Double[] s1Scores = {10.0,15.0,5.0};
        Student s1 = new Student("John","K",s1Scores);
        Double[] s2Scores = {10.0,30.0,20.0};
        Student s2 = new Student("Kevin", "P",s2Scores);
        Student s3 = new Student("Alex", "L",s1Scores);
        Student [] test = {s1,s2,s3};
        Classroom testClass = new Classroom(test);
        Assert.assertArrayEquals(test,testClass.getStudents());
    }
    @Test
    public void testGetAverageExamScore(){
        Double[] s1Scores = {10.0,15.0,5.0};
        Student s1 = new Student("John","K",s1Scores);
        Double[] s2Scores = {40.0,40.0,40.0};
        Student s2 = new Student("Kevin", "P",s2Scores);
        Student s3 = new Student("Alex", "L",s1Scores);
        Student [] test = {s1,s2,s3};
        Classroom testClass = new Classroom(test);

        Double expectedAvg = 20.0;
        Assert.assertEquals(testClass.getAverageExamScore(),expectedAvg);
    }
    @Test
    public void testAddStudent(){
        Student test = new Student("Kevin","Kevin?",null);
        Classroom tester = new Classroom();
        tester.addStudent(test);
        Assert.assertEquals(tester.getStudents()[tester.getStudents().length - 1],test);
    }
    @Test
    public void testRemoveStudent(){
        String first = "Kevin";
        String last = "Kevin?";
        Student test = new Student(first,last,null);
        Classroom tester = new Classroom();
        tester.addStudent(test); //add to the back
        tester.removeStudent(first,last); //remove from the back
        Assert.assertNotEquals(tester.getStudents()[tester.getStudents().length - 1], test); //should not be in the back
    }
    @Test
    public void testGetGradeBook(){


    }

}

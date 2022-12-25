package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

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
    public void testGetGradeBook_old(){
        Double[] s5Scores = {75.0,89.0,90.2,67.5};
        Double[] s1Scores = {10.0,15.0,5.0};
        Double[] s6Scores = {10.0,13.0,90.0};
        Double[] s3Scores = {100.0,15.0,50.0};
        Double[] s7Scores = {100.0,95.0,95.0};
        Double[] s8Scores = {88.0,65.0,95.0};
        Double[] s9Scores = {100.0};
        Double[] s10Scores ={80.0,80.0,80.0};
        Student s1 = new Student("John","K",s1Scores);
        Double[] s2Scores = {40.0,40.0,40.0};
        Student s2 = new Student("Kevin", "P",s2Scores);
        Student s3 = new Student("Alex", "L",s1Scores);
        Student s4 = new Student("Tay","L",s3Scores);
        Student s5 = new Student("T","L",s5Scores);
        Student s6 = new Student("Kell","D",s6Scores);
        Student s7 = new Student("Kell","D",s7Scores);
        Student s8 = new Student("Kell","D",s8Scores);
        Student s9 = new Student("Kell","D",s9Scores);
        Student s10 = new Student("Kell","D",s10Scores);
        Student [] test = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
        Classroom testClass = new Classroom(test);
        String actual = testClass.getGradeBook().toString();
        String expected = "{Kell | D | 100.0 | [100.0]=A, Kell | D | 96.7 | [100.0, 95.0, 95.0]=B, Kell | D | 82.7 | [88.0, 65.0, 95.0]=B, T | L | 80.4 | [75.0, 89.0, 90.2, 67.5]=C, Kell | D | 80.0 | [80.0, 80.0, 80.0]=C, Tay | L | 55.0 | [100.0, 15.0, 50.0]=D, Kevin | P | 40.0 | [40.0, 40.0, 40.0]=D, Kell | D | 37.7 | [10.0, 13.0, 90.0]=D, Alex | L | 10.0 | [10.0, 15.0, 5.0]=D, John | K | 10.0 | [10.0, 15.0, 5.0]=F}";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testGetGradeBook() {
        Student[] students = {
                new Student("Alice", "Smith", new Double[] {90.0, 80.0, 70.0, 60.0, 50.0}),
                new Student("Bob", "Johnson", new Double[] {60.0, 70.0, 80.0, 90.0, 100.0}),
                new Student("Charlie", "Williams", new Double[] {70.0, 80.0, 90.0, 100.0, 90.0}),
                new Student("Dave", "Jones", new Double[] {50.0, 60.0, 70.0, 80.0, 90.0}),
                new Student("Eve", "Brown", new Double[] {100.0, 90.0, 80.0, 70.0, 60.0}),
                new Student("Frank", "Davis", new Double[] {80.0, 70.0, 60.0, 50.0, 40.0}),
                new Student("Gary", "Miller", new Double[] {40.0, 50.0, 60.0, 70.0, 80.0}),
                new Student("Henry", "Moore", new Double[] {70.0, 70.0, 70.0, 70.0, 70.0}),
                new Student("Wally", "Silk", new Double[] {100.0}),
                new Student("Jimbo", "Bash", new Double[] {99.5}),
                new Student("Kim", "K", new Double[] {91.6})
        };

        Classroom classroom = new Classroom(students);

        LinkedHashMap<Student, String> gradeBook = classroom.getGradeBook();
        Assert.assertEquals("D", gradeBook.get(students[0]));
        Assert.assertEquals("C", gradeBook.get(students[1]));
        Assert.assertEquals("C", gradeBook.get(students[2]));
        Assert.assertEquals("D", gradeBook.get(students[3]));
        Assert.assertEquals("D", gradeBook.get(students[4]));
        Assert.assertEquals("F", gradeBook.get(students[5]));
        Assert.assertEquals("F", gradeBook.get(students[6]));
        Assert.assertEquals("D", gradeBook.get(students[7]));
        Assert.assertEquals("A", gradeBook.get(students[8]));
        Assert.assertEquals("B", gradeBook.get(students[9]));
        Assert.assertEquals("B", gradeBook.get(students[10]));

    }
    }

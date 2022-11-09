package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void testConstructor(){
        String expectedFirst = "John";
        String expectedSecond = "Smith";
        Double[] givenArr = new Double[0];
        ArrayList<Double> expectedScores = new ArrayList<>(Arrays.asList(givenArr));
        Student expected = new Student(expectedFirst,expectedSecond,givenArr);
        Assert.assertEquals(expectedFirst, expected.getFirstName());
        Assert.assertEquals(expectedSecond, expected.getLastName());
        Assert.assertEquals(expectedScores, expected.getExamScores());
    }

    @Test
    public void testGetFirstName(){
        String givenFirst = "Kevin";
        Student student = new Student(givenFirst,null,null);
        Assert.assertEquals(givenFirst,student.getFirstName());
    }
    @Test
    public void testGetLastName(){
        String givenLast = "Kevin?";
        Student student = new Student(null, givenLast,null);
        Assert.assertEquals(givenLast,student.getLastName());
    }
    @Test
    public void testGetExamScores(){
        Double [] scores = new Double[0];
        ArrayList<Double> givenScores = new ArrayList<>(Arrays.asList(scores));
        Student student = new Student(null,null, scores);
        Assert.assertEquals(givenScores, student.getExamScores());
    }
    @Test
    public void testSetFirstName(){
        String expectedFirst = "Kevin";
        Student student = new Student("",null,null);
        student.setFirstName(expectedFirst);
        Assert.assertEquals(expectedFirst,student.getFirstName());
    }
    @Test
    public void testSetLastName(){
        String expectedLast = "Kevin?";
        Student student = new Student(null, "",null);
        student.setLastName(expectedLast);
        Assert.assertEquals(expectedLast,student.getLastName());
    }
    @Test
    public void testSetExamScores(){
        ArrayList<Double> expectedScores = new ArrayList();
        Student student = new Student(null,null,new Double[0]);
        student.setExamScores(expectedScores);
        Assert.assertEquals(expectedScores,student.getExamScores());
    }
    @Test
    public void testGetNumberOfExamsTaken(){
        int examsNum = 12;
        Student student = new Student(null,null, new Double[examsNum]);
        int expected = student.getNumberOfExamsTaken();
        Assert.assertEquals(examsNum, expected);
    }

    @Test
    public void testGetExamScoreString(){
        Double[] score= {14.0,15.0,16.0};
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(score));
        String theString = scores.toString();
        Student student = new Student(null,null,score);
        String expected = student.getExamScoresString();
        Assert.assertEquals(expected,theString);
    }
    @Test
    public void testAddExamScore(){
        Double newScore = 56.0;
        int expectedSize = 1;
        Student student = new Student(null,null,null);
        student.addExamScore(newScore);
        Double scoreToTest = student.examScores.get(0);
        Assert.assertEquals(scoreToTest, newScore);
    }
    @Test
    public void testSetExamScore(){
        Double newScore = 17.0;
        int examIndex = 0;
        Double [] scores = {12.0};
        Student student = new Student(null,null,scores);
        student.setExamScore(examIndex,newScore);
        Double expectedScore = student.examScores.get(0);
        Assert.assertEquals(expectedScore, newScore);
    }
    @Test
    public void testGetAverageExamScore(){
        Double [] scores = {5.0, 10.0, 15.0};
        Student student = new Student(null,null, scores);
        Double expectedAvg = 10.0;
        Assert.assertEquals(expectedAvg, student.getAverageExamScore());
    }
    @Test
    public void testToString(){
        Double [] scores = {10.0, 15.0, 5.0};
        Student student = new Student("Kevin", "Kevin?", scores);
        String expected = "Kevin" + " | " + "Kevin?" + " | " + student.getAverageExamScore().toString() + " | " + student.getExamScoresString();
        Assert.assertEquals(expected,student.toString());
    }

}
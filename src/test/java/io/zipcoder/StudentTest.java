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


}
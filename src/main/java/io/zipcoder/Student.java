package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {


    public String firstName;
    public String lastName;
    public ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }
    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

}

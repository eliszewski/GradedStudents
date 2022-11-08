package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classroom {
    Student[] students;
    public Classroom(int maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }
    public Classroom(){
        this.students = new Student[30];
    }
    public Student[] getStudents(){
        return this.students;
    }

    public Double getAverageExamScore(){
        Double sum = 0.0;
        for (Student student: this.students
             ) {
            sum+= student.getAverageExamScore();
        }
        return sum / this.students.length;
    }
    public void addStudent(Student student){
        List<Student> students1 = Arrays.asList(this.students);
        students1.add(student);
        this.students = students1.toArray(new Student[0]);
    }
    public void removeStudent(String firstName, String lastName){
        List<Student> students1 = Arrays.asList(this.students);
        for (Student student:students1
             ) {
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                students1.remove(student);
            }
        }
        this.students = students1.toArray(new Student[0]);
    }
    public Student[] getStudentsByScore(){
        return null;
    }
}

package io.zipcoder;

import java.util.*;

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
    protected static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getAverageExamScore() > o2.getAverageExamScore()) {
                return -1;
            }else if (o1.getAverageExamScore() < o2.getAverageExamScore()) {
                return +1;
            }else {
                // average scores are equal
                return o1.getFirstName().compareTo(o2.getFirstName());
            }

        }

    }
    public Student[] getStudentsByScore(){
        List<Student> theList = new ArrayList(Arrays.asList(this.getStudents()));
        Collections.sort(theList, new StudentComparator());
        return theList.toArray(new Student[0]);
    }

}

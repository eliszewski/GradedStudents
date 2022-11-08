package io.zipcoder;

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
    public void addStudent
}

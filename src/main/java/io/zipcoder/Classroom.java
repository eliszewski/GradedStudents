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
        List<Student> students1 = new ArrayList<>(Arrays.asList(this.students));
        students1.add(student);
        this.students = students1.toArray(new Student[0]);
    }
    public void removeStudent(String firstName, String lastName){
        List<Student> students1 = new ArrayList<>(Arrays.asList(this.students));
        Student studentToRemove = new Student(null,null,null);
        for (Student student:students1
             ) {
            if(student != null && (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))){
                studentToRemove = student;
            }
        }
        students1.remove(studentToRemove);
        this.students = students1.toArray(new Student[0]);
    }
    protected static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) { //sorting algorithm
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
    public Student[] getStudentsByScore() {
        List<Student> theList = new ArrayList(Arrays.asList(this.getStudents()));
        Collections.sort(theList, new StudentComparator());
        return theList.toArray(new Student[0]);
    }

    public double percentileCalculator(int index, int len){
        return Math.abs((index + 1) - len) / len * 100;
    }
    public Map<Student,Character> getGradeBook(){
        Map<Student,Character> mapping = new LinkedHashMap<>();
        Student[] sortedStudents = this.getStudentsByScore();
        int n = sortedStudents.length;
        for(int i = 0;i<n;i++){
            if(percentileCalculator(i,n)>=90){
                mapping.put(sortedStudents[i],'A');
            }
            if(percentileCalculator(i,n)<90 && percentileCalculator(i,n)>=70){
                mapping.put(sortedStudents[i],'B');
            }
            if(percentileCalculator(i,n)<70 && percentileCalculator(i,n)>=50){
                mapping.put(sortedStudents[i],'C');
            }
            if(percentileCalculator(i,n)<50 && percentileCalculator(i,n) >=10){
                mapping.put(sortedStudents[i],'D');
            }
            if(percentileCalculator(i,n) <10){
                mapping.put(sortedStudents[i],'F');
            }
        }
        return mapping;
    }
}

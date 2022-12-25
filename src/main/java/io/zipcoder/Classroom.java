package io.zipcoder;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Classroom {
    Student[] students;

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (Student student : this.students
        ) {
            sum += student.getAverageExamScore();
        }
        return sum / this.students.length;
    }

    public void addStudent(Student student) {
        List<Student> students1 = new ArrayList<>(Arrays.asList(this.students));
        students1.add(student);
        this.students = students1.toArray(new Student[0]);
    }

    public void removeStudent(String firstName, String lastName) {
        List<Student> students1 = new ArrayList<>(Arrays.asList(this.students));
        Student studentToRemove = new Student(null, null, null);
        for (Student student : students1
        ) {
            if (student != null && (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))) {
                studentToRemove = student;
            }
        }
        students1.remove(studentToRemove);
        this.students = students1.toArray(new Student[0]);
    }

    public Student[] getStudentsByScore() {
        return Arrays.stream(students)
                .sorted((s1, s2) -> {
                    int scoreCompare = Double.compare(s2.getAverageExamScore(), s1.getAverageExamScore());
                    int firstNameCompare = scoreCompare != 0 ? scoreCompare : s1.getFirstName().compareTo(s2.getFirstName());
                    return firstNameCompare != 0 ? firstNameCompare : s1.getLastName().compareTo(s2.getLastName());
                })
                .toArray(Student[]::new);
    }

    public double percentileCalculator(int index, int len) {
        return (double) (len - (index + 1)) / (double) len * 100;
    }
    public LinkedHashMap<Student, String> getGradeBook() {
        LinkedHashMap<Student, String> mapping = new LinkedHashMap<>();
        Student[] sortedStudents = this.getStudentsByScore();
        int n = sortedStudents.length;
        for (int i = 0; i < n; i++) {
            if (percentileCalculator(i, n) >= 90) {
                mapping.put(sortedStudents[i], "A");
            }
            if (percentileCalculator(i, n) < 90 && percentileCalculator(i, n) >= 70) {
                mapping.put(sortedStudents[i], "B");
            }
            if (percentileCalculator(i, n) < 70 && percentileCalculator(i, n) >= 50) {
                mapping.put(sortedStudents[i], "C");
            }
            if (percentileCalculator(i, n) < 50 && percentileCalculator(i, n) >= 10) {
                mapping.put(sortedStudents[i], "D");
            }
            if (percentileCalculator(i, n) < 10) {
                mapping.put(sortedStudents[i], "F");
            }
        }
        return mapping;
    }
}


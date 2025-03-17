package ru.ybrynkin.dmdev.hw.task6.course;

import java.util.List;
import java.util.Objects;


public class Student {

  private String firstName;
  private String lastName;
  private int courseNumber;
  private List<Integer> grades;

  public Student(String firstName, String lastName, int courseNumber, List<Integer> grades) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.courseNumber = courseNumber;
    this.grades = grades;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getCourseNumber() {
    return courseNumber;
  }

  public List<Integer> getGrades() {
    return grades;
  }

  public double getAverageGrade() {
    return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Student student = (Student) o;
    return courseNumber == student.courseNumber && Objects.equals(firstName,
        student.firstName) && Objects.equals(lastName, student.lastName)
        && Objects.equals(grades, student.grades);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(firstName);
    result = 31 * result + Objects.hashCode(lastName);
    result = 31 * result + courseNumber;
    result = 31 * result + Objects.hashCode(grades);
    return result;
  }
}

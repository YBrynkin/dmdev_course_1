package ru.ybrynkin.dmdev.hw.task6.course;

import java.util.List;
import java.util.Objects;

public class Course {

  private double averageGrade;
  private List<Student> students;

  public Course(double averageGrade, List<Student> students) {
    this.averageGrade = averageGrade;
    this.students = students;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Course course = (Course) o;
    return Double.compare(averageGrade, course.averageGrade) == 0
        && Objects.equals(students, course.students);
  }

  @Override
  public int hashCode() {
    int result = Double.hashCode(averageGrade);
    result = 31 * result + Objects.hashCode(students);
    return result;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Course{");
    sb.append("averageGrade=").append(averageGrade);
    sb.append(", students=").append(students);
    sb.append('}');
    return sb.toString();
  }
}

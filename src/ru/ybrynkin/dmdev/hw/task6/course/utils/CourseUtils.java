package ru.ybrynkin.dmdev.hw.task6.course.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import ru.ybrynkin.dmdev.hw.task6.course.Course;
import ru.ybrynkin.dmdev.hw.task6.course.Student;

public class CourseUtils {

  // Get map where key is a course number and value is an average grade of students in this course
  // who have more than 3 grades
  public static Map<Integer, Double> getCourseMapWithAverageGrade(List<Student> students) {
    Map<Integer, Double> courseMap = students.stream()
        .filter(student -> student.getGrades().size() > 3)
        .collect(
            Collectors.groupingBy(
                Student::getCourseNumber,
                TreeMap::new,
                Collectors.averagingDouble(Student::getAverageGrade))
        );
    return courseMap;
  }

  public static Map<Integer, List<Student>> getCourseMapWithSortedStudents(
      List<Student> students) {
    Map<Integer, List<Student>> courseMap = students.stream()
        .collect(Collectors.groupingBy(
                Student::getCourseNumber,
                TreeMap::new,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    CourseUtils::sortStudentsByFirstAndLastName)
            )
        );
    return courseMap;
  }

  public static Map<Integer, Course> getCourseMapWithSortedCourseObject(List<Student> students) {
    Map<Integer, Course> courseMap = students.stream()
        .collect(
            Collectors.groupingBy(
                Student::getCourseNumber,
                TreeMap::new,
                Collectors.collectingAndThen(
                    Collectors.toList(), list -> {
                      double averageGrade = getAverageCourseGrade(list);
                      List<Student> sortedStudents = sortStudentsByFirstAndLastName(list);
                      return new Course(averageGrade, sortedStudents);
                    }))
        );
    return courseMap;
  }

  private static List<Student> sortStudentsByFirstAndLastName(List<Student> students) {
    List<Student> sortedStudents = students.stream()
        .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName))
        .toList();
    return sortedStudents;
  }

  private static double getAverageCourseGrade(List<Student> students) {
    return students.stream()
        .mapToDouble(Student::getAverageGrade)
        .average().orElse(0.0);
  }

}

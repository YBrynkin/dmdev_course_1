package ru.ybrynkin.dmdev.hw.task6;

import java.util.Arrays;
import java.util.List;
import ru.ybrynkin.dmdev.hw.task6.course.Student;
import ru.ybrynkin.dmdev.hw.task6.course.utils.CourseUtils;

public class Main {

  public static void main(String[] args) {
    // Create list of students
    List<Student> students = Arrays.asList(
        new Student("Sergey", "Sergeev", 102, Arrays.asList(5, 5, 5, 5)),
        new Student("Ivan", "Ivanov", 101, Arrays.asList(4, 5, 4, 3)),
        new Student("Petr", "Petrov", 101, Arrays.asList(4, 4, 4)),
        new Student("Anna", "Anina", 102, Arrays.asList(4, 4, 4, 4)),
        new Student("Maria", "Mariina", 101, Arrays.asList(3, 3, 4, 4))
    );

    System.out.println("\n" + CourseUtils.getCourseMapWithAverageGrade(students));
    System.out.println("\n" + CourseUtils.getCourseMapWithSortedStudents(students));
    System.out.println("\n" + CourseUtils.getCourseMapWithSortedCourseObject(students));


  }

}

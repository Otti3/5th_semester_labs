import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{

    public final List<Course> courses = new ArrayList<>();
    public Course createCourse() {
        Course course = new Course(this);
        this.courses.add(course);
        return course;
    }

    public void estimateStudentMark(Course course, Student student, int grade)
    {
        course.estimate(student, grade);
    }

    // temporary!
    public void finishCourse(Course course, Archive archive)
    {

        course.saveToArchive(archive);
        courses.remove(course);
    }

}
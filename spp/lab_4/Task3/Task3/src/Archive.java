import java.util.ArrayList;
import java.util.List;

public class Archive{
    public final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course)
    {
        courses.add(course);
    }

    public void showArchive(){
        for(Course course: courses){
            course.studentsMarks();
        }
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private final Teacher teacher;
    private final List<Student> students = new ArrayList<>();

    private final HashMap<Student, Integer> marks = new HashMap<>();


    public Course(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student addStudent(Student student){
        this.students.add(student);
        return student;
    }

    public void estimate(Student student, Integer mark) {
        this.marks.put(student, mark);
    }

    public void saveToArchive(Archive archive)
    {
        archive.addCourse(this);
    }

    public void studentsMarks(){
        for(Map.Entry<Student, Integer> pair : marks.entrySet())
        {

            System.out.println(String.format("Student = %s, mark = %d", pair.getKey().toString(), pair.getValue()));
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
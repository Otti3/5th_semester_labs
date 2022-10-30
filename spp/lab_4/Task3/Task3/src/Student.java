public class Student extends Person {
    
    public void subscribe(Course course) {
        course.addStudent(this);
    }
}
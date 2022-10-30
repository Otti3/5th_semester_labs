public class Task3 {

    public static void main(String[] args) throws Exception {
        Archive archive = new Archive();

        Teacher teacher = new Teacher();
        Course course1 = teacher.createCourse();

        Student stud1 = new Student();
        stud1.subscribe(course1);
        Student stud2 = new Student();
        stud2.subscribe(course1);
        Student stud3 = new Student();
        stud3.subscribe(course1);

        teacher.estimateStudentMark(course1, stud1, 5);
        teacher.estimateStudentMark(course1, stud2, 4);
        teacher.estimateStudentMark(course1, stud3, 6);

        teacher.finishCourse(course1, archive);
        archive.showArchive();
    }
}
import java.time.LocalDate;

public class Task1 {

    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        notepad.addNote(LocalDate.parse("2022-10-27"), new Notepad.Note("Text1"));
        notepad.addNote(LocalDate.parse("2022-10-28"), new Notepad.Note("Text2"));
        notepad.addNote(LocalDate.parse("2022-10-28"), new Notepad.Note("Text3"));

        for (Notepad.Note note: notepad.getNotesByDate(LocalDate.parse("2022-10-28"))) {
            System.out.println(note);
        }
        System.out.println(notepad.deleteNote(LocalDate.parse("2022-10-28"), new Notepad.Note("Text1")));
        System.out.println(notepad.deleteNote(LocalDate.parse("2022-10-27"), new Notepad.Note("Text1")));
        System.out.println(notepad.getNotesByDate(LocalDate.parse("2022-10-27")));
    }
}
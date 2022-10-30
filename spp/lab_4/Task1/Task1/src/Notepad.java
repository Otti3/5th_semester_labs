import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Notepad {
    private final HashMap<LocalDate, List<Note>> notes = new HashMap<>();


    public void addNote(LocalDate date, Note note) {
        List<Note> existingNotes = notes.get(date);

        if (existingNotes == null) {
            notes.put(date, new ArrayList<>(List.of(note)));

            return;
        }

        existingNotes.add(note);
    }

    public List<Note> getNotesByDate(LocalDate date) {
        return notes.get(date);
    }

    public Note deleteNote(LocalDate date, Note note){
        List<Note> existingNotes = notes.get(date);

        if (existingNotes == null){
            return null;
        }

        Iterator<Note> iter = existingNotes.iterator();//создаем итератор
        while(iter.hasNext()) {//до тех пор, пока в списке есть элементы

            Note nextNote = iter.next();//получаем следующий элемент
            if (nextNote.text.equals(note.text)){
                iter.remove();
                return nextNote;
            }
        }
        return null;

    }

    public static class Note {
        private String text;

        public Note(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }


        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return String.format("Note{text=%s}", text);
        }
    }
}

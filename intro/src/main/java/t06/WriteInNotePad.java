package t06;

/**
 * @class Запись в блокнот
 * @variables {@link #notepad} notepad - экземпляр объекта Блокнот,
 * @bariables {@link #notes} notes - массив, где хранятся все записи.
 *
 * @constructor {@link #WriteInNotePad(Notepad)}
 * Передается экземпляр объекта Блокнот и подготовленный массив для записей
 * @params notepad, arrayNotes
 *
 * @method {@link #addNote(String)}
 * Добавляет запись в массив.
 *
 * @method {@link #deleteNote(int)}
 * Удаляет запись из массива (присваивается null ячейке массива).
 *
 * @method {@link #editNote(int, String)}
 * Редактирует запись под номером в блокноте на запись note.
 *
 * @version 1.0
 */

public class WriteInNotePad {

    Notepad notepad;
    String[] notes;

    public WriteInNotePad(Notepad notepad){
        this.notepad = notepad;
        this.notes = notepad.arrayNotes;
    }

    public void addNote(String s){
        int index = 0;
        for (String string : notes) {
            if(string == null){
                break;
            }
            index++;
        }
        if(index == notes.length){
            System.err.println("При попытке добавления возникла ошибка: Не хватает места!");
            return;
        }
        notes[index] = s;
    }

    public void deleteNote(int index){
        if(index >= notes.length || index < 0){
            System.err.println("При попытке удаления записи возникла ошибка: Выход за пределы блокнота: " + index);
            return;
        }
        else
            notes[index] = null;
    }

    public void editNote(int index, String note){
        if(index >= notes.length || index < 0){
            System.err.println("При попытке редактирования записи: Выход за педелы блокнота: " + index);
            return;
        }
        else {
            if(note.equals("")){
                System.err.println("Изменение записи: Без изменений!");
                return;
            }
            else
                notes[index] = note;
        }

    }
}

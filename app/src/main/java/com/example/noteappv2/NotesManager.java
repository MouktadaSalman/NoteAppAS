package com.example.noteappv2;

public class NotesManager {
    private static NotesManager instance;
    private String[] noteText = new String[3];
    private int counter;

    public static NotesManager getInstance(){
        if (instance == null){
            instance = new NotesManager();
        }
        return instance;
    }

    public void incrementCounter() {
        this.counter ++;
    }

    public void setNoteText(int i, String noteText) {

        this.noteText[i] = noteText;
    }

    public int getCounter() {
        return counter;
    }

    public String getNoteText(int i) {
        return noteText[i];
    }
}

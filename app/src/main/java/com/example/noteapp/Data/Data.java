package com.example.noteapp.Data;

import com.example.noteapp.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static Data instance;
    private List<Note> noteData = new ArrayList<>();


    private Data() {

    }

    public static Data getInstance() {
        if(instance == null) {
            instance = new Data();

        }
        return instance;
    }


    public List<Note> get() {
        return noteData;
    }

    public Note getNote(int position) {
        return noteData.get(position);
    }


    public void add(Note note) {
        noteData.add(note);
    }


    public void delete(Note note) {
        noteData.remove(note);
    }


    public int size() {
        return noteData.size();
    }
}

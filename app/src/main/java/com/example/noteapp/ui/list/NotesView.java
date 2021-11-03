package com.example.noteapp.ui.list;

import com.example.noteapp.domain.Note;

import java.util.List;

public interface NotesView {

    void displayNotes(List<Note> notes);
}

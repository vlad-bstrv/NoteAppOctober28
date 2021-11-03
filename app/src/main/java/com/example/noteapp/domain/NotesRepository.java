package com.example.noteapp.domain;

import java.util.List;

public interface NotesRepository {

    void getNotes(Callback<List<Note>> callback);
}

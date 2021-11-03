package com.example.noteapp.ui.list;

import com.example.noteapp.domain.Callback;
import com.example.noteapp.domain.Note;
import com.example.noteapp.domain.NotesRepository;

import java.util.ArrayList;
import java.util.List;

public class NotesPresenter {

    private final NotesView view;
    private final NotesRepository repository;

    public NotesPresenter(NotesView view, NotesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {


//        repository.getNotes(new Callback<List<Note>>() {
//            @Override
//            public void onSuccess(List<Note> result) {
//                view.displayNotes(result);
//
//            }
//
//            @Override
//            public void onError(Throwable error) {
//
//            }
//        });

    }
}


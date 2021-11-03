package com.example.noteapp.domain;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NotesRepositoryImpl implements NotesRepository {

    private final Executor executor = Executors.newSingleThreadExecutor();

    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    private final List<Note> data = new ArrayList<>();

    @Override
    public void getNotes(Callback<List<Note>> callback) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(400L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                data.add(new Note("id1", "title 1", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id2", "title 2", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id3", "title 3", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id4", "title 4", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id5", "title 5", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id6", "title 6", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id7", "title 7", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id8", "title 8", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id9", "title 9", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));
                data.add(new Note("id10", "title 10", "“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.”\n 1"));

                mainThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // if (new Random().nextBoolean()) {
                        callback.onSuccess(data);
                        // } else {
                        // callback.onError(new IOException());
                        // }
                    }
                });
            }
        });

    }
}

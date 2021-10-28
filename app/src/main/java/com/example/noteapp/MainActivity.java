package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.noteapp.Data.Data;
import com.example.noteapp.domain.Note;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new ListFragment())
                .commit();

        Data.getInstance().add(new Note("Title1", "Text1"));
        Data.getInstance().add(new Note("Title2", "Text2"));
        Data.getInstance().add(new Note("Title3", "Text3"));
        Data.getInstance().add(new Note("Title4", "Text4"));
    }
}
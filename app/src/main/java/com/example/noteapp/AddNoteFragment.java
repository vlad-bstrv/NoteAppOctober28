package com.example.noteapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.noteapp.domain.Note;


public class AddNoteFragment extends Fragment {

    public static final String NOTE_KEY = "NOTE_KEY";


    public AddNoteFragment() {
        super(R.layout.fragment_add_note);
    }

    public static AddNoteFragment newInstance(Note note) {
        AddNoteFragment fragment = new AddNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(NOTE_KEY, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setActionBar(view);
        if (getArguments() != null) {
            Note note = getArguments().getParcelable(NOTE_KEY);
        }

        super.onViewCreated(view, savedInstanceState);
    }

    private void setActionBar(View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar_add_fragment);

        if (getActivity() instanceof Drawer) {
            Drawer drawer = (Drawer) getActivity();
            drawer.setToolbar(toolbar);
        }
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_add_fragment_close) {
                    getParentFragmentManager().popBackStack();
                    return true;
                }
                return false;
            }
        });
    }
}
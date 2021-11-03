package com.example.noteapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;

import android.widget.TextView;

import com.example.noteapp.domain.Note;

public class NoteDetailsFragment extends Fragment {

    private TextView title;
    private TextView text;
    private Note note;

    public static final String ARG_PARAM = "ARG_PARAM";

    public NoteDetailsFragment() {
        super(R.layout.fragment_note_details);
    }

    public static NoteDetailsFragment newInstance(Note note) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM, note);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = view.findViewById(R.id.toolbar_details_fragment);

        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_details_action_close:
                    getParentFragmentManager().popBackStack();
                    return true;
                case R.id.menu_details_action_delete:
                    DeleteDialogFragment.newInstance().show(getParentFragmentManager(), DeleteDialogFragment.TAG);
                    return true;
            }
            return false;
        });

        title = view.findViewById(R.id.title_detail);
        text = view.findViewById(R.id.text_detail);

        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_PARAM);
            title.setText(note.getTitle());
            text.setText(note.getDescription());

        }
        super.onViewCreated(view, savedInstanceState);
    }
}
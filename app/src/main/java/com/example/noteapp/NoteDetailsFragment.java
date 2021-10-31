package com.example.noteapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noteapp.Data.Data;
import com.example.noteapp.domain.Note;

public class NoteDetailsFragment extends Fragment {

    TextView title;
    TextView text;


    private static final String ARG_PARAM = "ARG_PARAM";

    public NoteDetailsFragment() {
        super(R.layout.fragment_note_details);
    }

    public static NoteDetailsFragment newInstance(int position) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = view.findViewById(R.id.toolbar_details_fragment);
        if (getActivity() instanceof Drawer) {
            Drawer drawer = (Drawer) getActivity();
            drawer.setToolbar(toolbar);
        }
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
            int position = getArguments().getInt(ARG_PARAM);
            title.setText(Data.getInstance().getNote(position).getTitle());
            text.setText(Data.getInstance().getNote(position).getText());

        }
        super.onViewCreated(view, savedInstanceState);
    }
}
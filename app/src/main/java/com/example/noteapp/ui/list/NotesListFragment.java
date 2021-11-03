package com.example.noteapp.ui.list;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.noteapp.AddNoteFragment;

import com.example.noteapp.NoteDetailsFragment;
import com.example.noteapp.R;
import com.example.noteapp.domain.Note;
import com.example.noteapp.domain.NotesRepositoryImpl;

import java.util.List;


public class NotesListFragment extends Fragment implements NotesView {


    private RecyclerView notesList;
    private NotesAdapter adapter;
    private NotesPresenter presenter;

    public NotesListFragment() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesPresenter(this, new NotesRepositoryImpl());
        adapter = new NotesAdapter(this);

        adapter.setNoteClicked(new NotesAdapter.OnNoteClicked() {
            @Override
            public void onNoteClicked(Note note) {
                openDetailsFragment(note);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setToolbarOnFragment(view);

        notesList = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        notesList.setLayoutManager(lm);
        notesList.setAdapter(adapter);
        presenter.requestNotes();
    }

    private void openDetailsFragment(Note note) {
        NoteDetailsFragment noteDetailsFragment = NoteDetailsFragment.newInstance(note);
        getParentFragmentManager().beginTransaction()
                .addToBackStack("")
                .replace(R.id.fragmentContainerView, noteDetailsFragment)
                .commit();
    }

    private void setToolbarOnFragment(View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar_list_fragment);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_add) {
                    getParentFragmentManager().beginTransaction()
                            .addToBackStack("")
                            .replace(R.id.fragmentContainerView, new AddNoteFragment())
                            .commit();
                    return true;
                } else if (item.getItemId() == R.id.menu_sort) {
                    Toast.makeText(requireContext(), "Sort", Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void displayNotes(List<Note> notes) {
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();
    }
}
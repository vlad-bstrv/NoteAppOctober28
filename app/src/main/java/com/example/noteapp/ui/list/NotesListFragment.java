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

import java.util.ArrayList;
import java.util.List;


public class NotesListFragment extends Fragment implements NotesView {


//    private RecyclerView notesList;
    private NotesAdapter adapter;
    private NotesPresenter presenter;
    ArrayList<Note> data = new ArrayList<>();



    public NotesListFragment() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesPresenter(this, new NotesRepositoryImpl());


        data.add(new Note("id1", "title 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id2", "title 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id3", "title 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id4", "title 4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id5", "title 5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id6", "title 6", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id7", "title 7", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id8", "title 8", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id9", "title 9", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));
        data.add(new Note("id10", "title 10", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 1"));



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setToolbarOnFragment(view);

        RecyclerView notesList = view.findViewById(R.id.recycler_view);
        adapter = new NotesAdapter(data);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        notesList.setLayoutManager(lm);
        notesList.setAdapter(adapter);
        presenter.requestNotes();

        adapter.setNoteClicked(new NotesAdapter.OnNoteClicked() {
            @Override
            public void onNoteClicked(Note note) {
                openDetailsFragment(note);
            }
        });
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
//        adapter.setNotes(notes);
//        adapter.notifyDataSetChanged();
    }
}
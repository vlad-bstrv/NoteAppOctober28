package com.example.noteapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noteapp.Data.Data;
import com.example.noteapp.adapter.NoteAdapter;


public class ListFragment extends Fragment {

    public interface DetailsNoteReplace {
        void onDetailsNote(int position);
    }

    private RecyclerView recyclerView;


    public ListFragment() {
        super(R.layout.fragment_list);
    }


    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new NoteAdapter(requireContext(), Data.getInstance().get(), detailsNoteReplace ));


    }

    DetailsNoteReplace detailsNoteReplace = new DetailsNoteReplace() {
        @Override
        public void onDetailsNote(int position) {
            NoteDetailsFragment noteDetailsFragment = NoteDetailsFragment.newInstance(position);
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, noteDetailsFragment)
                    .addToBackStack("")
                    .commit();
        }
    };


}
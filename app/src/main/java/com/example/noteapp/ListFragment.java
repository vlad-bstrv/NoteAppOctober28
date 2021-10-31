package com.example.noteapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
//        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar_list_fragment);
        if (getActivity() instanceof Drawer) {
            Drawer drawer = (Drawer) getActivity();
            drawer.setToolbar(toolbar);
        }
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

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new NoteAdapter(requireContext(), Data.getInstance().get(), detailsNoteReplace));


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

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        MenuItem item = menu.findItem(R.id.menu_add);
//        if(item != null) {
//            item.setVisible(false);
//        }
//        super.onCreateOptionsMenu(menu, inflater);
//    }
}
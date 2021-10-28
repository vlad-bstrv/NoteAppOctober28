package com.example.noteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.Data.Data;
import com.example.noteapp.ListFragment;
import com.example.noteapp.R;
import com.example.noteapp.domain.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Note> notes;


    private ListFragment.DetailsNoteReplace detailsNoteReplace;

    public NoteAdapter(Context context, List<Note> notes, ListFragment.DetailsNoteReplace detailsNoteReplace) {
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
        this.detailsNoteReplace = detailsNoteReplace;
    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view, detailsNoteReplace);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.itemNoteTitle.setText(note.getTitle());
        holder.itemNoteText.setText(note.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.itemNoteTitle.getText(), Toast.LENGTH_SHORT).show();
                detailsNoteReplace.onDetailsNote(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Data.getInstance().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView itemNoteTitle;
        final TextView itemNoteText;
        ListFragment.DetailsNoteReplace detailsNoteReplace;

        public ViewHolder(@NonNull View itemView, ListFragment.DetailsNoteReplace detailsNoteReplace) {
            super(itemView);

            itemNoteTitle = itemView.findViewById(R.id.item_note_title);
            itemNoteText = itemView.findViewById(R.id.item_note_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    detailsNoteReplace.onDetailsNote(getAdapterPosition());
                }
            });
getAdapterPosition();
        }
    }

}

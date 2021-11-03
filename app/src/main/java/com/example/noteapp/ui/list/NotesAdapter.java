package com.example.noteapp.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.R;
import com.example.noteapp.domain.Note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private final List<Note> notes;

    private OnNoteClicked noteClicked;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;

    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.getItemNoteTitle().setText(note.getTitle());
        holder.getItemNoteText().setText(note.getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public OnNoteClicked getNoteClicked() {
        return noteClicked;
    }

    public void setNoteClicked(OnNoteClicked noteClicked) {
        this.noteClicked = noteClicked;
    }

    public interface OnNoteClicked {
        void onNoteClicked(Note note);
    }


    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView itemNoteTitle;
        private final TextView itemNoteText;

        public TextView getItemNoteTitle() {
            return itemNoteTitle;
        }

        public TextView getItemNoteText() {
            return itemNoteText;
        }

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);


            itemNoteTitle = itemView.findViewById(R.id.item_note_title);
            itemNoteText = itemView.findViewById(R.id.item_note_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getNoteClicked() != null) {
                        getNoteClicked().onNoteClicked(notes.get(getAdapterPosition()));
                    }
                }
            });
        }
    }

}

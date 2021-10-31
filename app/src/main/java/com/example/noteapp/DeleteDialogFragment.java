package com.example.noteapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DeleteDialogFragment extends DialogFragment {

    public static final String TAG = "DeleteDialogFragment";

    public static DeleteDialogFragment newInstance() {
        return new DeleteDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new AlertDialog.Builder(requireContext())
                .setTitle(R.string.delete)
                .setIcon(R.drawable.ic_delete)
                .setPositiveButton(R.string.yes, (dialog, which) -> {
                    Toast.makeText(requireContext(), "Delete", Toast.LENGTH_SHORT).show();
                    getParentFragmentManager().popBackStack();
                })
                .setNegativeButton(R.string.no, null)
                .create();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }
}

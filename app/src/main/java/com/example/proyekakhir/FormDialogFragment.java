package com.example.proyekakhir;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class FormDialogFragment extends DialogFragment {

    private static final String ARG_LAYOUT = "layout";
    private EditText titleEditText;
    private EditText dateEditText;
    private EditText timeEditText;

    public static FormDialogFragment newInstance(int layout) {
        FormDialogFragment fragment = new FormDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT, layout);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        int layout = getArguments().getInt(ARG_LAYOUT);
        View view = inflater.inflate(layout, null);

        titleEditText = view.findViewById(R.id.titleEditText);

        builder.setView(view)
                .setTitle("Task")
                .setPositiveButton("OK", (dialog, which) -> {
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    dismiss();
                });

        return builder.create();
    }
}

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

    private EditText titleEditText;
    private EditText dateEditText;
    private EditText timeEditText;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.form_layout, null);

        titleEditText = view.findViewById(R.id.titleEditText);
        dateEditText = view.findViewById(R.id.dateEditText);
        timeEditText = view.findViewById(R.id.timeEditText);

        builder.setView(view)
                .setTitle("Task")
                .setPositiveButton("OK", (dialog, which) -> {
                    String title = titleEditText.getText().toString();
                    String date = dateEditText.getText().toString();
                    String time = timeEditText.getText().toString();
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    dismiss();
                });

        return builder.create();
    }
}

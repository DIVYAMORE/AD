package com.example.expt5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.expt5.R;

public class Example_Dialog extends AppCompatDialogFragment {

    private EditText Username;
    private EditText Password;

    private ExampleDialogListener listener;

    @NonNull
    @Override

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout,null);
        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    String username = Username.getText().toString();
                    String password = Password.getText().toString();
                    listener.applyTexts(username,password);
                    }
                });
        Username = view.findViewById(R.id.editTextText);
        Password = view.findViewById(R.id.editTextTextPassword);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener =(ExampleDialogListener) context;
    }

    public interface ExampleDialogListener{
        void applyTexts(String username,String password);

    }
}

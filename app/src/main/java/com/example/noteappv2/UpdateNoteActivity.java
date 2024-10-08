package com.example.noteappv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_note);

        EditText editText = findViewById(R.id.textView);
        Button saveButton = findViewById(R.id.saveButton);

        Intent gIntent = getIntent();
        String note = gIntent.getStringExtra("NOTE");

        editText.setText(note);

        saveButton.setText("Update");

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("NOTE", editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

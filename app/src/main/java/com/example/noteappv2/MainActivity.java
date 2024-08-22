package com.example.noteappv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button addNote;
    Button viewNote1;
    Button viewNote2;
    Button viewNote3;
    Button viewNote4;
    String note = "";

    ActivityResultLauncher<Intent> addNoteActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK){
                    Intent data = result.getData();
                    note = getIntent().getStringExtra("NOTE");
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNote = findViewById(R.id.addNoteButton);
        viewNote1 = findViewById(R.id.note1Button);
        viewNote2 = findViewById(R.id.note2Button);
        viewNote3 = findViewById(R.id.note3Button);
        viewNote4 = findViewById(R.id.note4Button);

        viewNote1.setVisibility(View.INVISIBLE);
        viewNote2.setVisibility(View.INVISIBLE);
        viewNote3.setVisibility(View.INVISIBLE);
        viewNote4.setVisibility(View.INVISIBLE);



        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                addNoteActivityLauncher.launch(intent);
                viewNote1.setVisibility(View.VISIBLE);
            }
        });

        viewNote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateNoteActivity.class);
                intent.putExtra("NOTE", note);
                addNoteActivityLauncher.launch(intent);
            }
        });
    }

}
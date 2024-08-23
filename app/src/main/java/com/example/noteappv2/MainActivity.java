package com.example.noteappv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    Button addNote;
    Button[] viewNoteButton = new Button[4];
    int id;

    ActivityResultLauncher<Intent> addNoteActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK){
                    Intent data = result.getData();
                    assert data != null;
                    String retrievedNote = data.getStringExtra("NOTE");
                    viewNoteButton[id].setText(retrievedNote);
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNote = findViewById(R.id.addNoteButton);
        viewNoteButton[0] = findViewById(R.id.note1Button);
        viewNoteButton[1] = findViewById(R.id.note2Button);
        viewNoteButton[2] = findViewById(R.id.note3Button);
        viewNoteButton[3] = findViewById(R.id.note4Button);

        viewNoteButton[0].setVisibility(View.INVISIBLE);
        viewNoteButton[1].setVisibility(View.INVISIBLE);
        viewNoteButton[2].setVisibility(View.INVISIBLE);
        viewNoteButton[3].setVisibility(View.INVISIBLE);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);

                for (int i = 0; i < 4; i++){
                    if (viewNoteButton[i].getVisibility() == View.INVISIBLE){
                        viewNoteButton[i].setVisibility(View.VISIBLE);
                        id = i;
                        addNoteActivityLauncher.launch(intent);
                        break;
                    }
                }
            }
        });

        viewNoteButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateNoteActivity.class);
                intent.putExtra("NOTE", viewNoteButton[0].getText().toString());
                id = 0;
                addNoteActivityLauncher.launch(intent);
            }
        });

        viewNoteButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateNoteActivity.class);
                intent.putExtra("NOTE", viewNoteButton[1].getText().toString());
                id = 1;
                addNoteActivityLauncher.launch(intent);
            }
        });

        viewNoteButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateNoteActivity.class);
                intent.putExtra("NOTE", viewNoteButton[2].getText().toString());
                id = 2;
                addNoteActivityLauncher.launch(intent);
            }
        });

        viewNoteButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateNoteActivity.class);
                intent.putExtra("NOTE", viewNoteButton[3].getText().toString());
                id = 3;
                addNoteActivityLauncher.launch(intent);
            }
        });
    }
}
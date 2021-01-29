package com.example.flashcardassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFlashCard<confirmButton> extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_flashcard);

    }
    public void onclick(View view){
        Intent intent = new Intent(AddFlashCard.this, MainActivity.class);
        AddFlashCard.this.startActivity(intent);

        Button confirmButton;
        confirmButton= findViewById(R.id.create_btn);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText)findViewById(R.id.addCardStatement)).getText().toString();
                Intent datainput = new Intent();
                datainput.putExtra("stringone", ((EditText) findViewById(R.id.addCardStatement)).getText().toString());
                setResult(RESULT_OK, datainput);
                finish();
            }
        });

    }
}


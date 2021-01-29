package com.example.flashcardassignment;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    ///my buttons and textview
    ///activitymainxml
    private Button myCorrectBtn;
    private Button myIncorrectBtn;
    private Button myNextBtn;
    private TextView myQuestionText;
    private Button myAddBtn;

    ///addflashcardxml
    private Button correct_btn2;
    private Button incorrect_btn2;
    private Button create_btn;
    private EditText addCardStatement;

    ///my question database
    private FlashcardQuestions[] myQuestionDatabase = new FlashcardQuestions[]{
            new FlashcardQuestions(R.string.question1, true),
            new FlashcardQuestions(R.string.question2, false),
            new FlashcardQuestions(R.string.question3, true),
            new FlashcardQuestions(R.string.question4, false)
    };
    private int myIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///storing questions
        addCardStatement = (EditText) findViewById(R.id.addCardStatement);
        correct_btn2 = (Button) findViewById(R.id.correct_btn2);
        incorrect_btn2 = (Button) findViewById(R.id.incorrect_btn2);
        create_btn = (Button) findViewById(R.id.create_btn);

        myQuestionText = (TextView) findViewById(R.id.questions);

        ///buttons///

        myCorrectBtn = (Button) findViewById(R.id.correct_btn);
        myCorrectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkMyAnswer(true);
            }
        });

        myIncorrectBtn = (Button) findViewById(R.id.incorrect_btn);
        myIncorrectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMyAnswer(false);
            }
        });

        myNextBtn = (Button) findViewById(R.id.next_btn);
        myNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIndex = (myIndex ++) % myQuestionDatabase.length;
                updateMyQuestion();
            }
        });
    }

    private void updateMyQuestion() {
        int question = myQuestionDatabase[myIndex].getTextID();
        myQuestionText.setText(question);
    }

    private void checkMyAnswer(boolean btnPress) {
        boolean trueAnswer = myQuestionDatabase[myIndex].theAnswer();
        int messageID = 1;
        if (btnPress == trueAnswer) {
            messageID = R.string.correct_tst;
        }else{
            messageID = R.string.Incorrect_tst;
        }
        Toast.makeText(this, messageID, Toast.LENGTH_SHORT).show();
        }
        public void addButtonClick(View view){
            if (view.getId() == R.id.add_btn){

            Intent i = new Intent(MainActivity.this, AddFlashCard.class);
            startActivity(i);
        }
    }
}

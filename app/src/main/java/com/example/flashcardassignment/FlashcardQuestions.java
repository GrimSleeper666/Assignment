package com.example.flashcardassignment;

public class FlashcardQuestions {
    private int myTextID;
    private boolean myAnswer;

    public FlashcardQuestions(int question1, boolean myAnswer) {
    }

    public void Question(int myTextID, boolean answers){
        myTextID = myTextID;
        answers = answers;
    }

    public void setTextID(int textID){

        myTextID = textID;
    }

    public void setAnswers(boolean answer){

        myAnswer = answer;
    }

    public int getTextID (){

        return myTextID;
    }

    public boolean theAnswer (){

        return myAnswer;
    }
}

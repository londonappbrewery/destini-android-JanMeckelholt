package com.londonappbrewery.destini;

import java.util.ArrayList;

/**
 * Created by jan on 18.02.18.
 */

public class QAPair {

    private  int mQuestion, mAnswerTop, mAnswerBottom;

    public QAPair(int question, int answerTop, int answerBottom){
        mQuestion = question;
        mAnswerTop = answerTop;
        mAnswerBottom = answerBottom;

    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public int getAnswerTop() {
        return mAnswerTop;
    }

    public void setAnswerTop(int answerTop) {
        mAnswerTop = answerTop;
    }

    public int getAnswerBottom() {
        return mAnswerBottom;
    }

    public void setAnswerBottom(int answerBottom) {
        mAnswerBottom = answerBottom;
    }
}

package com.example.vpphongngatapp.data.model;

public class Question {
    private String id;
    private String questionText;
    private String answer;

    public Question(String id, String questionText, String answer) {
        this.id = id;
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getId() { return id; }
    public String getQuestionText() { return questionText; }
    public String getAnswer() { return answer; }
}

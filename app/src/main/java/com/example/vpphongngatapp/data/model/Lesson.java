package com.example.vpphongngatapp.data.model;

public class Lesson {
    private String id;
    private String courseId;
    private String title;
    private String content;

    public Lesson(String id, String courseId, String title, String content) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.content = content;
    }

    public String getId() { return id; }
    public String getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
}

package com.example.vpphongngatapp.data.model;

public class Progress {
    private String userId;
    private String courseId;
    private int completedLessons;
    private int totalLessons;

    public Progress(String userId, String courseId, int completedLessons, int totalLessons) {
        this.userId = userId;
        this.courseId = courseId;
        this.completedLessons = completedLessons;
        this.totalLessons = totalLessons;
    }

    public String getUserId() { return userId; }
    public String getCourseId() { return courseId; }
    public int getCompletedLessons() { return completedLessons; }
    public int getTotalLessons() { return totalLessons; }
}

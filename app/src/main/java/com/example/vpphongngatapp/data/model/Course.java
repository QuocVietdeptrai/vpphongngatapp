package com.example.vpphongngatapp.data.model;

public class Course {
    private String id;
    private String title;
    private String description;
    private String imageUrl;

    public Course(String id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
}

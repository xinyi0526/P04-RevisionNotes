package com.myapplicationdev.android.p04_revisionnotes;

import java.io.Serializable;

public class Note implements Serializable {
    private int id;
    private String noteContent;
    private int stars;

    public int getId() {
        return id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public int getStars() {
        return stars;
    }

    public Note(int id, String noteContent, int stars) {
        this.id = id;
        this.noteContent = noteContent;
        this.stars = stars;
    }
}

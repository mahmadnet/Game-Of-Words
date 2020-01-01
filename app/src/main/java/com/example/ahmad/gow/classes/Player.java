package com.example.ahmad.gow.classes;

public class Player {

    private String Title;
    private byte Score;
    private byte Level;

    public Player() {
        Title = "";
        Score = 0;
        Level = 0;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public byte getScore() {
        return Score;
    }

    public void setScore(byte score) {
        Score = score;
    }

    public byte getLevel() {
        return Level;
    }

    public void setLevel(byte level) {
        Level = level;
    }
}

package com.ihh.lostandfound.board;

public class BoardModel {
    private String title = "";
    private String content = "";
    private String uid = "";
    private String time = "";

    public BoardModel() {
        this.title = "";
        this.content = "";
        this.uid = "";
        this.time = "";
    }

    public BoardModel(String title, String content, String uid, String time) {
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUid() {
        return uid;
    }

    public String getTime() {
        return time;
    }
}



package com.ihh.lostandfound.board;

public class BoardModel {
    private String title;
    private String content;
    private String uid;
    private String time;

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof BoardModel)) return false;
//        BoardModel boardModel = (BoardModel) o;
//        return age == person.age && Objects.equals(name, person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}



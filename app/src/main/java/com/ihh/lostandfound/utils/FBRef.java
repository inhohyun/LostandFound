package com.ihh.lostandfound.utils;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBRef {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();

    public static class Companion {
        public static DatabaseReference boardRef = database.getReference("board");
    }

}




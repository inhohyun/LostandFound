package com.ihh.lostandfound.utils;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FBAuth {
    private static FirebaseAuth auth;

    //현재 유저의 id 가져오기기
   public static String getUid() {
        auth = FirebaseAuth.getInstance();
        return auth.getCurrentUser().getUid();
    }
    //현재 시간 가져오기
    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        Date currentDateTime = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        return dateFormat.format(currentDateTime);
    }
}


package com.ihh.lostandfound.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ihh.lostandfound.R;


public class IntroActivity extends AppCompatActivity {
    Button btn_join;
    Button btn_login;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btn_join = findViewById(R.id.btn_join);
        btn_login = findViewById(R.id.btn_login);

        goToJoin();
        goToLogin();
    }

    private void goToLogin() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    private void goToJoin() {
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,JoinActivity.class);
                startActivity(intent);

            }
        });
    }
}
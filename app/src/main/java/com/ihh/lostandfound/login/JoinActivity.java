package com.ihh.lostandfound.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ihh.lostandfound.R;

public class JoinActivity extends AppCompatActivity {
//    private FirebaseAuth auth;
    Button btn_join;
    EditText emailArea;
    EditText passwordArea1;
    EditText passwordArea2;

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        btn_join = findViewById(R.id.JoinBtn);
        emailArea = findViewById(R.id.emailArea);
        passwordArea1 = findViewById(R.id.passwordArea1);
        passwordArea2 = findViewById(R.id.passwordArea2);


        setOnclickJoin();
    }

    private void setOnclickJoin() {
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailArea.getText().toString();
                String password1 =  passwordArea1.getText().toString();
                String password2 = passwordArea2.getText().toString();
                boolean isGoToJoin = true;
                //사용자가 값을 입력하지 않은 경우
                if (email.isEmpty()){
                    Toast.makeText(context, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }
                if (password1.isEmpty()){
                    Toast.makeText(context, "password1을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }
                if (password2.isEmpty()){
                    Toast.makeText(context, "password2을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }
                //비밀번호가 같은지 확인
                if(!password1.equals(password2)){
                    Toast.makeText(context, "비밀번호를 똑같이 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }

                //비밀번호가 너무 짧은 경우
                if(password1.length() < 6){
                    Toast.makeText(context, "비밀번호를 6자리 이상으로 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }

                //위의 조건 통과시 회원가입 성공공
               if (isGoToJoin){

                }


            }
        });
    }
}
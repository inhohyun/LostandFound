package com.ihh.lostandfound.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ihh.lostandfound.MainActivity;
import com.ihh.lostandfound.R;

public class JoinActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button btn_join;
    EditText emailArea;
    EditText passwordArea1;
    EditText passwordArea2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        btn_join = findViewById(R.id.JoinBtn);
        emailArea = findViewById(R.id.emailArea);
        passwordArea1 = findViewById(R.id.passwordArea1);
        passwordArea2 = findViewById(R.id.passwordArea2);

        //인스턴스 초기화
        mAuth = FirebaseAuth.getInstance();
        setOnclickJoin();
    }

    private void setOnclickJoin() {
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailArea.getText().toString();
                String password1 = passwordArea1.getText().toString();
                String password2 = passwordArea2.getText().toString();
                boolean isGoToJoin = true;
                //사용자가 값을 입력하지 않은 경우
                if (email.isEmpty()) {
                    Toast.makeText(JoinActivity.this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }
                if (password1.isEmpty()) {
                    Toast.makeText(JoinActivity.this, "password1을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }
                if (password2.isEmpty()) {
                    Toast.makeText(JoinActivity.this, "password2을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }
                //비밀번호가 같은지 확인
                if (!password1.equals(password2)) {
                    Toast.makeText(JoinActivity.this, "비밀번호를 똑같이 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }

                //비밀번호가 너무 짧은 경우
                if (password1.length() < 6) {
                    Toast.makeText(JoinActivity.this, "비밀번호를 6자리 이상으로 입력해주세요.", Toast.LENGTH_SHORT).show();
                    isGoToJoin = false;
                }

                //위의 조건 통과시 회원가입 성공공
                if (isGoToJoin) {
                    //firebase에 신규회원 가입시키기기
                    mAuth.createUserWithEmailAndPassword(email, password1)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(JoinActivity.this, "성공", Toast.LENGTH_SHORT).show();
                                        //회원가입 성공시 메인화면으로 넘어가기
                                        Intent intent = new Intent(JoinActivity.this, MainActivity.class);
                                        //back stack의 데이터 날리기(뒤로가기시 회원가입으로 돌아오지 않게)
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                    } else {

                                        Toast.makeText(JoinActivity.this, "아이디를 이메일 형식으로 입력해주세요.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }


            }
        });
    }
}
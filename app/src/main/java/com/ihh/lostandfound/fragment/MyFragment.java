package com.ihh.lostandfound.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.ihh.lostandfound.MainActivity;
import com.ihh.lostandfound.R;
import com.ihh.lostandfound.login.IntroActivity;
import com.ihh.lostandfound.login.JoinActivity;


public class MyFragment extends Fragment {

    private FirebaseAuth mAuth;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my, container, false);
        Button btn_logout = root.findViewById(R.id.btn_logout);
        mAuth = FirebaseAuth.getInstance();

        //로그아웃 버튼 클릭
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로그인 권한 삭제
                mAuth.signOut();

                Intent intent = new Intent(getContext(), IntroActivity.class);
                //back stack의 데이터 날리기(뒤로가기시 회원가입으로 돌아오지 않게)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(getContext(), "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        return root;
    }
}
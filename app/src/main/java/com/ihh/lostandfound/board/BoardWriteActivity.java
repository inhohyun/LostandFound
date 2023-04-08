package com.ihh.lostandfound.board;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ihh.lostandfound.R;
import com.ihh.lostandfound.utils.FBAuth;
import com.ihh.lostandfound.utils.FBRef;

public class BoardWriteActivity extends AppCompatActivity {
    Button writeBth;
    EditText title;
    EditText content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);
        writeBth = findViewById(R.id.writeBtn);
        title = findViewById(R.id.titleArea);
        content = findViewById(R.id.contentArea);
        setonClickWriteBtn();
    }

    private void setonClickWriteBtn() {
        writeBth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tit = title.getText().toString();
                String con = content.getText().toString();
                String uid = FBAuth.getUid();
                String time = FBAuth.getTime();


                //board
                //  -key
                //     - boardModel(title, content, uid, time)
                //       (boardModel에 제목, 내용, 작성자 id, 시간을 저장해서 db에 넘겨줌줌
                FBRef.Companion
                        .boardRef
                        .push()
                        .setValue(new BoardModel(tit, con, uid, time));



            }
        });

    }
}
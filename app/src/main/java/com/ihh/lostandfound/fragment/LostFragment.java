package com.ihh.lostandfound.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.ihh.lostandfound.R;
import com.ihh.lostandfound.board.BoardModel;
import com.ihh.lostandfound.board.BoardWriteActivity;
import com.ihh.lostandfound.board.lostBoardListAdapter;
import com.ihh.lostandfound.utils.FBRef;

import java.util.Collections;
import java.util.List;


public class LostFragment extends Fragment {
    private List<BoardModel> boardDataList;
    private ImageView writeBtn;
    private lostBoardListAdapter boardRVAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ViewRoot = inflater.inflate(R.layout.fragment_lost, container, false);


        writeBtn = ViewRoot.findViewById(R.id.writeBtn);



        //게시판 어댑터 연결
        boardRVAdapter = new lostBoardListAdapter(boardDataList);
        ListView boardListView = ViewRoot.findViewById(R.id.lostBoardListView);
        boardListView.setAdapter(boardRVAdapter);


        //write 버튼 클릭

        setOnclickWriteBtn();

        //FB에서 데이터 가져오기
        getFBBoardData();

        return ViewRoot;
    }

    private void setOnclickWriteBtn() {
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BoardWriteActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getFBBoardData() {

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                boardDataList.clear();

                for (DataSnapshot dataModel : dataSnapshot.getChildren()) {


                    BoardModel item = dataModel.getValue(BoardModel.class);
                    boardDataList.add(item);


                }


                boardRVAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        };
        FBRef.Companion.boardRef.addValueEventListener(postListener);
    }


}
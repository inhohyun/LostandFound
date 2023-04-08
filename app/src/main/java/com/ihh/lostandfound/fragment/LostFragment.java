package com.ihh.lostandfound.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.ihh.lostandfound.R;
import com.ihh.lostandfound.board.BoardModel;
import com.ihh.lostandfound.board.BoardWriteActivity;
import com.ihh.lostandfound.board.lostBoardListAdapter;
import com.ihh.lostandfound.utils.FBRef;

import java.util.List;


public class LostFragment extends Fragment {
    private List<BoardModel> boardDataList;
    private lostBoardListAdapter boardAdapter;
    private Button writeBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ViewRoot = inflater.inflate(R.layout.fragment_lost, container, false);
        ListView lostBoardListView = ViewRoot.findViewById(R.id.lostBoardListView);
        writeBtn = ViewRoot.findViewById(R.id.writeBtn);




        //게시판 어댑터 연결
        boardAdapter = new lostBoardListAdapter(boardDataList);
        lostBoardListView.setAdapter(boardAdapter);

        //FB에서 데이터 가져오기
        getFBBoardData();

        //write 버튼 클릭
        setOnclickWriteBtn();



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

    private void getFBBoardData(){

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Handle the data change
                for (DataSnapshot dataModel : dataSnapshot.getChildren()) {
                    BoardModel item = dataModel.getValue(BoardModel.class);
                    boardDataList.add(item);
                    //어댑터 동기화
                    boardAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle the error
            }
        };
        FBRef.Companion.boardRef.addValueEventListener(postListener);
    }


}
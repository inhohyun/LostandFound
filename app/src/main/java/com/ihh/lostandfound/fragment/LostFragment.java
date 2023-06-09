package com.ihh.lostandfound.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LostFragment extends Fragment {
    private List<BoardModel> boardDataList;
    private ImageView writeBtn;
    private lostBoardListAdapter boardRVAdapter;
    private static final String TAG = LostFragment.class.getSimpleName();

    public LostFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ViewRoot = inflater.inflate(R.layout.fragment_lost, container, false);


        writeBtn = ViewRoot.findViewById(R.id.writeBtn);


        //BoardModel 초기화시키기
        boardDataList = new ArrayList<>();

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
                Log.d(TAG, "write click");

                Intent intent = new Intent(getContext(), BoardWriteActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getFBBoardData() {

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //같은 게시물 생성되는 것 방지, 기존에 저장되어있는 list를 날리고 firebase에 저장되어있는 데이터를 받아서 저장
                boardDataList.clear();


                for (DataSnapshot dataModel : dataSnapshot.getChildren()) {

                    BoardModel item = dataModel.getValue(BoardModel.class);
                    boardDataList.add(item);


                }
                Log.d(TAG, boardDataList.toString());
                //데이터를 받아온 후 어댑터 동기화화
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
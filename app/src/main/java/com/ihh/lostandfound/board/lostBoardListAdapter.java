package com.ihh.lostandfound.board;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ihh.lostandfound.R;

import java.util.List;

public class lostBoardListAdapter extends BaseAdapter {
    private List<BoardModel> boardList;

    public lostBoardListAdapter(List<BoardModel> boardList) {
        this.boardList = boardList;
    }

    @Override
    public int getCount() {
        return boardList.size();
    }

    @Override
    public Object getItem(int position) {

        return boardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //뷰를 가져와서 연결
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Your code for generating each item view goes here
        View view = convertView;

        //뷰가 없으면 item의 뷰를 가져오기기
       if(view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lost_list_item, parent, false);
        }

        TextView title = view.findViewById(R.id.titleArea);
        title.setText(boardList.get(position).getTitle());


        return view;
    }
}





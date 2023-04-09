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
        if (boardList == null) {
            return 0;
        }
        return boardList.size();
    }

    @Override
    public Object getItem(int position) {
        if (boardList == null) {
            return 0;
        }
        return boardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        if (boardList == null) {
            return 0;
        }

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.lost_list_item, parent, false);
        }

        TextView title = view.findViewById(R.id.titleArea);
        TextView content = view.findViewById(R.id.contentArea);
        TextView time = view.findViewById(R.id.timeArea);

        title.setText(boardList.get(position).getTitle());
        content.setText(boardList.get(position).getContent());
        time.setText(boardList.get(position).getTime());

        return view;
    }
}





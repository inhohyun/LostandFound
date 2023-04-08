package com.ihh.lostandfound.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.ihh.lostandfound.R;
import com.ihh.lostandfound.board.BoardWriteActivity;


public class LostFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ViewRoot = inflater.inflate(R.layout.fragment_lost, container, false);
        ImageView writeBtn = ViewRoot.findViewById(R.id.writeBtn);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BoardWriteActivity.class);
                startActivity(intent);
            }
        });

        return ViewRoot;
    }


}
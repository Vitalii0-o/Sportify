package com.example.sportify;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TrainForList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context context = getActivity().getApplicationContext();
        LinearLayout layout = new LinearLayout(context);
        layout.setBackgroundColor(Color.BLUE);
        TextView text = new TextView(context);
        text.setText("Это область фрагмента");
        layout.addView(text);

        return layout;
    }
}
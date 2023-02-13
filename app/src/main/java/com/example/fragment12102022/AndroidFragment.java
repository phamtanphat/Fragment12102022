package com.example.fragment12102022;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.Random;

public class AndroidFragment extends Fragment {

    RelativeLayout relativeLayout;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("BBB", "Fragment Android: onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BBB", "Fragment Android: onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("BBB", "Fragment Android: onCreate View");
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        relativeLayout = view.findViewById(R.id.relative_android);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        randomBackground(relativeLayout);
    }

    private void randomBackground(View view) {
        Random random = new Random();
        int red = random.nextInt(255) + 1;
        int green = random.nextInt(255) + 1;
        int blue = random.nextInt(255) + 1;
        view.setBackgroundColor(Color.rgb(red, green, blue));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("BBB", "Fragment Android: onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.d("BBB", "Fragment Android: onDetach");
    }
}

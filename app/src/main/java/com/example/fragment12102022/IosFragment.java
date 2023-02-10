package com.example.fragment12102022;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.Random;

public class IosFragment extends Fragment {

    RelativeLayout relativeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ios, container, false);
        relativeLayout = view.findViewById(R.id.relative_ios);
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
}

package com.example.fragment12102022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddFragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
//        btnAddFragment = findViewById(R.id.button_add_fragment);
//        btnAddFragment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                AndroidFragment androidFragment = new AndroidFragment();
//                fragmentTransaction.add(R.id.linear_container_fragment, androidFragment);
//                fragmentTransaction.commit();
//            }
//        });
    }

    public void addAndroid(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentTransaction.add(R.id.linearlayoutContainer, androidFragment, "tag_android");
        fragmentTransaction.addToBackStack("android");
        fragmentTransaction.commit();
    }

    public void addIos(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.add(R.id.linearlayoutContainer, iosFragment, "tag_ios");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void replaceAndroid(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentTransaction.replace(R.id.linearlayoutContainer, androidFragment);
        fragmentTransaction.commit();
    }

    public void replaceIos(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.replace(R.id.linearlayoutContainer, iosFragment);
        fragmentTransaction.commit();
    }

    public void removeAndroid(View view) {
        AndroidFragment androidFragment = (AndroidFragment) fragmentManager.findFragmentByTag("tag_android");
        if (androidFragment != null && androidFragment.isVisible()) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(androidFragment);
            fragmentTransaction.commit();
        }
    }

    public void removeIos(View view) {
        IosFragment iosFragment = (IosFragment) fragmentManager.findFragmentByTag("tag_ios");
        if (iosFragment != null && iosFragment.isVisible()) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(iosFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        backStackFromId(fragmentManager.getFragments().size() - 1);
    }

    public void popbackstack(View view) {
        backStackFromName("android");
    }

    private void backStackFromName(String name) {
        if (fragmentManager.getFragments().size() == 0) {
            super.onBackPressed();
        } else {
            fragmentManager.popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    private void backStackFromId(int id) {
        if (fragmentManager.getFragments().size() == 0) {
            super.onBackPressed();
        } else {
            fragmentManager.popBackStack(id, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public void attach(View view) {
        AndroidFragment androidFragment = (AndroidFragment) getSupportFragmentManager().findFragmentByTag("tag_android");
        if (androidFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.attach(androidFragment);
            fragmentTransaction.commit();
        }
    }

    public void detach(View view) {
        AndroidFragment androidFragment = (AndroidFragment) getSupportFragmentManager().findFragmentByTag("tag_android");
        if (androidFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.detach(androidFragment);
            fragmentTransaction.commit();
        }
    }
}

package com.example.sama;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    ListFragment f;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            f = new ListFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.container, f).commit();
        }

    }
}
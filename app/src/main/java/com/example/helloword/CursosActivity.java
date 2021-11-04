package com.example.helloword;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class CursosActivity extends AppCompatActivity {

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        final ListView list = findViewById(R.id.cursosList);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Curso Java");
        arrayList.add("Curso JavaScript");
        arrayList.add("Curso Python");
        arrayList.add("Curso Android Studio");
        arrayList.add("Curso C++");
        arrayList.add("Curso React");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,                   android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);

    }





    }




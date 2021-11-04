package com.example.helloword;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page1 extends Fragment {
    MediaPlayer player;

    String str[]={"React","Java","Python","Javascript","Kotlin",
            "C#","React Native","Android","Git","Github","Flutter"};

    public page1() {
    }
    public static page1 newInstance(String param1, String param2) {
        page1 fragment = new page1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page1, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AutoCompleteTextView t1 = view.findViewById(R.id.autoCompleteTextView1);

       ArrayAdapter<String> adp = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line,str);
        t1.setThreshold(1);
        t1.setAdapter(adp);

        GridView coursesGV = view.findViewById(R.id.idGVcourses);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("React", R.drawable.logo_youtube));
        courseModelArrayList.add(new CourseModel("Java", R.drawable.logo_youtube));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.logo_youtube));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.logo_youtube));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.logo_youtube));
        courseModelArrayList.add(new CourseModel("Kotlin", R.drawable.logo_youtube));

        CourseGVAdapter adapter = new CourseGVAdapter(getContext(), courseModelArrayList);
        coursesGV.setAdapter(adapter);

        player = MediaPlayer.create(getContext(),R.raw.hung_up);
        Button playButton = view.findViewById(R.id.start);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               player.start();
               player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(getContext(), "A música acabou!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button pauseButton = (Button) view.findViewById(R.id.stop);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               player.pause();
            }
        });






    }



}
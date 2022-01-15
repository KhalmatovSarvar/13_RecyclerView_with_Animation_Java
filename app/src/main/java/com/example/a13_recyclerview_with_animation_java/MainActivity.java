package com.example.a13_recyclerview_with_animation_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Student> students = prepareStudentList();
        refreshAdapter(students);
    }
    private void initViews(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation);
        recyclerView.setLayoutAnimation(animationController);
    }
    private void refreshAdapter(List<Student> students){
        CustomAdapter adapter = new CustomAdapter(context,students);
        recyclerView.setAdapter(adapter);
    }

    private List <Student> prepareStudentList(){
        List <Student> students = new ArrayList<>();

        for(int i = 0; i<30; i++){
            students.add(new Student("Sarvar"+i,"Khalmatov"+i));
        }
        return students;
    }


}
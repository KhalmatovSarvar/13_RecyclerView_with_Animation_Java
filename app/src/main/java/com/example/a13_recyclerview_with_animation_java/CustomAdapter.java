package com.example.a13_recyclerview_with_animation_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Student> students;

    public CustomAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Student student = students.get(position);

        if(holder instanceof CustomViewHolder){
            TextView first_name = ((CustomViewHolder) holder).first_name;
            TextView last_name = ((CustomViewHolder) holder).last_name;

            first_name.setText(student.getFirstName());
            last_name.setText(student.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView first_name, last_name;

        public  CustomViewHolder(View v){
            super(v);
            view = v;

            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
}
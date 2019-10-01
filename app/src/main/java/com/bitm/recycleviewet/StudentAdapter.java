package com.bitm.recycleviewet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }





    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_recyclearview,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {

        Student student=students.get(position);
        holder.nameTv.setText(student.getName());
        holder.emailTv.setText(student.getEmail());
        holder.passwordTv.setText(student.getPassword());


    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv,emailTv,passwordTv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv=itemView.findViewById(R.id.nameTVR);
            emailTv=itemView.findViewById(R.id.emailTVR);
            passwordTv=itemView.findViewById(R.id.passwordTVR);
        }
    }
}

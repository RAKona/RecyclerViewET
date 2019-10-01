package com.bitm.recycleviewet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText nameEt,emailEt,paswordEt;
    private RecyclerView recyclerView;

    private List<Student> studentList=new ArrayList<>();;

    private StudentAdapter adapter;

   Student student;
    String name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt=findViewById(R.id.nameEt);
        emailEt=findViewById(R.id.emailEt);
        paswordEt=findViewById(R.id.passwordEt);
    }

    public void inserted(View view) {

        name=nameEt.getText().toString().trim();
        email=emailEt.getText().toString().trim();
        password=paswordEt.getText().toString().trim();


        if (!name.equals("") &&!email.equals("") &&!password.equals(""))
        {
            recyclerView=findViewById(R.id.recyclearView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter=new StudentAdapter(studentList);
            recyclerView.setAdapter(adapter);

            student = new Student(name,email,password);
            studentList.add( student);

            adapter.notifyDataSetChanged();
            nameEt.setText("");
            emailEt.setText("");
            paswordEt.setText("");
        }
        else {
            Toast.makeText(MainActivity.this,"Empty Feild.Please Fillup",Toast.LENGTH_LONG).show();
        }

    }
}

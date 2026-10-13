package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    private ListView listViewTasks;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        listViewTasks = findViewById(R.id.listViewTasks);

        tasks = new ArrayList<>();
        tasks.add("Complete Android Project");
        tasks.add("Prepare Presentation Slides");
        tasks.add("Review Database Queries");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listViewTasks.setAdapter(adapter);

        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String removedTask = tasks.get(position);
                tasks.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(TaskListActivity.this, "Completed: " + removedTask, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.tblrandd.mvmm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tblrandd.mvmm.adapter.EmployeeDataAdapter;
import com.tblrandd.mvmm.databinding.ActivityMainBinding;
import com.tblrandd.mvmm.model.Employee;
import com.tblrandd.mvmm.viewmodel.EmployeeViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EmployeeViewModel viewModel;
    private EmployeeDataAdapter adapter;
    private RecyclerView recyclerView;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        recyclerView = mainBinding.myrecyclerview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        viewModel.getAllEmployeeData().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {

                adapter = new EmployeeDataAdapter(employees,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }
        });



    }
}

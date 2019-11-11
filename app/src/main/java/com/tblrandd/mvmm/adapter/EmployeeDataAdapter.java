package com.tblrandd.mvmm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.tblrandd.mvmm.R;
import com.tblrandd.mvmm.databinding.CustomEmployeeBinding;
import com.tblrandd.mvmm.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder> {

    private List<Employee> employees;
    private Context context;

    public EmployeeDataAdapter(List<Employee> employees, Context context) {
        this.employees = employees;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CustomEmployeeBinding employeeListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.custom_employee, viewGroup, false);
        return new EmployeeViewHolder(employeeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder,final int i) {
        Employee currentStudent = employees.get(i);
        employeeViewHolder.employeeListItemBinding.setEmployee(currentStudent);
        employeeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Clicked on "+employees.get(i).getFirstName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        // below class name will like custom layout with binding keyword
        private CustomEmployeeBinding employeeListItemBinding;

        EmployeeViewHolder(@NonNull CustomEmployeeBinding employeetListItemBinding) {
            super(employeetListItemBinding.getRoot());
            this.employeeListItemBinding = employeetListItemBinding;
        }
    }
}

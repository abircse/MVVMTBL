package com.tblrandd.mvmm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tblrandd.mvmm.model.Employee;
import com.tblrandd.mvmm.repository.EmployeeRepository;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    private EmployeeRepository repository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        repository = new EmployeeRepository(application);
    }

    public LiveData<List<Employee>> getAllEmployeeData()
    {
        return repository.getMutableLiveData();
    }
}

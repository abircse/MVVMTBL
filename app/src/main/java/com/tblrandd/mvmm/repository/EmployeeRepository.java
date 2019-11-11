package com.tblrandd.mvmm.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.tblrandd.mvmm.model.Employee;
import com.tblrandd.mvmm.model.EmployeeDBResponse;
import com.tblrandd.mvmm.service.ApiService;
import com.tblrandd.mvmm.service.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();
    private MutableLiveData<List<Employee>> mutableLiveData = new MutableLiveData<>();
    private Context context;

    public EmployeeRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Employee>> getMutableLiveData() {

        ApiService service = RetrofitClient.getService();

        Call<EmployeeDBResponse> call = service.getEmployee();
        call.enqueue(new Callback<EmployeeDBResponse>() {
            @Override
            public void onResponse(Call<EmployeeDBResponse> call, Response<EmployeeDBResponse> response) {

                EmployeeDBResponse dbResponse = response.body();
                if (dbResponse != null && dbResponse.getData() != null) {
                    employees = dbResponse.getData();
                    mutableLiveData.setValue(employees);
                }

            }

            @Override
            public void onFailure(Call<EmployeeDBResponse> call, Throwable t) {

                Toast.makeText(context, "Error for: " + t, Toast.LENGTH_LONG).show();
            }
        });

        return mutableLiveData;

    }


}

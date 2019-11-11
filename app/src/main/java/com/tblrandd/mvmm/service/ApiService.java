package com.tblrandd.mvmm.service;

import com.tblrandd.mvmm.model.EmployeeDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users/?per_page=12&amp;page=1")
    Call<EmployeeDBResponse> getEmployee();

}

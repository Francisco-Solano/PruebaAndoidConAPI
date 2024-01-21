package com.vedruna.leonmunoze01.interfaces;

import com.vedruna.leonmunoze01.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CRUDInterface {

    @GET("producto")
    Call<List<Producto>> getAll();
}

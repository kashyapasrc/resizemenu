package com.example.resizemenu.domain.api

import com.example.resizemenu.domain.models.User
import retrofit2.http.GET
import retrofit2.Response

interface ApiService {


    @GET("/users")
    suspend fun fetchUsers() : Response<List<User>>



}
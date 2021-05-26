package com.example.resizemenu.domain.api

import com.example.resizemenu.domain.models.User
import retrofit2.Response

interface ApiHelper  {

    suspend fun fetchUsers() : Response<List<User>>
}
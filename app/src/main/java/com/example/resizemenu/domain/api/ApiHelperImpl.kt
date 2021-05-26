package com.example.resizemenu.domain.api

import com.example.resizemenu.domain.models.User
import retrofit2.Response

class ApiHelperImpl(val apiService: ApiService) : ApiHelper {

    override suspend fun fetchUsers(): Response<List<User>> {
        return apiService.fetchUsers()
    }
}
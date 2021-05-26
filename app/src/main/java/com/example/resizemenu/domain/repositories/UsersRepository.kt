package com.example.resizemenu.domain.repositories

import com.example.resizemenu.domain.api.ApiHelper

class UsersRepository(val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.fetchUsers()


}
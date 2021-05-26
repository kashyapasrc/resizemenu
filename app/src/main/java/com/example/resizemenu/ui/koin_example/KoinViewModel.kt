package com.example.resizemenu.ui.koin_example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resizemenu.domain.models.User
import com.example.resizemenu.domain.repositories.UsersRepository
import com.example.resizemenu.utils.NetworkHelper
import com.example.resizemenu.utils.Resource
import kotlinx.coroutines.launch

public class KoinViewModel(
    private val mainRepository: UsersRepository,
    private val networkHelper: NetworkHelper

) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}
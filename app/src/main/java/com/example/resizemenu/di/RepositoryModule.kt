package com.example.resizemenu.di

import com.example.resizemenu.domain.repositories.UsersRepository
import org.koin.dsl.module


val repositoryModule= module {

    single {
        UsersRepository(get())
    }
}
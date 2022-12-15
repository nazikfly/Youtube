package com.geektech.ytube.di

import com.geektech.ytube.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module


val repoModules: Module = module{
    single { Repository(get())}
}
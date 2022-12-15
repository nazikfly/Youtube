package com.gduleseektech.ytube.di

import com.geektech.ytube.core.network.networkModule
import com.geektech.ytube.di.repoModules
import com.geektech.ytube.di.viewModules
import org.koin.core.module.Module

val koinModules= listOf<Module>(
    repoModules,
    viewModules,
    networkModule
)


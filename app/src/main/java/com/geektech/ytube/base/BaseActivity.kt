package com.geektech.ytube.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {
    lateinit var binding: VB
    protected abstract fun inflateViewBinding(layoutInflater: LayoutInflater):VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=inflateViewBinding(layoutInflater)
        setContentView(binding.root)

        checkInternet()
        setUI()
        initAdapter()
        setupLiveData()
        initListener()
    }

    open fun initAdapter() {}

    open fun setupLiveData() {}// инициализация DataLive

    open fun setUI() {} // инициализация setUI

    open fun checkInternet()  {}// подключение Internet

    open fun initListener() {} // проверка интернета внутри этого метода

}
package com.example.thirdappkotlin.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.SimpleAdapter
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> (
    private val inflate : (inflate : LayoutInflater) -> VB
        ) : AppCompatActivity() {
    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflate.invoke(layoutInflater)
        _binding.run { setContentView(binding.root) }
        //checkInternet()
        //initViewModel()
        iniView()
        initListener()


    }

    abstract fun iniView()

    open fun checkInternet() {}

    open fun initListener() {}

    open fun initViewModel() {}
}
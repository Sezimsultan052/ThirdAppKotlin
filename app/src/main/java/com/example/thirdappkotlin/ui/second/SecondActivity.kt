package com.example.thirdappkotlin.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thirdappkotlin.R
import com.example.thirdappkotlin.base.BaseActivity
import com.example.thirdappkotlin.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate){

    private var selectedList: ArrayList<Int> = arrayListOf()
    private lateinit var adapterSecond: AdapterSecond

    override fun iniView() {
        adapterSecond = AdapterSecond()
        binding.rvSelectedImg.adapter = adapterSecond
        getImagesFromIntent()
    }

    private fun getImagesFromIntent() {
        selectedList = (intent.getIntegerArrayListExtra("list") as ArrayList<Int>)
        adapterSecond.setSelectList(selectedList)
    }

}
package com.example.thirdappkotlin.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thirdappkotlin.R
import com.example.thirdappkotlin.base.BaseActivity
import com.example.thirdappkotlin.databinding.ActivityMainBinding
import com.example.thirdappkotlin.extension.showToast
import com.example.thirdappkotlin.ui.second.SecondActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate),
    AdapterMAin.SelectListener {

    private lateinit var adapter : AdapterMAin
    private var list : ArrayList<Int> = arrayListOf()
    private var selectedList : ArrayList<Int> = arrayListOf()

    override fun initListener() {
        binding.btnSend.setOnClickListener{
            if(selectedList .isNullOrEmpty()){
                showToast(getString(R.string.empty_list))

            } else {
                updateList()
                openSecondActivity()
                selectedList.clear()
            }
        }
    }

    private fun openSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putIntegerArrayListExtra("list", selectedList)
        startActivity(intent)
    }

    private fun updateList() {
        for(i in 0..list.lastIndex){
            adapter.notifyItemChanged(i)

        }
    }


    override fun iniView() {
        adapter = AdapterMAin(this)
        binding.rvImage.adapter = adapter
        adapter.setImageList(list)
        initImageList()
    }

    private fun initImageList() {
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_4)
        list.add(R.drawable.img_5)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_4)
        list.add(R.drawable.img_5)

    }

    override fun select(selectImg: Int) {
       selectedList.add(selectImg)
    }

}
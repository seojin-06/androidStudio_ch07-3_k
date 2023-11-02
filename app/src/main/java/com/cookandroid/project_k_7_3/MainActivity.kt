package com.cookandroid.project_k_7_3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.cookandroid.project_k_7_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setTitle("배경색 바꾸기(컨텍스트 메뉴)")

        registerForContextMenu(binding.btn1)
        registerForContextMenu(binding.btn2)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        /*val mInflater : MenuInflater = menuInflater

        if(v == binding.btn1) {
            menu?.setHeaderTitle("배경색 변경")
            mInflater.inflate(R.menu.menu1, menu)
        }

        if(v == binding.btn2) {
            mInflater.inflate(R.menu.menu2, menu)
        }*/

        if (v == binding.btn1) {
            menu?.setHeaderTitle("배경석 변경")
            menu?.add(0, 1, 0, "배경색(빨강)")
            menu?.add(0, 2, 0, "배경색(초록)")
            menu?.add(0, 3, 0, "배경색(파랑)")
        }
        if (v == binding.btn2) {
            menu?.add(0, 4, 0, "버튼 45도 회전")
            menu?.add(0, 5, 0, "버튼 2배 확대")
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                binding.baseLayout.setBackgroundColor(Color.RED)
            }
            2 -> {
                binding.baseLayout.setBackgroundColor(Color.GREEN)
            }
            3 -> {
                binding.baseLayout.setBackgroundColor(Color.BLUE)
            }
            4 -> {
                binding.btn2.rotation = 45F
            }
            5 -> {
                binding.btn2.scaleX = 2F
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
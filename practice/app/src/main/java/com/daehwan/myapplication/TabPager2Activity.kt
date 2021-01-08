package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TabPager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager2)

        val tab_layout = findViewById<TabLayout>(R.id.tab_layout)
        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val adapter = ThreePageAdapter(layoutInflater)
        val view_pager = findViewById<ViewPager>(R.id.view_pager)

        view_pager.adapter = adapter
        // tab이 클릭됐을 때 리스너
        tab_layout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        // pager가 이동했을 때 탭을 이동시키는 코드
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}

class ThreePageAdapter(
    val layoutInflater: LayoutInflater
):PagerAdapter(){
    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        // 내가 만든 view인지 확인
        // 코틀린에서 object키워드가 있기 때문에 ``를 붙임, ===은 주소값까지 같은지 바교
        return view === `object` as View
    }
    // page가 가려질 때 adapter에서 파기가 되어야된다고 싶을 때 호출됨
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
    // 뷰를 그려주는 부분
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when(position){
            0 -> {
                val view = layoutInflater.inflate(R.layout.fragment_one,container,false)
                container.addView(view)
                return view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.fragment_two,container,false)
                container.addView(view)
                return view
            }
            2 -> {
                val view = layoutInflater.inflate(R.layout.fragment_three,container,false)
                container.addView(view)
                return view
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.fragment_one,container,false)
                container.addView(view)
                return view
            }
        }
    }
}
package com.example.testfragment.ui.main.main.main

class FragmentPresenter(private val view: FragmentInterface) {
    fun initView() {
        view.setFragment()
    }
}
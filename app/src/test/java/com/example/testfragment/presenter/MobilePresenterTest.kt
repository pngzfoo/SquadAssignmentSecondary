package com.example.testfragment.presenter

import com.example.testfragment.mobileInterface.view.MobilePresenterInterface
import com.example.testfragment.service.ApiService
import com.example.testfragment.ui.main.main.MainActivity
import com.nhaarman.mockitokotlin2.mock

class MobilePresenterTest {

    val view: MobilePresenterInterface = mock()
    private val service: ApiService = mock()
    private val activity: MainActivity = mock()
    private val presenter = MobilePresenter(view, service, activity)

//    @Test
//    fun `test getMobileApi success`(){
//        prenseter.getMobileApi()
//    }

}
package com.example.testfragment

import com.example.testfragment.presenter.MyCustomSharedPreference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferenceModule {


    @Singleton
    @Provides
    fun provideMyCustomSharedPreference(application: MyApplication) =
        MyCustomSharedPreference(application.applicationContext)
}
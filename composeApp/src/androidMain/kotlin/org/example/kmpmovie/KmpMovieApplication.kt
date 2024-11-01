package org.example.kmpmovie

import android.app.Application
import org.example.kmpmovie.di.initKoin

class KmpMovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
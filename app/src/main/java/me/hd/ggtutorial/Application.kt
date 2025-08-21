package me.hd.ggtutorial

import android.app.Application

class Application : Application() {
    companion object {
        init {
            System.loadLibrary("tutorial")
        }
    }
}
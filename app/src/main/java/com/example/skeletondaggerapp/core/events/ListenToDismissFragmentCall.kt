package com.example.skeletondaggerapp.core.events;

class ListenToDismissFragmentCall(val dismiss: Boolean) {
    fun getMessage() = dismiss
}
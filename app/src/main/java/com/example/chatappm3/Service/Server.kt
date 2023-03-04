package com.example.chatapp.Service

import android.util.Log
import com.example.chatappm3.Screens.AppViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.ServerSocket
import java.net.Socket

fun broadCast(txt: String) {
    Log.i("Tag",txt)
}

class Server(
    private val viewModel: AppViewModel
) {
    fun connect(): Socket {
        val server = ServerSocket(viewModel.port.value!!.toInt())
        broadCast("The Server is accepting requests")
        CoroutineScope(Dispatchers.Main).launch{
            viewModel.onStatusChanged("The Server is accepting requests")
        }
        broadCast("Waiting...")
        val socket = server.accept()
        broadCast("Connection Established with $socket")
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.onStatusChanged("Connection Established with $socket")
        }
        return socket
    }
}
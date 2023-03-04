package com.example.chatapp.Service

import com.example.chatappm3.Screens.AppViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.Socket

class Client(
    private val viewModel: AppViewModel
) {
    fun connect(): Socket {
        val socket = Socket(viewModel.ip.value.toString() ,viewModel.port.value!!.toInt())
        broadCast("Sending Request to Server...")
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.onStatusChanged("Sending request to Server...")
        }
        broadCast("Connection Established with Server")
        CoroutineScope(Dispatchers.Main).launch{
            viewModel.onStatusChanged("Connection Established with Server")
        }
        return socket
    }
}

package com.example.chatappm3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatappm3.CustomUI.Message
import com.example.chatappm3.Screens.AppViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Repository {
    private lateinit var client: Socket
    private lateinit var server: ServerSocket
    private lateinit var pw: PrintWriter
    private lateinit var br: BufferedReader
    var chatHist = MutableLiveData<List<Message>>(listOf(Message("This","Device connected", 1)))

    suspend fun startServer(port: Int, appViewModel: AppViewModel) {
        withContext(Dispatchers.IO) {
            server = ServerSocket(port)
            client = server.accept()
        }
    }

    suspend fun startClient(ip: String, port: Int, appViewModel: AppViewModel) {
        withContext(Dispatchers.IO) {
            client = Socket(ip, port)
        }
    }

    fun startChannel(appViewModel: AppViewModel) {
        br = BufferedReader(InputStreamReader(client!!.getInputStream()))
        pw = PrintWriter(client.getOutputStream())
    }

    fun read() {
        chatHist.postValue(chatHist.value?.plus(Message(br!!.readLine(),br!!.readLine(),0)))
    }

    suspend fun write(name: String, msg: String) {
        chatHist.postValue(chatHist.value?.plus(Message(name,msg,1)))
        withContext(Dispatchers.IO) {
            pw.println(name)
            pw.flush()
            pw.println(msg)
            pw.flush()
        }
    }
}
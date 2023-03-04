package com.example.chatappm3.Screens

import android.content.Context
import android.net.nsd.NsdServiceInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.chatappm3.Repository
import com.example.chatappm3.Screen.Screen
import kotlinx.coroutines.*

class AppViewModel(context: Context): ViewModel() {
    val serversList: MutableLiveData<List<NsdServiceInfo>> = MutableLiveData(listOf())

    val nsd = NsdHelper(serversList, context)
    private val nsdManager = nsd.mNsdManager
    private val resolveListener = nsd.mResolveListener

    private val _ip = MutableLiveData("")
    private val _port = MutableLiveData("")
    private val _username = MutableLiveData("")
    private val _status= MutableLiveData("")
    var repository = Repository()

    val ip: LiveData<String> = _ip
    val port: LiveData<String> = _port
    val username: LiveData<String> = _username

    fun resolveServer(service: NsdServiceInfo, viewModel: AppViewModel) {
        nsd.mNsdManager.resolveService(service, nsd.mResolveListener)
        _ip.value = nsd.chosenServiceInfo.host.hostAddress
        _port.value = nsd.chosenServiceInfo.port.toString()
    }

    fun onIpChanged(newIp: String) {
        _ip.value = newIp
    }

    fun onPortChanged(newPort: String) {
        _port.value = newPort
    }

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    fun onStatusChanged(newStatus: String) {
        _status.value = newStatus
    }

    fun onConnectClicked(
        appViewModel: AppViewModel,
        navHostController: NavHostController
    ) {
        if (_ip.value.isNullOrBlank()) {
            runBlocking {
                repository.startServer(appViewModel.nsd..value!!.toInt(), appViewModel)
            }
            repository.startChannel(appViewModel)
            CoroutineScope(Dispatchers.IO).launch {
                while (true)
                    repository.read()
            }
        } else {
            runBlocking {
                repository.startClient(_ip.value!!.toString(),_port.value!!.toInt(), appViewModel)
            }
            repository.startChannel(appViewModel)
            CoroutineScope(Dispatchers.IO).launch {
                while (true)
                    repository.read()
            }
        }
        navHostController.navigate(Screen.Chat.route)
        }
}
package com.example.chatappm3.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.chatappm3.Screen.Screen
import java.net.ServerSocket


@Composable
fun ListScreen(
    viewModel: AppViewModel,
    navHostController: NavHostController,
    server: Int
) {
    val ip: String by viewModel.ip.observeAsState("")
    val port: String by viewModel.port.observeAsState("")
    val username: String by viewModel.username.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
//        if (server == 1) {
            Text(text="Waiting...")
//            val mServerSocket = ServerSocket(0)
//            val mLocalPort = mServerSocket.localPort
//        } else {
            val mServerSocket = ServerSocket(0)
            val mLocalPort = mServerSocket.localPort

            val serversListObserver by viewModel.serversList.observeAsState()
            viewModel.nsd.initializeNsd()
            viewModel.nsd.registerService(mLocalPort)
            viewModel.nsd.discoverServices()
            viewModel.nsd.initializeResolveListener()
            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(items = serversListObserver!!.toList()) {
                        Button(onClick = {
                            viewModel.resolveServer(it, viewModel)
                            viewModel.onConnectClicked(viewModel, navHostController)
                        }) {
                            Text(it.serviceName.toString())
                        }
                    }
                }
            }
        }
    }
//}
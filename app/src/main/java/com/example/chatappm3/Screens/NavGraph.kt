package com.example.chatappm3.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.chatappm3.Screen.Screen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController,
    viewModel: AppViewModel
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Selection.route
    ) {
        composable(
            route = Screen.Selection.route
        ) {
            SelectionScreen(navHostController)
        }
        composable(
            route = Screen.Login.route,
            arguments = listOf(
                navArgument("server") {
                    type = NavType.IntType
                }
            )
        ) {
            LoginScreen(viewModel = viewModel, navHostController = navHostController, server = it.arguments?.getInt("server")!!.toInt())
        }
        composable(
            route = Screen.List.route,
            arguments = listOf(
                navArgument("server") {
                    type = NavType.IntType
                }
            )
        ) {
            ListScreen(viewModel = viewModel, navHostController = navHostController, server = it.arguments?.getInt("server")!!.toInt())
        }
        composable(
            route = Screen.Chat.route
        ) {
            ChatScreen(viewModel = viewModel,navHostController)
        }
    }

}
package com.example.chatappm3.Screen

sealed class Screen(val route: String) {
    object Selection : Screen(route = "selection_screen")
    object List: Screen(route = "list_screen/{server}") {
        fun passId(id: Int): String {
            return this.route.replace(oldValue = "{server}", newValue = id.toString())
        }
    }
    object Login : Screen(route = "login_screen/{server}") {
        fun passId(id: Int): String {
            return this.route.replace(oldValue = "{server}", newValue = id.toString())
        }
    }
    object Chat: Screen(route = "chat_screen")
}
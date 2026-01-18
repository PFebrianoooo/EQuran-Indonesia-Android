package com.putrapebrianonurba.equran.features.dua.navigation

sealed class DuaRoute(val route: String) {
    // ROOT GRAPH
    object ROOT: DuaRoute("dua_root_graph")

    // ROOT GRAPH CHILD SCREEN
    object Feed: DuaRoute("dua/feed")
    object Duas: DuaRoute("dua/feed/duas")
    object DuasTest: DuaRoute("dua/feed/duas_test")

    // DUA DETAIL SCREEN
    object DuaDetail: DuaRoute("dua/duas/detail/{id}") {
        fun createRoute(id: Int) = "dua/duas/detail/$id"
    }
}
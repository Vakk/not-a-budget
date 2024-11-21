package com.valeriik.navigation

object NavigationConstants {
    fun home() = Routes.HOME
    fun settings() = Routes.SETTINGS
    fun notebookDetails(id: String) = "note/$id"

    object Routes {
        const val HOME = "home"
        const val SETTINGS = "settings"
        const val NOTEBOOK_DETAILS = "note/:${Params.ID}"
    }

    object Params {
        const val ID = "id"
    }
}
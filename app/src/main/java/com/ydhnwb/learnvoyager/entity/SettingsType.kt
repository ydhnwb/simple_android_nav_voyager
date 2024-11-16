package com.ydhnwb.learnvoyager.entity

data class SettingType(val id: Int, val title: String, val shortDescription: String){}

val settingsData : ArrayList<SettingType> = arrayListOf(
    SettingType(id = 1, title = "Board settings", shortDescription = "Change your board default color, player colors, etc."),
    SettingType(id = 2, title = "About", shortDescription = "See app informations."),
    SettingType(id = 3, title = "App Permissions", shortDescription = "Check app permissions to avoid unwanted errors."),
    SettingType(id = 4, title = "Donate", shortDescription = "Support dev by donating.")
)
package com.monsercode.easypark

import java.io.Serializable

data class Park(
    val name: String,
    var distance: String? = null,
    val picture: String? = null
) : Serializable
package com.example.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel (@SerializedName("quote") val Quote:String, @SerializedName("author") val Author:String)
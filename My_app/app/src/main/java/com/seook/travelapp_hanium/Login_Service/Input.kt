package com.seook.travelapp_hanium.Login_Service

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http POST

interface Input(

    fun requestLogin(
        @Field("userid") userid:String,
        @Field("userpw") userpw:String
    ) : Call<Output>
)
package com.example.feature.authorization.data.network.service

import android.util.Log
import com.example.core.ext.isNotNull
import com.example.data.core.supabase.Tables
import com.example.feature.authorization.data.network.model.AuthorizationProfileJson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest

class AuthorizationNetworkServiceImpl(
    private val supabaseClient: SupabaseClient
): AuthorizationNetworkService {

    override suspend fun signIn(email: String, password: String): String {
        val result = supabaseClient.gotrue.loginWith(Email) {
            this.email = email
            this.password = password
        }

        supabaseClient.gotrue.currentUserOrNull()?.id?.let {
            return it
        }
        throw IllegalArgumentException("Sign in return null")
    }

    override suspend fun signUp(
        email: String,
        password: String,
        fullname: String,
        avatar: String
    ) {
        supabaseClient.gotrue.signUpWith(Email){
            this.email = email
            this.password = password
        }

        val user = supabaseClient.gotrue.currentUserOrNull()

        val profileJson = AuthorizationProfileJson(
            id = user!!.id,
            fullname = fullname,
            avatar = avatar ?: ""
        )


        supabaseClient.postgrest[Tables.PROFILES.tableName].insert(profileJson)

    }
}
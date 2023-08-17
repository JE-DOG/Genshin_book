package com.example.feature.profile.data.network.service

import com.example.data.core.supabase.Tables
import com.example.feature.add.chat.data.network.model.ProfileJson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ProfileNetworkServiceImpl(
    private val supabaseClient: SupabaseClient,
    private val userId: String
): ProfileNetworkService {

    override fun get() = callbackFlow {

        val result = supabaseClient.postgrest[Tables.PROFILES.tableName].select {
            eq(Tables.PROFILES.id,userId)
        }.decodeList<ProfileJson>()[0]

        send(result)

        close()
    }
}
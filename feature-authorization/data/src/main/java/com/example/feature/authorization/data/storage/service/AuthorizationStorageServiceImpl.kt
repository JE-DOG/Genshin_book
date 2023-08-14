package com.example.feature.authorization.data.storage.service

import android.content.SharedPreferences
import com.example.core.keys.SharedPreferencesKeys

class AuthorizationStorageServiceImpl(
    private val sharedPreferences: SharedPreferences
): AuthorizationStorageService {

    override suspend fun saveUserId(userId: String) {
        sharedPreferences.edit()
            .putString(SharedPreferencesKeys.USER_ID_KEY,userId)
            .apply()
    }
}
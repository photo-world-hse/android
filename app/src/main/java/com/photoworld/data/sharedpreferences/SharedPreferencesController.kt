package com.photoworld.data.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.photoworld.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesController @Inject constructor(
    @ApplicationContext
    context: Context,
) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.preference_file_key), Context.MODE_PRIVATE
    )

    fun putToken(token: String) = sharedPreferences.edit().putString(TOKEN_KEY, token).apply()

    fun getToken(): String = sharedPreferences.getString(TOKEN_KEY, EMPTY) ?: EMPTY

    fun deleteToken() = sharedPreferences.edit().putString(TOKEN_KEY, null).apply()

    companion object {
        private const val TOKEN_KEY = "TOKEN"
        private const val EMPTY = ""
    }

}
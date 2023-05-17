package com.photoworld.data.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.photoworld.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesController @Inject constructor(
    @ApplicationContext
    context: Context,
    private val gson: Gson,
) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.preference_file_key),
        Context.MODE_PRIVATE,
    )

    fun <T> put(key: SharedPreferencesKey, value: T) {
        val serializedObject = gson.toJson(value)
        sharedPreferences.edit().putString(key.keyName, serializedObject).apply()
    }

    fun <T> get(key: SharedPreferencesKey, clazz: Class<T>): T? {
        val serializedObject = sharedPreferences.getString(key.keyName, EMPTY) ?: EMPTY
        return runCatching { gson.fromJson(serializedObject, clazz) }.getOrNull()
    }

    inline fun <reified T> get(key: SharedPreferencesKey): T? = get(key, T::class.java)

    fun delete(key: SharedPreferencesKey) {
        sharedPreferences.edit().putString(key.keyName, null).apply()
    }

    companion object {
        private const val EMPTY = ""
    }
}

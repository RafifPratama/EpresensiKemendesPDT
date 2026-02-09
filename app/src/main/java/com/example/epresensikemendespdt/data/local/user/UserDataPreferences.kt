package com.example.epresensikemendespdt.data.local.user

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDataPreferences private constructor(private val dataStore: DataStore<Preferences>) {
    companion object {
        private val USER_ID = stringPreferencesKey("id")
        private val ENROLL_NUMBER = stringPreferencesKey("enroll_number")
        private val NAME = stringPreferencesKey("name")
        private val FOTO = stringPreferencesKey("foto")
        private val JABATAN = stringPreferencesKey("jabatan")
        private val GOLONGAN = stringPreferencesKey("golongan")
        private val UNIT_KERJA = stringPreferencesKey("unit_kerja")
        private val EMAIL = stringPreferencesKey("email")
        private val NOMOR_HP = stringPreferencesKey("nomor_hp")
        private val EMPLOYEE_STATUS = stringPreferencesKey("employee_status")

        private val ALLOW_PRESENSI = stringPreferencesKey("allow_presensi")
        @Volatile
        private var INSTANCE: UserDataPreferences? = null

        fun getInstance(dataStore: DataStore<Preferences>): UserDataPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = UserDataPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }

    fun getUserId() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[USER_ID]?: ""
        }
    }

    fun getEnrollNumber() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[ENROLL_NUMBER]?: ""
        }
    }

    fun getUserName() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[NAME]?: ""
        }
    }

    fun getUserFoto() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[FOTO]?: ""
        }
    }

    fun getUserJabatan() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[JABATAN]?: ""
        }
    }

    fun getUserGolongan() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[GOLONGAN]?: ""
        }
    }

    fun getUserUnitKerja() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[UNIT_KERJA]?: ""
        }
    }

    fun getUserEmail() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[EMAIL]?: ""
        }
    }

    fun getUserNomorHp() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[NOMOR_HP]?: ""
        }
    }

    fun getUserEmployeeStatus() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[EMPLOYEE_STATUS]?: ""
        }
    }

    fun getAllowPresensi() : Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[ALLOW_PRESENSI]?: ""
        }
    }

    suspend fun saveUserProfile(
        id : String,
        enroll_number : String,
        name: String,
        foto: String,
        jabatan: String,
        golongan: String,
        unit_kerja: String,
        email: String,
        nomor_hp: String,
        employee_status: String,
        allow_presensi: String
    ){
        dataStore.edit { preferences ->
            preferences[USER_ID] = id
            preferences[ENROLL_NUMBER] = enroll_number
            preferences[NAME] = name
            preferences[FOTO] = foto
            preferences[JABATAN] = jabatan
            preferences[GOLONGAN] = golongan
            preferences[UNIT_KERJA] = unit_kerja
            preferences[EMAIL] = email
            preferences[NOMOR_HP] = nomor_hp
            preferences[EMPLOYEE_STATUS] = employee_status
            preferences[ALLOW_PRESENSI] = allow_presensi
        }
    }

}
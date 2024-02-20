package com.ailenaguino.practica1.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ailenaguino.practica1.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settingsDB")

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val VOLUME_LVL = "volume_lvl"
        const val DARK_MODE = "dark_mode"
        const val BLUETOOTH = "bluetooth"
        const val VIBRATION = "vibration"
    }

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    private fun initUI() {
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }

        binding.swDarkMode.setOnCheckedChangeListener{_ , bool ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(bool, DARK_MODE)
            }
        }

        binding.swBluetooth.setOnCheckedChangeListener{_ , bool ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(bool, BLUETOOTH)
            }
        }

        binding.swVibration.setOnCheckedChangeListener{_ , bool ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(bool, VIBRATION)
            }
        }
    }

    private suspend fun saveVolume(value: Int) { //suspend porque se va a llamar dentro de un corrutina
        dataStore.edit { preference ->
            preference[intPreferencesKey(VOLUME_LVL)] = value
        }
    }

    private suspend fun saveOptions(value: Boolean, key: String) {
        dataStore.edit { preference ->
            preference[booleanPreferencesKey(key)] = value }
    }
}
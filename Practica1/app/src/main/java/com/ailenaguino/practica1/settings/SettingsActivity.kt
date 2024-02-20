package com.ailenaguino.practica1.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ailenaguino.practica1.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
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
    private var firstTime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { firstTime }.collect { settingsModel -> //collect : me engancho al flow y cada vez que haya un cambio avisame
                if (settingsModel != null) {
                    runOnUiThread {
                        binding.swVibration.isChecked = settingsModel.vibration
                        binding.swBluetooth.isChecked = settingsModel.bluetooth
                        binding.swDarkMode.isChecked = settingsModel.darkmode
                        binding.rsVolume.setValues(settingsModel.volume.toFloat())
                        firstTime = !firstTime
                    }
                }
            }
        }
        initUI()
    }

    private fun initUI() {
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }

        binding.swDarkMode.setOnCheckedChangeListener { _, bool ->

            if(bool) enableDarkMode() else disableDarkMode()

            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(bool, DARK_MODE)
            }
        }

        binding.swBluetooth.setOnCheckedChangeListener { _, bool ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(bool, BLUETOOTH)
            }
        }

        binding.swVibration.setOnCheckedChangeListener { _, bool ->
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
            preference[booleanPreferencesKey(key)] = value
        }
    }

    private fun getSettings(): Flow<SettingsModel> {
        return dataStore.data.map {
            SettingsModel(
                volume = it[intPreferencesKey(VOLUME_LVL)] ?: 50,
                darkmode = it[booleanPreferencesKey(DARK_MODE)] ?: false,
                bluetooth = it[booleanPreferencesKey(BLUETOOTH)] ?: true,
                vibration = it[booleanPreferencesKey(VIBRATION)] ?: true
            )
        }
    }

    private fun enableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}
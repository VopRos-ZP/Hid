package ru.cityron.hid.data.repository

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.cityron.hid.domain.repository.UsbRepository

class UsbRepositoryImpl(private val context: Context) : UsbRepository {

    override val device: Flow<UsbDevice?> = flow {
        while (true) {
            val manager = context.getSystemService(UsbManager::class.java)
            Log.d("UsbRepositoryImpl","devices -> ${manager.deviceList}")
            Log.d("UsbRepositoryImpl", "accessories -> ${manager.accessoryList}")
            if (manager.deviceList.isEmpty()) {
                emit(null)
            } else {
                emit(manager.deviceList.values.first())
            }
            delay(1000)
        }
    }

}
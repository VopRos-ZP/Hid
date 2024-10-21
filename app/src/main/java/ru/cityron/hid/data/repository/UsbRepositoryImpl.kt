package ru.cityron.hid.data.repository

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.cityron.hid.domain.repository.UsbRepository

class UsbRepositoryImpl(context: Context) : UsbRepository {

    private val manager = context.getSystemService(UsbManager::class.java)

    override val device: Flow<UsbDevice?> = flow {
        while (true) {
            if (manager.deviceList.isEmpty()) {
                emit(null)
            } else {
                emit(manager.deviceList.values.first())
            }
            delay(1000)
        }
    }

}
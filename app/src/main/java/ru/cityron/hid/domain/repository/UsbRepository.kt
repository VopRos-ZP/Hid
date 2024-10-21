package ru.cityron.hid.domain.repository

import android.hardware.usb.UsbDevice
import kotlinx.coroutines.flow.Flow

interface UsbRepository {
    val device: Flow<UsbDevice?>
}
package ru.cityron.hid.presentation.screens.root

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import ru.cityron.hid.domain.repository.UsbRepository

class RootViewModel(
    private val usbRepository: UsbRepository
) : ViewModel(), ContainerHost<RootViewState, RootSideEffect> {

    override val container = container<RootViewState, RootSideEffect>(
        initialState = RootViewState(),
        onCreate = {
            repeatOnSubscription {
                usbRepository.device.collect {
                    reduce { state.copy(data = it?.deviceName) }
                }
            }
        }
    )

}
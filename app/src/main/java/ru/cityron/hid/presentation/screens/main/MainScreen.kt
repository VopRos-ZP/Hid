package ru.cityron.hid.presentation.screens.main

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.KoinAndroidContext
import ru.cityron.hid.presentation.screens.root.RootScreen
import ru.cityron.hid.ui.theme.HidTheme

@Composable
fun MainScreen() {
    HidTheme {
        KoinAndroidContext {
            RootScreen()
        }
    }
}
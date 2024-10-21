package ru.cityron.hid.data.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.cityron.hid.data.repository.UsbRepositoryImpl
import ru.cityron.hid.domain.repository.UsbRepository
import ru.cityron.hid.presentation.screens.root.RootViewModel

private val dataModule = module {
    singleOf(::UsbRepositoryImpl) { bind<UsbRepository>() }
}

private val domainModule = module {

}

private val presentationModule = module {
    viewModelOf(::RootViewModel)
}

val appModule = module {
    includes(dataModule, domainModule, presentationModule)
}

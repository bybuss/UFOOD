package bob.colbaskin.main.presentation.di


import bob.colbaskin.main.presentation.mvi.MainViewModel
import bob.colbaskin.onboarding.presentation.di.onboardingModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    includes(onboardingModule)
    viewModel { MainViewModel(get()) }
}
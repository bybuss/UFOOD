package bob.colbaskin.onboarding.presentation.di

import bob.colbaskin.onboarding.presentation.mvi.OnboardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {
    viewModel { OnboardingViewModel(get()) }
}
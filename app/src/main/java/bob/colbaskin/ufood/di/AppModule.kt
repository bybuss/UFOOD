package bob.colbaskin.ufood.di

import bob.colbaskin.main.data.di.mainDataModule
import bob.colbaskin.main.presentation.di.presentationModule
import bob.colbaskin.onboarding.data.di.onboardingDataModule
import org.koin.dsl.module

val appModule = module {
    includes(mainDataModule)
    includes(onboardingDataModule)
    includes(presentationModule)
}
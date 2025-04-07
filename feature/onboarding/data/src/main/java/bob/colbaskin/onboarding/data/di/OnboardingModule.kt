package bob.colbaskin.onboarding.data.di

import bob.colbaskin.onboarding.data.UserPreferenceRepoImpl
import bob.colbaskin.onboarding.domain.UserPreferenceRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val onboardingDataModule = module {
    singleOf(::UserPreferenceRepoImpl) bind UserPreferenceRepository::class
}
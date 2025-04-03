package bob.colbaskin.main.data.di

import bob.colbaskin.main.data.UserPreferenceRepoImpl
import bob.colbaskin.main.domain.UserPreferenceRepository
import bob.colbaskin.storage.datastore.di.preferenceModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

import org.koin.dsl.module

val mainDataModule = module {
    includes(preferenceModule)
    singleOf(::UserPreferenceRepoImpl) bind UserPreferenceRepository::class
}
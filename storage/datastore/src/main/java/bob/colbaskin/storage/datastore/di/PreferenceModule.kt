package bob.colbaskin.storage.datastore.di

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import bob.colbaskin.storage.datastore.UserPreferences
import bob.colbaskin.storage.datastore.user.UserDataSource
import bob.colbaskin.storage.datastore.user.UserPreferenceSerializer
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferenceModule = module {
    single { UserPreferenceSerializer() }
    single<DataStore<UserPreferences>> {
        DataStoreFactory.create(
            serializer = get<UserPreferenceSerializer>()
        ) {
            androidContext().dataStoreFile("user_preferences.pb")
        }
    }
    single { UserDataSource(dataStore = get()) }
}
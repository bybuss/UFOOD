package bob.colbaskin.storage.datastore.user

import androidx.datastore.core.DataStore
import bob.colbaskin.common.model.AuthConfig
import bob.colbaskin.common.model.OnboardingConfig
import bob.colbaskin.common.model.ThemeConfig
import bob.colbaskin.storage.datastore.AuthStatus
import bob.colbaskin.storage.datastore.OnboardingStatus
import bob.colbaskin.storage.datastore.Theme
import bob.colbaskin.storage.datastore.UserPreferences
import bob.colbaskin.storage.datastore.copy
import kotlinx.coroutines.flow.Flow

class UserDataSource (
    private val dataStore: DataStore<UserPreferences>
) {
    fun getUserData(): Flow<UserPreferences> = dataStore.data

    suspend fun setTheme(config: ThemeConfig) {
        dataStore.updateData {
            it.copy {
                theme = when(config) {
                    ThemeConfig.SYSTEM -> Theme.FOLLOW_SYSTEM
                    ThemeConfig.LIGHT -> Theme.LIGHT
                    ThemeConfig.DARK -> Theme.DARK
                }
            }
        }
    }

    suspend fun setAuthType(type: AuthConfig) {
        dataStore.updateData {
            it.copy {
                authStatus = when(type) {
                    AuthConfig.NOT_AUTHENTICATED -> AuthStatus.NOT_AUTHENTICATED
                    AuthConfig.AUTHENTICATED -> AuthStatus.AUTHENTICATED
                    AuthConfig.GUEST -> AuthStatus.GUEST
                }
            }
        }
    }

    suspend fun setOnboardingStatus(status: OnboardingConfig) {
        dataStore.updateData {
            it.copy {
                    onboardingStatus = when(status) {
                        OnboardingConfig.NOT_STARTED -> OnboardingStatus.NOT_STARTED
                        OnboardingConfig.IN_PROGRESS -> OnboardingStatus.IN_PROGRESS
                        OnboardingConfig.COMPLETED -> OnboardingStatus.COMPLETED
                    }
                }
            }
        }

    suspend fun setDefaultCurrency(currency: String) {
        dataStore.updateData {
            it.copy {
                defaultCurrency = currency
            }
        }
    }

    suspend fun setIsNotificationEnabled(enabled: Boolean) {
        dataStore.updateData {
            it.copy {
                isNotificationEnabled = enabled
            }
        }
    }
}
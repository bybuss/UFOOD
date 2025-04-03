package bob.colbaskin.main.data

import bob.colbaskin.common.model.AuthConfig
import bob.colbaskin.common.model.OnboardingConfig
import bob.colbaskin.common.model.ThemeConfig
import bob.colbaskin.main.domain.UserPref
import bob.colbaskin.main.domain.UserPreferenceRepository
import bob.colbaskin.storage.datastore.AuthStatus
import bob.colbaskin.storage.datastore.OnboardingStatus
import bob.colbaskin.storage.datastore.Theme
import bob.colbaskin.storage.datastore.user.UserDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class UserPreferenceRepoImpl(private val source: UserDataSource) : UserPreferenceRepository {
    override fun getUserPreference(): Flow<UserPref> = flow {
        emit(
            source.getUserData().first().let {
                UserPref(
                    onboardingStatus = when(it.onboardingStatus) {
                        OnboardingStatus.COMPLETED -> OnboardingConfig.COMPLETED
                        OnboardingStatus.NOT_STARTED -> OnboardingConfig.NOT_STARTED
                        OnboardingStatus.IN_PROGRESS -> OnboardingConfig.IN_PROGRESS
                        OnboardingStatus.UNRECOGNIZED, null -> OnboardingConfig.NOT_STARTED
                    },
                    authType = when(it.authStatus) {
                        AuthStatus.GUEST -> AuthConfig.GUEST
                        AuthStatus.AUTHENTICATED -> AuthConfig.AUTHENTICATED
                        AuthStatus.NOT_AUTHENTICATED -> AuthConfig.NOT_AUTHENTICATED
                        AuthStatus.UNRECOGNIZED, null -> AuthConfig.NOT_AUTHENTICATED
                    },
                    theme = when(it.theme) {
                        Theme.DARK -> ThemeConfig.DARK
                        Theme.LIGHT -> ThemeConfig.LIGHT
                        Theme.FOLLOW_SYSTEM -> ThemeConfig.SYSTEM
                        else -> ThemeConfig.SYSTEM
                    },
                    defaultCurrency = it.defaultCurrency,
                    isNotificationEnabled = it.isNotificationEnabled
                )
            }
        )
    }
}
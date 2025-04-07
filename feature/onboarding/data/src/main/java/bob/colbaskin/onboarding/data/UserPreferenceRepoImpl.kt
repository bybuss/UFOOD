package bob.colbaskin.onboarding.data

import bob.colbaskin.common.model.AuthConfig
import bob.colbaskin.common.model.OnboardingConfig
import bob.colbaskin.onboarding.domain.UserPreferenceRepository
import bob.colbaskin.storage.datastore.user.UserDataSource

class UserPreferenceRepoImpl(
    private val source: UserDataSource
) : UserPreferenceRepository {
    override suspend fun saveUserAuth(authType: AuthConfig) = source.setAuthType(authType)

    override suspend fun saveUserOnboardingStatus(onboardingStatus: OnboardingConfig)
        = source.setOnboardingStatus(onboardingStatus)
}
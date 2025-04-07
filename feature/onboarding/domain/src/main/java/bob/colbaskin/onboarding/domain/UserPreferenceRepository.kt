package bob.colbaskin.onboarding.domain

import bob.colbaskin.common.model.AuthConfig
import bob.colbaskin.common.model.OnboardingConfig

interface UserPreferenceRepository {
    suspend fun saveUserAuth(authType: AuthConfig)

    suspend fun saveUserOnboardingStatus(onboardingStatus: OnboardingConfig)
}
package bob.colbaskin.main.domain

import bob.colbaskin.common.model.AuthConfig
import bob.colbaskin.common.model.OnboardingConfig
import bob.colbaskin.common.model.ThemeConfig

data class UserPref(
    val onboardingStatus: OnboardingConfig,
    val authType: AuthConfig,
    val theme: ThemeConfig,
    val defaultCurrency: String,
    val isNotificationEnabled: Boolean
)
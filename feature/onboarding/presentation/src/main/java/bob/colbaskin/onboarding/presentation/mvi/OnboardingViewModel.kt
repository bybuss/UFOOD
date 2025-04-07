package bob.colbaskin.onboarding.presentation.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bob.colbaskin.common.model.OnboardingConfig
import bob.colbaskin.onboarding.domain.UserPreferenceRepository
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val preferenceRepository: UserPreferenceRepository
) : ViewModel() {

    fun event(event: Event) {
        when(event) {
            Event.OnboardingCompleted -> {
                viewModelScope.launch {
                    preferenceRepository.saveUserOnboardingStatus(OnboardingConfig.COMPLETED)
                }
            }
            Event.OnboardingInProgress -> {
                viewModelScope.launch {
                    preferenceRepository.saveUserOnboardingStatus(OnboardingConfig.IN_PROGRESS)
                }
            }
        }
    }
}
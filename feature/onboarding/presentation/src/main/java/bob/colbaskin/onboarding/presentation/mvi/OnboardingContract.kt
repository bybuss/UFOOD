package bob.colbaskin.onboarding.presentation.mvi

sealed interface Event {
    data object OnboardingInProgress : Event
    data object OnboardingCompleted : Event
}
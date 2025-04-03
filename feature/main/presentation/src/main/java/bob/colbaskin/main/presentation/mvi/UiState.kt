package bob.colbaskin.main.presentation.mvi

import bob.colbaskin.main.domain.UserPref

sealed interface UiState {
    data object Loading : UiState
    data class Success(val data: UserPref) : UiState
}
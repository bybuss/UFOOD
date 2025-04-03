package bob.colbaskin.main.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import bob.colbaskin.common.model.AuthConfig
import bob.colbaskin.common.model.ThemeConfig
import bob.colbaskin.designsystem.ScreenContainer
import bob.colbaskin.designsystem.ui.theme.UFOODTheme
import bob.colbaskin.designsystem.utils.UiText
import bob.colbaskin.designsystem.utils.asString
import bob.colbaskin.main.presentation.mvi.UiState
import bob.colbaskin.main.presentation.navigation.Graphs
import bob.colbaskin.main.presentation.navigation.navigateToOnboarding
import bob.colbaskin.main.presentation.navigation.navigateToDashBoard
import kotlinx.coroutines.delay

@Composable
fun AppContent(uiState: UiState.Success) {
    val navController = rememberNavController()
    UFOODTheme(darkTheme = isDarkTheme(uiState)) {
        var showErrorMessage by remember { mutableStateOf(false) }
        var errorMessage by remember { mutableStateOf<UiText>(UiText.EmptyString) }
        LaunchedEffect(showErrorMessage) {
            if (showErrorMessage) {
                delay(3000)
                showErrorMessage = false
            }
        }
        ScreenContainer(showErrorMessage, errorMessage.asString()) {
            NavHost(
                navController = navController,
                startDestination = getDestination(uiState.data.authType)
            ) {
                navigateToOnboarding(
                    navController,
                    onboardingConfig = uiState.data.onboardingStatus
                ) { showError, message ->
                    showErrorMessage = showError
                    errorMessage = message
                }
                navigateToDashBoard(navController)
            }
        }
    }
}

private fun getDestination(authConfig: AuthConfig) =
    when(authConfig) {
        AuthConfig.AUTHENTICATED -> Graphs.Dashboard
        else -> Graphs.Onboarding
    }

@Composable
private fun isDarkTheme(uiState: UiState): Boolean {
    return when (uiState) {
        UiState.Loading -> false
        is UiState.Success -> when(uiState.data.theme) {
            ThemeConfig.DARK -> true
            ThemeConfig.LIGHT -> false
            ThemeConfig.SYSTEM -> isSystemInDarkTheme()
        }
    }
}
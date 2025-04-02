package bob.colbaskin.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import bob.colbaskin.designsystem.ScreenContainer
import bob.colbaskin.designsystem.ui.theme.UFOODTheme
import bob.colbaskin.designsystem.utils.UiText
import bob.colbaskin.designsystem.utils.asString
import bob.colbaskin.main.presentation.navigation.Graphs
import bob.colbaskin.main.presentation.navigation.navigateToOnboarding
import kotlinx.coroutines.delay

@Composable
fun AppContent() {
    val navController = rememberNavController()
    val context = LocalContext.current
    UFOODTheme {
        var showErrorMessage by remember { mutableStateOf(false) }
        var errorMessage by remember { mutableStateOf<UiText>(UiText.EmptyString) }
        LaunchedEffect(showErrorMessage) {
            if (showErrorMessage) {
                delay(3000)
                showErrorMessage = false
            }
        }
        ScreenContainer(showErrorMessage, errorMessage.asString()) {
            NavHost(navController, Graphs.Onboarding) {
                navigateToOnboarding(navController) { showError, message ->
                    showErrorMessage = showError
                    errorMessage = message
                }
            }
        }
    }
}

@Preview
@Composable
fun AppContentPreview() {
    AppContent()
}
package bob.colbaskin.main.presentation.navigation

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import bob.colbaskin.common.model.OnboardingConfig
import bob.colbaskin.designsystem.utils.UiText
import bob.colbaskin.onboarding.presentation.signin.SignIn
import bob.colbaskin.onboarding.presentation.welcome.IntroductionScreen
import bob.colbaskin.onboarding.presentation.welcome.WelcomeScreen

fun NavGraphBuilder.navigateToOnboarding(
    navController: NavHostController,
    onboardingConfig: OnboardingConfig,
    onError: (Boolean, UiText) -> Unit
) {
    navigation<Graphs.Onboarding>(
        startDestination = getStartDestination(onboardingConfig)
    ) {
        animatedComposable<Destinations.Welcome> {
            WelcomeScreen(
                onNextScreen = { navController.navigate(Destinations.Introduction) }
            )
        }
        animatedComposable<Destinations.Introduction> {
            IntroductionScreen (
                onNextScreen = { navController.navigate(Destinations.SignIn) }
            )
        }
        animatedComposable<Destinations.SignIn> {
            SignIn(
                onNextScreen = { navController.navigate(Destinations.Home) },
                onError = onError
            )
        }
    }
}

fun NavGraphBuilder.navigateToDashBoard(navController: NavHostController) {
    navigation<Graphs.Dashboard>(
        startDestination = Destinations.Home
    ) {
        animatedComposable<Destinations.Home> {
            Text(text = "Home")
        }
    }
}

private fun getStartDestination(onboardingConfig: OnboardingConfig) = when(onboardingConfig) {
    OnboardingConfig.NOT_STARTED -> Destinations.Welcome
    OnboardingConfig.IN_PROGRESS -> Destinations.Introduction
    OnboardingConfig.COMPLETED -> Destinations.SignIn
    else -> Destinations.Welcome
}
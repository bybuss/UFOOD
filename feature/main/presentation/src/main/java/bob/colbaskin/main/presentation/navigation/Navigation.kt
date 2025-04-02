package bob.colbaskin.main.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import bob.colbaskin.designsystem.utils.UiText
import bob.colbaskin.onboarding.presentation.signin.SignIn
import bob.colbaskin.onboarding.presentation.welcome.IntroductionScreen
import bob.colbaskin.onboarding.presentation.welcome.WelcomeScreen

fun NavGraphBuilder.navigateToOnboarding(
    navController: NavHostController,
    onError: (Boolean, UiText) -> Unit
) {
    navigation<Graphs.Onboarding>(
        startDestination = Destinations.Welcome
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
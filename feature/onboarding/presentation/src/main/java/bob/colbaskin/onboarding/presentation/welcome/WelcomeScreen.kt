package bob.colbaskin.onboarding.presentation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import bob.colbaskin.designsystem.CustomText
import bob.colbaskin.designsystem.NextButton
import bob.colbaskin.designsystem.ui.theme.CustomTheme
import bob.colbaskin.onboarding.presentation.R

@Composable
fun WelcomeScreen(onNextScreen: () -> Unit) {
    Welcome(onNextScreen)
}

@Composable
private fun Welcome(onNextScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = CustomTheme.dimensions.dimensions16,
                bottom = CustomTheme.dimensions.dimensions32,
                start = CustomTheme.dimensions.dimensions16,
                end = CustomTheme.dimensions.dimensions16
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) { 
            CustomText(
                text = stringResource(R.string.welcome_text),
                textStyle = CustomTheme.typography.airfool.titleMedium,
            )
            CustomText(
                text = stringResource(R.string.welcome_app_name),
                textStyle = CustomTheme.typography.madeInfinity.labelLarge,
            )
            CustomText(
                text = stringResource(R.string.welcome_description),
                textStyle = CustomTheme.typography.brightoWander.titleLarge,
            )
            CustomText(
                text = stringResource(R.string.welcome_get_started),
                textStyle = CustomTheme.typography.inter.titleSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
            Spacer(modifier = Modifier.weight(1f))
            NextButton(
                text = stringResource(R.string.welcome_get_started),
                isFullWidth = false,
                isMainButton = false,
                onClick = {
                    //dispatch(Event.OnboardingInProgress)
                    onNextScreen()
                },
            )
        }
    }
}
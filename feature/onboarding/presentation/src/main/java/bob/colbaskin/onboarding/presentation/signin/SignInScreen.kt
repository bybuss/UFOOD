package bob.colbaskin.onboarding.presentation.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import bob.colbaskin.designsystem.CustomText
import bob.colbaskin.designsystem.utils.UiText

@Composable
fun SignInScreen(
    onNextScreen: () -> Unit,
    onError: (Boolean, UiText) -> Unit
) {

}

@Composable
fun SignIn(
    onNextScreen: () -> Unit,
    onError: (Boolean, UiText) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        CustomText(text = "Тут будет WebView с кастомной авторизацией")
    }
}
package bob.colbaskin.designsystem

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import bob.colbaskin.designsystem.ui.theme.CustomTheme

@Composable
fun ScreenContainer(
    showError: Boolean = false,
    errorMessage: String,
    content: @Composable () -> Unit
) {
    var showErrorMessage by remember { mutableStateOf(showError) }

    LaunchedEffect(showError) {
        showErrorMessage = showError
    }

    Box(modifier = Modifier.fillMaxSize()) {
        content()

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth()
                .background(CustomTheme.colors.errorContainer)
                .padding(CustomTheme.dimensions.dimensions8),
            visible = showErrorMessage,
            enter = slideInVertically(
                initialOffsetY = { -30 }
            ) + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            CustomText(
                text = errorMessage,
                textStyle = CustomTheme.typography.inter.titleSmall,
                color = CustomTheme.colors.onErrorContainer,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}
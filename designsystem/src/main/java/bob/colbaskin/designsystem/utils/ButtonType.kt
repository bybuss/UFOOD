package bob.colbaskin.designsystem.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import bob.colbaskin.designsystem.ui.theme.CustomTheme

enum class ButtonType {
    NEXT,
    BUY_INGREDIENTS,
    TEXT
}

@Composable
fun ButtonType.getTextType(): TextStyle  = when(this) {
    ButtonType.NEXT -> CustomTheme.typography.madeInfinity.titleMedium
    ButtonType.BUY_INGREDIENTS -> CustomTheme.typography.inter.titleSmall
    ButtonType.TEXT -> CustomTheme.typography.inter.titleMedium
}

@Composable
fun ButtonType.getButtonColors() = when(this) {
    ButtonType.NEXT -> ButtonDefaults.buttonColors(
        containerColor = CustomTheme.colors.primaryButton
    )
    ButtonType.BUY_INGREDIENTS -> ButtonDefaults.buttonColors(
        containerColor = CustomTheme.colors.buyButton
    )
    ButtonType.TEXT -> ButtonDefaults.textButtonColors()
}

@Composable
fun Modifier.getButtonSize(isFullWidth: Boolean, isMainButton: Boolean) = if (isFullWidth) {
    fillMaxWidth()
} else {
    width(CustomTheme.dimensions.dimensions100)
}.height(
    if (isMainButton) {
        CustomTheme.dimensions.dimensions64
    } else {
        CustomTheme.dimensions.dimensions48
    }
)

@Composable
fun Modifier.getIconSize(buttonType: ButtonType) = when(buttonType) {
    ButtonType.NEXT -> size(CustomTheme.dimensions.dimensions80)
    else -> size(CustomTheme.dimensions.dimensions24)
}

package bob.colbaskin.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import bob.colbaskin.designsystem.ui.theme.CustomTheme
import bob.colbaskin.designsystem.ui.theme.UFOODTheme
import bob.colbaskin.designsystem.utils.ButtonType
import bob.colbaskin.designsystem.utils.getButtonSize
import bob.colbaskin.designsystem.utils.getButtonColors
import bob.colbaskin.designsystem.utils.getIconSize
import bob.colbaskin.designsystem.utils.getTextType

@Composable
fun NextButton(
    text: String,
    icon: Int,
    isFullWidth: Boolean = true,
    isMainButton: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.getButtonSize(isFullWidth, isMainButton),
        shape = CustomTheme.shapes.button,
        colors = ButtonType.NEXT.getButtonColors()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CustomText(
                text = text,
                textType = ButtonType.NEXT.getTextType()
            )
            Image(
                painter = painterResource(icon),
                contentDescription = "$text button",
                modifier = modifier
                    .align(Alignment.CenterEnd)
                    .getIconSize(ButtonType.NEXT)
                    .alpha(0.15f),

            )
        }
    }
}

@Composable
fun BuyButton(
    text: String,
    icon: Int,
    isFullWidth: Boolean = true,
    isMainButton: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.getButtonSize(isFullWidth, isMainButton),
        shape = CustomTheme.shapes.button,
        colors = ButtonType.BUY_INGREDIENTS.getButtonColors(),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = "$text button",
                modifier = modifier.getIconSize(ButtonType.BUY_INGREDIENTS)
            )
            CustomText(
                text = text,
                textType = ButtonType.BUY_INGREDIENTS.getTextType(),
                textAlign = TextAlign.Center,
            )
            Image(
                painter = painterResource(icon),
                contentDescription = "$text button",
                modifier = modifier.getIconSize(ButtonType.BUY_INGREDIENTS)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BuyButtonPreview() {
    UFOODTheme {
        Column(modifier = Modifier.padding(CustomTheme.dimensions.dimensions16)) {
            NextButton(
                text = "Продолжить",
                icon = R.drawable.arrows,
                onClick = { },
            )
            Spacer(modifier = Modifier.padding(CustomTheme.dimensions.dimensions16))
            BuyButton(
                text = "Купить ингридиенты",
                icon = R.drawable.bag,
                onClick = { },
            )
        }
    }
}
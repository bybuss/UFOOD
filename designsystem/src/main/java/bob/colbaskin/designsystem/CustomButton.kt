package bob.colbaskin.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import bob.colbaskin.designsystem.ui.theme.CustomTheme
import bob.colbaskin.designsystem.utils.ButtonType
import bob.colbaskin.designsystem.utils.buttonSize
import bob.colbaskin.designsystem.utils.getButtonColors
import bob.colbaskin.designsystem.utils.getButtonElevation
import bob.colbaskin.designsystem.utils.getTextType
import bob.colbaskin.designsystem.utils.iconSize

@Composable
fun CustomButton(
    text: String,
    buttonType: ButtonType = ButtonType.NEXT,
    icon: Int? = null,
    isFullWidth: Boolean = false,
    isMainButton: Boolean = true,
    isDoubleIcons: Boolean = false,
    isRightIconAlign: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.width(CustomTheme.dimensions.dimensions16)
) {
    Button(
        onClick = onClick,
        modifier = Modifier.buttonSize(isFullWidth, isMainButton),
        colors = buttonType.getButtonColors(),
        elevation = buttonType.getButtonElevation(),
        shape = CustomTheme.shapes.button
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            if (isDoubleIcons) {
                icon?.let {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = "$text button",
                        modifier = Modifier.iconSize(buttonType)
                    )

                }
            }
            CustomText(
                text = text,
                textType = buttonType.getTextType(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            if (!isDoubleIcons) {
                Spacer(modifier = modifier.width(CustomTheme.dimensions.dimensions16))
            }
            icon?.let {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "$text button",
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .iconSize(buttonType)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(
        text = "Продолжить",
        buttonType = ButtonType.NEXT,
        icon = R.drawable.bag,
        isFullWidth = true,
        isMainButton = true,
        isRightIconAlign = false,
        isDoubleIcons = true,
        onClick = { },
    )
}
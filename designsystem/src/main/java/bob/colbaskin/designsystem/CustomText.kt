package bob.colbaskin.designsystem

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import bob.colbaskin.designsystem.ui.theme.CustomTheme
import bob.colbaskin.designsystem.utils.TextType
import bob.colbaskin.designsystem.utils.getTextStyle

@Composable
fun CustomText(
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    textType: TextType = TextType.BODY_LARGE,
    color: Color = CustomTheme.colors.text,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        textAlign = textAlign,
        style = textType.getTextStyle(),
        color = color,
        modifier = modifier,
    )
}
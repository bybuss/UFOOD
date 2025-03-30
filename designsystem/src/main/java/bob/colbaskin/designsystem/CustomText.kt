package bob.colbaskin.designsystem

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import bob.colbaskin.designsystem.ui.theme.CustomTheme

@Composable
fun CustomText(
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    textStyle: TextStyle = CustomTheme.typography.inter.titleMedium,
    color: Color = CustomTheme.colors.text,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        textAlign = textAlign,
        style = textStyle,
        color = color,
        modifier = modifier,
    )
}
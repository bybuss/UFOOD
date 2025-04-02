package bob.colbaskin.designsystem.utils

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed interface UiText {
    data class StringResource(@StringRes val id: Int) : UiText
    data class SimpleString(val text: String) : UiText
    data object EmptyString : UiText

    fun getString(context: Context) =
        when (this) {
            EmptyString -> ""
            is SimpleString -> text
            is StringResource -> context.getString(id)
        }
}

@Composable
fun UiText.asString(): String {
    return when (this) {
        UiText.EmptyString -> ""
        is UiText.SimpleString -> text
        is UiText.StringResource -> stringResource(id)
    }
}
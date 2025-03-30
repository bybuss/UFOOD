package bob.colbaskin.designsystem.utils

import android.content.Context
import androidx.annotation.StringRes

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
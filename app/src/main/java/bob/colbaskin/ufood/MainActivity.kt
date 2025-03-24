package bob.colbaskin.ufood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bob.colbaskin.designsystem.BuyButton
import bob.colbaskin.designsystem.NextButton
import bob.colbaskin.designsystem.R
import bob.colbaskin.designsystem.ui.theme.CustomTheme
import bob.colbaskin.designsystem.ui.theme.UFOODTheme
import bob.colbaskin.designsystem.utils.CustomDarkPreview
import bob.colbaskin.designsystem.utils.CustomLightPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UFOODTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    AppContent()
                }
            }
        }
    }
}

@Composable
fun AppContent() {
    Column(
        modifier = Modifier.padding(CustomTheme.dimensions.dimensions16),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
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

@Composable
@CustomLightPreview
@CustomDarkPreview
fun AppPreview() {
    AppContent()
}
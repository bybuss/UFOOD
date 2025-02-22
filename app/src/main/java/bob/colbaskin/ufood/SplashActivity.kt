package bob.colbaskin.ufood

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import bob.colbaskin.ufood.ui.theme.CustomTheme
import bob.colbaskin.ufood.ui.theme.UFOODTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UFOODTheme {
                SplashScreen()
            }
        }
    }
}

@Composable
private fun SplashScreen() {
    val context = LocalContext.current
    val burgerMainOffset = remember { Animatable(900f) }
    val burgerSecondOffseet = remember { Animatable(-900f) }

    LaunchedEffect(key1 = true) {
        delay(500)

        burgerMainOffset.animateTo(
            targetValue = -60f,
            animationSpec = tween(
                durationMillis = 750,
                easing = FastOutSlowInEasing
            )
        )

        burgerSecondOffseet.animateTo(
            targetValue = -60f,
            animationSpec = tween(
                durationMillis = 750,
                easing = FastOutSlowInEasing
            )
        )

        context.startActivity(Intent(context, MainActivity::class.java))
        (context as? Activity)?.finish()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CustomTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 150.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.splash_main_logo),
                contentDescription = "Splash screen main logo",
                modifier = Modifier
                    .scale(1.7f)
            )

            Text(
                text = stringResource(R.string.app_name),
                color = Color.White,
                fontWeight = FontWeight.W900,
                fontSize = 70.sp,
                modifier = Modifier
                    .offset(x = 5.dp, y = -45.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.small_carrot),
            contentDescription = "Small carrot image",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = -5.dp, y = -10.dp)
                .zIndex(2f)
                .scale(1.5f)
        )

        Image(
            painter = painterResource(R.drawable.blurred_carrot),
            contentDescription = "Blurred carrot image",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = -80.dp, y = 25.dp)
                .zIndex(1f)
                .scale(2f)
        )

        Image(
            painter = painterResource(R.drawable.blurred_avocado),
            contentDescription = "Blurred avocado image",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 80.dp, y = 47.dp)
                .zIndex(2f)
                .scale(1.7f)
        )

        Image(
            painter = painterResource(R.drawable.splash_main_logo),
            contentDescription = "Burger",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = burgerSecondOffseet.value.dp, y = -30.dp)
                .zIndex(0f)
                .scale(8.5f)
        )
        Image(
            painter = painterResource(R.drawable.splash_main_logo),
            contentDescription = "Burger",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = burgerMainOffset.value.dp)
                .zIndex(0f)
                .scale(4.5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DarkSplashScreenPreview() {
    UFOODTheme (darkTheme = true) {
        SplashScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun LightSplashScreenPreview() {
    UFOODTheme (darkTheme = false) {
        SplashScreen()
    }
}
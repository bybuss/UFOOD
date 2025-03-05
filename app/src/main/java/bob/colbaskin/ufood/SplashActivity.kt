package bob.colbaskin.ufood

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import bob.colbaskin.designsystem.ui.theme.UFOODTheme
import bob.colbaskin.ufood.utils.calculateImageScaleToFullscreen
import bob.colbaskin.ufood.utils.CustomDarkPreview
import bob.colbaskin.ufood.utils.CustomLightPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    val density = LocalDensity.current
    val screenPxWidth = with(density) {
        LocalConfiguration.current.screenWidthDp.dp.toPx()
    }
    val screenPxHeight = with(density) {
        LocalConfiguration.current.screenHeightDp.dp.toPx()
    }
    val center = with(density) {
        (screenPxWidth / 2).toDp()
    }
    val endScreen = with(density) {
        screenPxWidth.toDp()
    }

    var isAnimated by remember { mutableStateOf(false) }
    val burgerTransition = updateTransition(targetState = isAnimated)
    val burgerImage = ImageBitmap.imageResource(R.drawable.splash_main_logo)
    val imageHalfWidth = with(density) {
        (burgerImage.width / 2).toDp()
    }
    val burgerXOffset by burgerTransition.animateDp(
        transitionSpec = {
            spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessVeryLow
            )
        }
    ) { state ->
        if (state) center - imageHalfWidth else -endScreen
    }
    val burgerSize = remember { Animatable(1f) }

    val avocadoOffset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }
    val smallCarrotOffset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }
    val blurredCarrotOffset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }

    val imageScale = calculateImageScaleToFullscreen(
        R.drawable.splash_main_logo,
        screenPxWidth,
        screenPxHeight
    )

    LaunchedEffect(key1 = true) {
        launch {
            avocadoOffset.animateTo(
                targetValue = Offset((5..9).random().toFloat(), (3..7).random().toFloat()),
                animationSpec = infiniteRepeatable(
                    animation = tween(2000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
        launch {
            smallCarrotOffset.animateTo(
                targetValue = Offset((-13..-8).random().toFloat(), (9..14).random().toFloat()),
                animationSpec = infiniteRepeatable(
                    animation = tween(2000, easing = LinearEasing, delayMillis = 75),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
        launch {
            blurredCarrotOffset.animateTo(
                targetValue = Offset((8..12).random().toFloat(), (-6..-2).random().toFloat()),
                animationSpec = infiniteRepeatable(
                    animation = tween(2000, easing = LinearEasing, delayMillis = 250),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
        delay(1500)
        isAnimated = true
        delay(1000)
        burgerSize.animateTo(
            targetValue = imageScale,
            animationSpec = tween(350, easing = LinearEasing)
        )

        context.startActivity(Intent(context, MainActivity::class.java))
        (context as? Activity)?.finish()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = bob.colbaskin.designsystem.ui.theme.CustomTheme.colors.background)
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 150.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.splash_main_logo),
                contentDescription = "Splash screen main logo",
                modifier = Modifier.scale(1.8f)
            )
            Text(
                text = stringResource(R.string.app_name),
                style = bob.colbaskin.designsystem.ui.theme.CustomTheme.typography.displayLarge,
                color = Color.White
            )
        }

        Image(
            painter = painterResource(R.drawable.blurred_avocado),
            contentDescription = "Blurred avocado image",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .zIndex(2f)
                .scale(1.55f)
                .offset(x = 20.dp, y = 32.dp)
                .offset {
                    IntOffset(
                        x = avocadoOffset.value.x.toInt(),
                        y = avocadoOffset.value.y.toInt()
                    )
                }
        )

        Box (modifier = Modifier.align(Alignment.BottomStart)) {
            Image(
                painter = painterResource(R.drawable.small_carrot),
                contentDescription = "Small carrot image",
                modifier = Modifier
                    .zIndex(2f)
                    .scale(1.1f)
                    .offset(x = 15.dp, y = (-20).dp)
                    .offset {
                        IntOffset(
                            x = smallCarrotOffset.value.x.toInt(),
                            y = smallCarrotOffset.value.y.toInt()
                        )
                    }
            )
            Image(
                painter = painterResource(R.drawable.blurred_carrot),
                contentDescription = "Blurred carrot image",
                modifier = Modifier
                    .zIndex(1f)
                    .scale(2f)
                    .offset {
                        IntOffset(
                            x = blurredCarrotOffset.value.x.toInt(),
                            y = blurredCarrotOffset.value.y.toInt()
                        )
                    }

            )
        }
        
        Image(
            painter = painterResource(R.drawable.splash_main_logo),
            contentDescription = "Burger",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = -burgerXOffset)
                .zIndex(3f)
                .scale(1.5f * burgerSize.value)
        )
    }
}

@CustomLightPreview
@CustomDarkPreview
@Composable
fun SplashPreviewDark() {
    UFOODTheme {
        SplashScreen()
    }
}


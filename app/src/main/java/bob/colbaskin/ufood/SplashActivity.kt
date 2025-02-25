package bob.colbaskin.ufood

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import bob.colbaskin.ufood.ui.theme.CustomTheme
import bob.colbaskin.ufood.ui.theme.UFOODTheme
import bob.colbaskin.ufood.utils.calculateImageScaleToFullscreen
import bob.colbaskin.ufood.utils.CustomDarkPreview
import bob.colbaskin.ufood.utils.CustomLightPreview
import kotlinx.coroutines.coroutineScope
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
    val transition = updateTransition(targetState = isAnimated)
    val burgerImage = ImageBitmap.imageResource(R.drawable.splash_main_logo)
    val imageHalfWidth = with(density) {
        (burgerImage.width / 2).toDp()
    }
    val burgerXOffset by transition.animateDp(
        transitionSpec = { tween(durationMillis = 750, easing = FastOutSlowInEasing) }
    ) { state ->
        if (state) center - imageHalfWidth else -endScreen
    }
    val burgerSize = remember { Animatable(1f) }

    val avocadoOffsetX = remember { Animatable(0f) }
    val avocadoOffsetY = remember { Animatable(0f) }

    val carrotOffsetX = remember { Animatable(0f) }
    val carrotOffsetY = remember { Animatable(0f) }

    val blurredCarrotOffsetX = remember { Animatable(0f) }
    val blurredCarrotOffsetY = remember { Animatable(0f) }

    val animationRoutine = rememberCoroutineScope()

    val imageScale = calculateImageScaleToFullscreen(
        R.drawable.splash_main_logo,
        screenPxWidth,
        screenPxHeight
    )


    LaunchedEffect(key1 = true) {
        Log.i("SplashActivity", "Type center: ${center::class.simpleName}")
        Log.i("SplashActivity", "Type end screen: ${endScreen::class.simpleName} $endScreen")
        Log.i("SplashActivity", "Type density: ${density.density::class.simpleName}")
        animationRoutine.launch {
            coroutineScope {
                launch {
                    carrotOffsetX.animateTo(
                        targetValue = (-13..-8).random().toFloat(),
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = 2000,
                                easing = LinearEasing,
                                delayMillis = 250
                            ),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }
                launch {
                    carrotOffsetY.animateTo(
                        targetValue = (9..14).random().toFloat(),
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = 2000,
                                easing = LinearEasing,
                                delayMillis = 75
                            ),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }
            }
        }
        animationRoutine.launch {
            coroutineScope {
                launch {
                    blurredCarrotOffsetX.animateTo(
                        targetValue = (8..12).random().toFloat(),
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = 2000,
                                easing = LinearEasing,
                                delayMillis = 100
                            ),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }
                launch {
                    blurredCarrotOffsetY.animateTo(
                        targetValue = (-6..-2).random().toFloat(),
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = 2000,
                                easing = LinearEasing,
                                delayMillis = 250
                            ),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }
            }
        }
        animationRoutine.launch {
            coroutineScope {
                launch {
                    avocadoOffsetX.animateTo(
                        targetValue = (5..9).random().toFloat(),
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = 2000,
                                easing = LinearEasing
                            ),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }
                launch {
                    avocadoOffsetY.animateTo(
                        targetValue = (3..7).random().toFloat(),
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = 2000,
                                easing = LinearEasing
                            ),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }
            }
        }
        delay(2000)
        isAnimated = true
        delay(750)
        burgerSize.animateTo(
            targetValue = imageScale,
            animationSpec = tween(
                durationMillis = 450,
                easing = LinearEasing
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
                style = CustomTheme.typography.headLineLarge,
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
                .offset(
                    x = 20.dp + avocadoOffsetX.value.dp,
                    y = 32.dp + avocadoOffsetY.value.dp
                )
        )

        Box (modifier = Modifier.align(Alignment.BottomStart)) {
            Image(
                painter = painterResource(R.drawable.small_carrot),
                contentDescription = "Small carrot image",
                modifier = Modifier
                    .zIndex(2f)
                    .scale(1.1f)
                    .offset(
                        x = 15.dp + carrotOffsetX.value.dp,
                        y = (-20).dp + carrotOffsetY.value.dp
                    )
            )
            Image(
                painter = painterResource(R.drawable.blurred_carrot),
                contentDescription = "Blurred carrot image",
                modifier = Modifier
                    .zIndex(1f)
                    .scale(2f)
                    .offset(
                        x = blurredCarrotOffsetX.value.dp,
                        y = blurredCarrotOffsetY.value.dp
                    )
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
    UFOODTheme  {
        SplashScreen()
    }
}
package bob.colbaskin.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun Lottie(
    lottieUrl: String,
    modifier: Modifier = Modifier
) {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.Url(lottieUrl)
    )

    val compositionProgress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = { compositionProgress }
    )
}
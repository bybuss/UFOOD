package bob.colbaskin.onboarding.presentation.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import bob.colbaskin.designsystem.BuyButton
import bob.colbaskin.designsystem.CustomText
import bob.colbaskin.designsystem.CustomTextButton
import bob.colbaskin.designsystem.Lottie
import bob.colbaskin.designsystem.PagerWithIndicator
import bob.colbaskin.designsystem.ui.theme.CustomTheme
import bob.colbaskin.designsystem.ui.theme.UFOODTheme
import bob.colbaskin.designsystem.utils.SpanType
import bob.colbaskin.designsystem.utils.createAnnotatedString
import bob.colbaskin.onboarding.presentation.R
import bob.colbaskin.onboarding.presentation.mvi.Event
import bob.colbaskin.onboarding.presentation.mvi.OnboardingViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun IntroductionScreen(
    onNextScreen: () -> Unit,
    viewModel: OnboardingViewModel = koinViewModel()
) {
    OnBoarding(onNextScreen, viewModel::event)
}

@Composable
private fun OnBoarding(
    onNextScreen: () -> Unit,
    dispatch: (Event) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(CustomTheme.dimensions.dimensions16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val coroutineScope = rememberCoroutineScope()
        val pageCount = stringArrayResource(R.array.onboarding_title).size
        val pagerState = rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f,
            pageCount = { pageCount }
        )
        val buttonText = if (pagerState.currentPage == pageCount - 1) {
            stringResource(R.string.welcome_get_started)
        } else {
            stringResource(R.string.next)
        }
        PagerWithIndicator(
            pageCount = pageCount,
            modifier = Modifier
                .weight(1f)
                .padding(bottom = CustomTheme.dimensions.dimensions24),
            pagerState = pagerState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = CustomTheme.dimensions.dimensions16),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Lottie(
                    lottieUrl = stringArrayResource(R.array.onboarding_animation)[it],
                    modifier = Modifier.size(CustomTheme.dimensions.dimensions300)
                )
                Spacer(modifier = Modifier.weight(1f))
                CustomText(
                    text = createAnnotatedString(
                        fullText = stringArrayResource(R.array.onboarding_title)[it],
                        spans = listOf(
                            SpanType.HeadingSpan(
                                text = stringArrayResource(R.array.onboarding_title)[it].split(" ")[0],
                                styles = SpanStyle(color = CustomTheme.colors.primaryButton)
                            )
                        )
                    ),
                    textStyle = CustomTheme.typography.nunito.headlineSmall
                )
                Spacer(modifier = Modifier.padding(CustomTheme.dimensions.dimensions8))
                CustomText(
                    text = stringArrayResource(R.array.onboarding_description)[it],
                    textStyle = CustomTheme.typography.nunito.labelSmall
                )
                Spacer(modifier = Modifier.padding(CustomTheme.dimensions.dimensions24))
            }
        }
        BuyButton(
            text = buttonText,
            icon = null,
            isFullWidth = false,
            isMainButton = false,
            onClick = {
                coroutineScope.launch {
                    if (pagerState.currentPage < pageCount - 1) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        dispatch(Event.OnboardingCompleted)
                        onNextScreen()
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(CustomTheme.dimensions.dimensions4))
        CustomTextButton(
            text = stringResource(R.string.skip),
            isFullWidth = false,
            onClick = {
                dispatch(Event.OnboardingCompleted)
                onNextScreen()
            },
        )
    }
}
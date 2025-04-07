package bob.colbaskin.designsystem

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import bob.colbaskin.designsystem.ui.theme.CustomTheme

@Composable
fun PagerWithIndicator(
    pageCount: Int,
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    content: @Composable (pageIndex: Int) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.weight(1f),
            state = pagerState
        ) { page ->
            content(page)
        }

        Spacer(modifier = Modifier.height(CustomTheme.dimensions.dimensions16))

        PagerIndicator(
            currentPage = pagerState.currentPage,
            pageCount = pageCount
        )
    }
}

@Composable
private fun PagerIndicator(
    currentPage: Int,
    pageCount: Int
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(CustomTheme.dimensions.dimensions8),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { pageIndex ->
            val isSelected = pageIndex == currentPage
            val shape = if (isSelected) {
                CustomTheme.shapes.pageIndicator
            } else {
                CustomTheme.shapes.dot
            }
            val width by animateDpAsState(
                targetValue = if (isSelected) {
                    CustomTheme.dimensions.dimensions16
                } else {
                    CustomTheme.dimensions.dimensions8
                },
                label = "widthAnimation",
            )
            val color = if (isSelected) {
                CustomTheme.colors.primaryButton
            } else {
                CustomTheme.colors.primaryButton.copy(alpha = 0.3f)
            }

            Box(
                modifier = Modifier
                    .width(width)
                    .size(CustomTheme.dimensions.dimensions8)
                    .clip(shape)
                    .background(color)
            )
        }
    }
}
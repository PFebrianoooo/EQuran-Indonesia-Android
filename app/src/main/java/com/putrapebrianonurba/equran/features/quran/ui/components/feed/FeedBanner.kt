package com.putrapebrianonurba.equran.features.quran.ui.components.feed

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.putrapebrianonurba.equran.domain.model.quran.BannerCarousel
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeedBanner(
    banners: List<BannerCarousel>
) {
    val pageCount = Int.MAX_VALUE
    val startPage = pageCount/2

    val pagerState = rememberPagerState(
        initialPage = startPage,
        pageCount = { pageCount },
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(4000)
            pagerState.animateScrollToPage(
                page = pagerState.currentPage + 1,
                animationSpec = tween(durationMillis = 300)
            )
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3f)
    ) { image ->
        val page = image % banners.size
        BannerItem(banners[page])
    }
}

@Composable
private fun BannerItem(
    banner: BannerCarousel
) {
    Image(
        painter = painterResource(banner.imageUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}



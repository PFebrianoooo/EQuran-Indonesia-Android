package com.putrapebrianonurba.equran.features.dua.ui.components.duastest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.R
import com.putrapebrianonurba.equran.core.common.orEmpty
import com.putrapebrianonurba.equran.core.constants.AppConstants
import com.putrapebrianonurba.equran.domain.model.dua.Dua
import com.putrapebrianonurba.equran.features.dua.ui.components.shared.DuaNavigateCard
import com.putrapebrianonurba.equran.features.dua.ui.components.shared.DuasTestButton

@Composable
fun DuasTestContent(
    dua: Dua?,
    modifier: Modifier = Modifier,
    onClickRevealAnswer: () -> Unit,
    onClickRefresh: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TEST INFORMATION
        DuaNavigateCard(
            icon = R.drawable.ic_dua_duas_test,
            title = AppConstants.DUAS_TEST_INFORMATION_TITLE + dua?.dua.orEmpty(),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DuasTestButton(
                title = AppConstants.DUAS_TEST_ANSWER_TITLE,
                modifier = Modifier.weight(1f)
            ) { onClickRevealAnswer() }

            DuasTestButton(
                title = AppConstants.DUAS_TEST_REFRESH_TITLE,
                modifier = Modifier.weight(1f)
            ) { onClickRefresh() }
        }
    }
}
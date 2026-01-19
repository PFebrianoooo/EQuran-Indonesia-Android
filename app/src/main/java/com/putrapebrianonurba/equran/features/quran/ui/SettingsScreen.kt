package com.putrapebrianonurba.equran.features.quran.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.common.redirectOpenUrl
import com.putrapebrianonurba.equran.core.components.IconButton
import com.putrapebrianonurba.equran.core.components.NavigationTopBar
import com.putrapebrianonurba.equran.core.constants.AppConstants
import com.putrapebrianonurba.equran.domain.model.settings.options.QoriOptions
import com.putrapebrianonurba.equran.features.quran.presentation.SettingsViewModel
import com.putrapebrianonurba.equran.features.quran.ui.components.settings.ExpandableSettingsItem
import com.putrapebrianonurba.equran.features.quran.ui.components.settings.SettingsItem
import com.putrapebrianonurba.equran.features.quran.ui.components.settings.TextSettingItem

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onNavigateBack: () -> Unit
) {
    // CONTEXT URL
    val context = LocalContext.current

    // UI STATE
    val uiState by viewModel.uiState.collectAsState()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // CONTENT
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 40.dp,
                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            // APPLICATION SETTINGS
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(vertical = 15.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    // TITLE
                    Text(
                        text = AppConstants.SETTINGS_APPLICATION_TITLE,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    // THEME SETTINGS
                    SettingsItem(
                        icon = Icons.Outlined.LightMode,
                        name = AppConstants.SETTINGS_APPLICATION_THEME_TITLE,
                        description = AppConstants.SETTINGS_APPLICATION_THEME_SUMMARY,
                        trailing = {
                            Switch(
                                checked = uiState.darkTheme,
                                onCheckedChange = { viewModel.onThemeToggle(it) },
                                modifier = Modifier.scale(0.8f)
                            )
                        }
                    )
                }
            }

            // QORI OPTIONS
            item {
                ExpandableSettingsItem(AppConstants.SETTINGS_QURAN_FEATURE_QORI_OPTIONS_TITLE) {
                    QoriOptions.entries.forEach { qori ->
                        TextSettingItem(
                            label = qori.label,
                            selected = uiState.murrotalQori == qori,
                            onClick = { viewModel.onQoriSelected(qori) },
                        )
                    }
                }
            }

            // DEVELOPER INFO
            item {
                ExpandableSettingsItem(AppConstants.SETTINGS_DEVELOPER_TITLE) {
                    // LINKEDIN ACCOUNT LINK DIRECT
                    SettingsItem(
                        icon = Icons.Outlined.Person,
                        name = AppConstants.SETTINGS_DEVELOPER_LINKEDIN_TITLE,
                        description = AppConstants.SETTINGS_DEVELOPER_LINKEDIN_SUMMARY,
                        onClick = { redirectOpenUrl(context, AppConstants.SETTINGS_DEVELOPER_LINKEDIN_LINK) }
                    )

                    // GITHUB ACCOUNT DIRECT LINK
                    SettingsItem(
                        icon = Icons.Outlined.Code,
                        name = AppConstants.SETTINGS_DEVELOPER_GITHUB_TITLE,
                        description = AppConstants.SETTINGS_DEVELOPER_GITHUB_SUMMARY,
                        onClick = { redirectOpenUrl(context, AppConstants.SETTINGS_DEVELOPER_GITHUB_LINK) }
                    )

                    // CONTRIBUTIONS TO REPOSITORY
                    SettingsItem(
                        icon = Icons.Outlined.StarOutline,
                        name = AppConstants.SETTINGS_DEVELOPER_CONTRIBUTION_REPO_TITLE,
                        description = AppConstants.SETTINGS_DEVELOPER_CONTRIBUTION_REPO_SUMMARY,
                        onClick = { redirectOpenUrl(context, AppConstants.SETTINGS_DEVELOPER__CONTRIBUTION_REPO_LINK) }
                    )
                }
            }
        }

        Text(
            text = AppConstants.APP_VERSION,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .padding(bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding())
                .align(Alignment.BottomCenter),
        )

        // TOP BAR
        NavigationTopBar(
            isScrolled = true,
            leading = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    IconButton(
                        icon = Icons.Default.ArrowBackIosNew,
                        size = 18.dp,
                        onClick = onNavigateBack
                    )

                    Text(
                        text = AppConstants.SETTINGS_TITLE,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        )
    }
}


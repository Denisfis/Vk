package com.example.vk.ui.applist

import com.example.vk.domain.applist.AppSummary

data class AppListState(
    val apps: List<AppSummary> = emptyList(),
    val isLoading: Boolean = true,
)

package com.example.vk.presentation.applist

/** Одноразовые события экрана: обрабатываются один раз и не повторяются после поворота. */
sealed interface AppListEvent {
    data object ShowToolbarSnackbar : AppListEvent
}

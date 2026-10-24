package com.example.vk.ui.applist

/** Одноразовые события экрана: обрабатываются один раз и не повторяются после поворота. */
sealed interface AppListEvent {
    data object ShowToolbarSnackbar : AppListEvent
}

package com.example.vk.data.applist

import com.example.vk.domain.applist.Category

/**
 * Сервер может прислать категорию как имя константы ("GAME") или как подпись ("Игры").
 * Неизвестная категория не должна ломать экран, поэтому по умолчанию — «Приложения».
 */
internal fun String.toCategory(): Category =
    Category.entries.firstOrNull { it.name.equals(this, ignoreCase = true) || it.title.equals(this, ignoreCase = true) }
        ?: Category.APP

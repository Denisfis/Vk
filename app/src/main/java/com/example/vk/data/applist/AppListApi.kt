package com.example.vk.data.applist

import com.example.vk.domain.applist.AppSummary
import com.example.vk.domain.applist.Category
import kotlinx.coroutines.delay

// Представим, что этот класс ходит в сеть.
class AppListApi {
    suspend fun getApps(): List<AppSummary> {
        delay(NETWORK_DELAY_MS)
        return sampleApps
    }

    private companion object {
        const val NETWORK_DELAY_MS = 1_500L
    }
}

// Захардкоженные данные, которые «приходят» из сети
internal val sampleApps = listOf(
    AppSummary(
        id = "fa2e31b8-1234-4cf7-9914-108a170a1b01",
        name = "Гильдия Героев: Экшен ММО РПГ",
        description = "Легендарный рейд героев в фэнтези РПГ. Станьте героем гильдии и сразите мастера подземелья!",
        category = Category.GAME,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
    ),
    AppSummary(
        id = "82ea6f63-2b2a-43e1-b54c-ec62e6e27229",
        name = "QuickNote",
        description = "Быстрые заметки и списки дел с синхронизацией между устройствами",
        category = Category.PRODUCTIVITY,
        iconUrl = "https://fastly.picsum.photos/id/237/200/200.jpg?hmac=zHUGikXUDyLCCmvyww1izLK3R3k8oRYBRiTizZEdyfI",
    ),
    AppSummary(
        id = "c6f64035-c432-4aad-a550-a1dac2d3b047",
        name = "Calmalist",
        description = "Медитации и дыхательные практики для спокойствия и хорошего сна",
        category = Category.HEALTH,
        iconUrl = "https://fastly.picsum.photos/id/238/200/200.jpg?hmac=O4Jc6lqHVfaKVzLf8bWssNTbWzQoaRUC0TDXod9xDdM",
    ),
    AppSummary(
        id = "d22b7cda-2d36-4ebd-bfa3-be58770fa455",
        name = "FitRiver",
        description = "Тренировки дома и в зале, трекер активности и план питания",
        category = Category.SPORTS,
        iconUrl = "https://fastly.picsum.photos/id/239/200/200.jpg?hmac=8JqlXUpZ9Xy0H6tMK8sCPQAYU9vUn9Qa8Kg-U9h3sCY",
    ),
    AppSummary(
        id = "f830e414-42a9-4fe6-af16-555a85f6f6c2",
        name = "Pixtrix",
        description = "Фоторедактор с фильтрами, ретушью и коллажами",
        category = Category.PHOTOGRAPHY,
        iconUrl = "https://fastly.picsum.photos/id/241/200/200.jpg?hmac=F-mDYyK1xUiXjlLd5PvE8EQpTwGfFndV7mMaANDtl28",
    ),
    AppSummary(
        id = "ba31ce5d-b214-46e9-bf7c-35e99e70af14",
        name = "TinyChef",
        description = "Тысячи пошаговых рецептов и список покупок в одном приложении",
        category = Category.FOOD,
        iconUrl = "https://fastly.picsum.photos/id/242/200/200.jpg?hmac=Z3aa8zbEQkEMFgnVh0Pn96vmCZHhJ17qzCrePYksrcY",
    ),
    AppSummary(
        id = "1ec98719-1d86-4cdc-b99d-11c6c23d981e",
        name = "FlowCard",
        description = "Учёт расходов, бюджеты и аналитика ваших финансов",
        category = Category.FINANCE,
        iconUrl = "https://fastly.picsum.photos/id/244/200/200.jpg?hmac=Q1gdvE6ZPZUX3nXkxvmzuc12eKVZ9XVEmSH3nCJ2OOo",
    ),
    AppSummary(
        id = "152b90b4-4632-4acd-b8fd-7ae71bee95e7",
        name = "Shoply",
        description = "Покупки с быстрой доставкой, скидками и кешбэком",
        category = Category.SHOPPING,
        iconUrl = "https://fastly.picsum.photos/id/247/200/200.jpg?hmac=oKt3N5MCdI8hCrzIbokjpVNzUuywbK64CJn1bfRAxbA",
    ),
    AppSummary(
        id = "e571be45-3b91-4193-8fcd-ae7237ca3e97",
        name = "Scanwise",
        description = "Сканер документов и QR-кодов с распознаванием текста",
        category = Category.UTILITIES,
        iconUrl = "https://fastly.picsum.photos/id/249/200/200.jpg?hmac=75zqoHvrxGGVnJnS8h0gUzZ3zniIk6PggG38GjmyOto",
    ),
    AppSummary(
        id = "e9b2387e-79c2-4bdb-b6fc-5cb34421bc99",
        name = "ZenRadio",
        description = "Тысячи радиостанций и подкастов со всего мира",
        category = Category.MUSIC,
        iconUrl = "https://fastly.picsum.photos/id/251/200/200.jpg?hmac=_yKttpPQLBisFkKPMRolKUyfZ89QQpENncPdrg8a1J0",
    ),
)

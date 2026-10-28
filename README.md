# VK — Android App List

A Jetpack Compose Android application that shows a scrollable list of apps. Each item displays the app icon, name, short description, and category. The project is written in Kotlin with Material 3, follows an MVVM structure, and uses Kotlin coroutines and Flow for asynchronous work and state.

## Features

- **Top app bar** with the app's launcher icon (built from the adaptive icon layers) and the screen title. Tapping the bar shows a snackbar.
- **Loading state**: a centered circular progress indicator is shown until the list is loaded.
- **Lazy app list** built with `LazyColumn`. Items are keyed by app `id`, so the list keeps its scroll position and updates efficiently. A divider separates items and is indented to align with the text.
- **App item**: a 56 dp rounded icon, the app name (one line, ellipsized), a description (up to two lines, ellipsized), and a category label.
- **Asynchronous icons** loaded with Coil 3. While an image loads, or if it fails, a placeholder filled with the theme's `surfaceVariant` color is shown.
- **One-off events**: a snackbar on toolbar tap is delivered through a `Channel`, so it is shown once and is not repeated after a screen rotation.
- **Survives configuration changes**: the `ViewModel` keeps the state, so the data is not reloaded on rotation.

## Tech stack

| Area | Technology |
|---|---|
| Language | Kotlin 2.2, Java 11 bytecode target |
| Build | Android Gradle Plugin 9.4, Gradle wrapper |
| SDK | `minSdk` 24, `compileSdk` / `targetSdk` 37 |
| UI | Jetpack Compose (BOM 2026.02.01), Material 3, `enableEdgeToEdge` |
| State | `ViewModel`, `StateFlow`, `Channel`, `collectAsStateWithLifecycle` |
| Concurrency | Kotlin coroutines (`viewModelScope`, `delay`) |
| Images | Coil 3 (`coil-compose`, `coil-network-okhttp`) |
| Dependencies | Version catalog in `gradle/libs.versions.toml` |
| Testing | JUnit 4, AndroidX Test, Espresso, Compose UI test |

## Architecture

The code is organized by feature (`applist`) across three layers.

```
app/src/main/java/com/example/vk
├── MainActivity.kt                  # Entry point: enableEdgeToEdge(), sets VKTheme and AppListScreen
├── data/applist/
│   └── AppListApi.kt                # Data source. Currently returns sampleApps after a 1.5 s delay
├── domain/applist/
│   ├── AppSummary.kt                # Domain model: id, name, description, category, iconUrl
│   └── Category.kt                  # Enum of categories, each with a display title in Russian
└── ui/
    ├── applist/
    │   ├── AppListViewModel.kt      # Loads apps, owns the state, handles toolbar clicks
    │   ├── AppListState.kt          # Immutable UI state: apps, isLoading
    │   ├── AppListEvent.kt          # Sealed interface for one-off events
    │   └── AppListScreen.kt         # Composables: screen, content, toolbar, list, item, icon, label
    └── theme/
        ├── Color.kt                 # Color palette
        ├── Type.kt                  # Typography
        └── Theme.kt                 # VKTheme (Material 3 color scheme)
```

### Data flow

1. `MainActivity` sets `AppListScreen()` inside `VKTheme`.
2. `AppListScreen` obtains `AppListViewModel` via `viewModel()`.
3. The ViewModel's `init` block calls `loadApps()`. It launches a coroutine in `viewModelScope`, calls `AppListApi.getApps()`, and updates `_state` with the result and `isLoading = false`.
4. The screen collects `state` with `collectAsStateWithLifecycle()`, so it stops collecting when the app is in the background.
5. When the user taps the toolbar, the screen calls `onToolbarClick()`. The ViewModel sends `AppListEvent.ShowToolbarSnackbar` to the `Channel`. The screen collects events in a `LaunchedEffect` and shows the snackbar.

### Design decisions

- **Single source of UI state.** `AppListState` is an immutable data class exposed as a read-only `StateFlow`. Composables are driven by state and only send actions to the ViewModel.
- **One-off events are not state.** A `StateFlow` would re-deliver a snackbar after rotation. A `Channel` with `receiveAsFlow()` delivers each event to a single collector, so it is consumed once.
- **Replaceable data source.** `AppListApi` is the only class that knows where data comes from. Replacing the stub with a real HTTP client requires no changes to the ViewModel or UI.
- **Previews without a ViewModel.** `AppListContent` is a stateless composable, and `@Preview` uses it with `sampleApps`, so the screen can be previewed in Android Studio.

## Getting started

**Requirements**

- Android Studio with support for Android Gradle Plugin 9.4
- JDK 17 or newer
- Android device or emulator with API 24 (Android 7.0) or newer
- Internet access, because icons are loaded from remote URLs

**Build**

```bash
git clone https://github.com/Denisfis/Vk.git
cd Vk
./gradlew assembleDebug          # Windows: gradlew.bat assembleDebug
```

The debug APK is written to `app/build/outputs/apk/debug/`.

**Run**

Open the project in Android Studio, let Gradle sync, select the `app` configuration, and run it on an emulator or device.

## Running tests

```bash
./gradlew test                    # local JVM unit tests (app/src/test)
./gradlew connectedAndroidTest    # instrumented tests (needs a running emulator or device)
```

At the moment the test folders contain the template examples generated by Android Studio. Real tests for the ViewModel and the data layer are planned.

## Known limitations

- **No real backend.** `AppListApi.getApps()` returns the hardcoded `sampleApps` list after a 1.5 s delay that imitates a network call.
- **No error handling.** If `getApps()` throws, the loading indicator stays visible and no message is shown.
- **Remote images.** Icons come from third-party URLs. They may load slowly or not at all without internet access, in which case the placeholder color is shown.
- **No tests yet** for business logic. The included tests are the default examples.
- **Single screen.** There is no navigation and no details view.
- **Category titles are in Russian** and are not localized.

## Roadmap

- Replace `AppListApi` with a Retrofit or Ktor client that loads the list from a REST endpoint, with JSON parsing and timeouts
- Add a repository layer between the ViewModel and the API, and map errors to a sealed UI state (`Loading`, `Success`, `Error`)
- Add a details screen with Navigation Compose
- Write unit tests for `AppListViewModel` using `kotlinx-coroutines-test` and a fake `AppListApi`
- Cache the list locally with Room, so it is available offline
- Move user-facing strings to resources for localization (English and Russian)

## Author

**Denis Gorbachev**: Android developer and student in Information Systems and Technologies at the Belarusian National Technical University (FITR).

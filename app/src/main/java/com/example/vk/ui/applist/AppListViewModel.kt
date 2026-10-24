package com.example.vk.ui.applist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vk.data.applist.AppListApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppListViewModel(
    private val api: AppListApi = AppListApi(),
) : ViewModel() {

    private val _state = MutableStateFlow(AppListState())
    val state: StateFlow<AppListState> = _state.asStateFlow()

    // Channel отдаёт каждое событие ровно одному подписчику, поэтому
    // после поворота экрана snackbar не покажется повторно.
    private val _events = Channel<AppListEvent>(Channel.BUFFERED)
    val events: Flow<AppListEvent> = _events.receiveAsFlow()

    init {
        // ViewModel переживает поворот экрана, поэтому загрузка выполняется один раз
        loadApps()
    }

    fun onToolbarClick() {
        viewModelScope.launch { _events.send(AppListEvent.ShowToolbarSnackbar) }
    }

    private fun loadApps() {
        viewModelScope.launch {
            Log.d(TAG, "Загрузка списка приложений")
            val apps = api.getApps()
            _state.update { it.copy(apps = apps, isLoading = false) }
        }
    }

    private companion object {
        const val TAG = "AppListViewModel"
    }
}

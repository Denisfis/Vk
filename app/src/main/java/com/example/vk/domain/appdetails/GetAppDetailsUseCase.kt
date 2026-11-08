package com.example.vk.domain.appdetails

import javax.inject.Inject

/** Пока нигде не используется: понадобится для экрана с подробностями о приложении. */
class GetAppDetailsUseCase @Inject constructor(
    private val repository: AppDetailsRepository,
) {
    suspend operator fun invoke(id: String): AppDetails = repository.getAppDetails(id)
}

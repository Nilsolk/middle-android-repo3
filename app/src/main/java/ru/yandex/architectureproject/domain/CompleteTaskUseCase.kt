package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository
import kotlin.time.Duration.Companion.milliseconds

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(10000L.milliseconds)
        repository.deleteTask(taskId)
    }
}

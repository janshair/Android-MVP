package com.tapdevs.base.injection.qualifiers

import javax.inject.Qualifier
import kotlin.annotation.MustBeDocumented
import kotlin.annotation.Retention

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class NamedScheduler(val value: SchedulerType = SchedulerType.IO) {

    enum class SchedulerType {
        IO, UI
    }
}
package com.geekbrains.tests.presenter

import io.reactivex.Scheduler

internal interface SchedulerProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
}

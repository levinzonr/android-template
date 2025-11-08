package com.levinzonr.otterfinder.core.error

val ErrorModel.displayableMessage: String
    get() {
        return when (this) {
            is ErrorModel.Connection -> "_Troubles with connection"
            is ErrorModel.ApiError -> exception.displayableMessage
            else -> "_Unknown error"
        }
    }

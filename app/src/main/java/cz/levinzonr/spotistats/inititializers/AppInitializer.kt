package cz.levinzonr.spotistats.inititializers

import android.app.Application
import cz.levinzonr.spotistats.BuildConfig
import timber.log.Timber

interface AppInitializer {
    fun init(app: Application)
}

class AppInitializerImpl : AppInitializer {
    override fun init(app: Application) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
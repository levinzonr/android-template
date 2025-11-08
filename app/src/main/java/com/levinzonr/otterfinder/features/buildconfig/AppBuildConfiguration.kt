package com.levinzonr.otterfinder.features.buildconfig

import com.levinzonr.otterfinder.BuildConfig
import com.levinzonr.otterfinder.core.config.AppFlavour
import com.levinzonr.otterfinder.core.config.AppVersion
import com.levinzonr.otterfinder.core.config.BuildConfiguration
import com.levinzonr.otterfinder.core.config.NetworkConfig
import javax.inject.Inject

class AppBuildConfiguration @Inject constructor() : BuildConfiguration {
    override val flavour: AppFlavour
        get() {
            return when (BuildConfig.FLAVOR) {
                "development" -> AppFlavour.Development
                "staging" -> AppFlavour.Staging
                "production" -> AppFlavour.Production
                else -> throw IllegalStateException(
                    "Flavour ${BuildConfig.FLAVOR} is not supported",
                )
            }
        }
    override val version: AppVersion = AppVersion(
        versionName = BuildConfig.VERSION_NAME,
        buildNumber = BuildConfig.VERSION_CODE,
    )
    override val networkConfig: NetworkConfig = NetworkConfig(BuildConfig.API_URL)
}

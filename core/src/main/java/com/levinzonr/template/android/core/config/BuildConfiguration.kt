package com.levinzonr.template.android.core.config

interface BuildConfiguration {
    val flavour: AppFlavour
    val version: AppVersion
    val networkConfig: NetworkConfig
}

package com.levinzonr.otterfinder.core.config

interface BuildConfiguration {
    val flavour: AppFlavour
    val version: AppVersion
    val networkConfig: NetworkConfig
}

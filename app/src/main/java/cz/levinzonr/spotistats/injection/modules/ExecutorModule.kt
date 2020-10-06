package cz.levinzonr.spotistats.injection.modules

import cz.levinzonr.spotistats.inititializers.AppInitializer
import cz.levinzonr.spotistats.inititializers.AppInitializerImpl
import org.koin.dsl.module

val initilizerModule = module {
    single<AppInitializer> { AppInitializerImpl() }
}
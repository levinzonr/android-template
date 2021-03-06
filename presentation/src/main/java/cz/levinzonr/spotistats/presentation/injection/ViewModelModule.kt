package cz.levinzonr.spotistats.presentation.injection

import cz.levinzonr.spotistats.presentation.screens.onboarding.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {

    viewModel { SplashViewModel() }
}
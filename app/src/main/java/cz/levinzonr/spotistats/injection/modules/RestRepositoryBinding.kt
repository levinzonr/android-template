package cz.levinzonr.spotistats.injection.modules

import cz.levinzonr.spotistats.network.RestPostRepository
import cz.levinzonr.spotistats.domain.repository.PostRepository
import org.koin.dsl.module


val repositoryModule = module {

    single<PostRepository> { RestPostRepository(get()) }


}
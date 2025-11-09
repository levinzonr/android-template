package com.levinzonr.otterfinder.features.otters.data

import com.levinzonr.otterfinder.R
import com.levinzonr.otterfinder.features.otters.domain.models.Otter
import com.levinzonr.otterfinder.features.otters.domain.repository.OttersRepository
import java.util.UUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MockOttersRepository : OttersRepository {

    private val list = listOf(
        Otter(
            name = "Ollie",
            imageResource = R.drawable.ill_otter_basic,
            id = UUID.randomUUID().toString(),
        ),
        Otter(
            name = "Benny",
            imageResource = R.drawable.ill_otter_beanie,
            id = UUID.randomUUID().toString(),

        ),
        Otter(
            name = "Baxter",
            imageResource = R.drawable.ill_otter_bowtie,
            id = UUID.randomUUID().toString(),

        ),
        Otter(
            name = "Cosmo",
            imageResource = R.drawable.ill_otter_cool,
            id = UUID.randomUUID().toString(),

        ),
        Otter(
            name = "Gizmo",
            imageResource = R.drawable.ill_otter_glasses,
            id = UUID.randomUUID().toString(),

        ),
        Otter(
            name = "Hugo",
            imageResource = R.drawable.ill_otter_hat,
            id = UUID.randomUUID().toString(),

        ),
        Otter(
            name = "Piper",
            imageResource = R.drawable.ill_otter_party,
            id = UUID.randomUUID().toString(),

        ),
    )

    override fun observe(): Flow<List<Otter>> {
        return flowOf(list)
    }
}

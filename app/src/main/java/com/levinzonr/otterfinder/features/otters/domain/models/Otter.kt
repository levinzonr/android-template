package com.levinzonr.otterfinder.features.otters.domain.models

import com.levinzonr.otterfinder.R

data class Otter(
    val id: String,
    val name: String,
    val imageResource: Int,
) {
    companion object {
        val Mock = Otter(
            name = "Leslie",
            imageResource = R.drawable.ill_otter_bowtie,
            id = "id",
        )
    }
}

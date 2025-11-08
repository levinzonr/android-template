package com.levinzonr.otterfinder.features.rescue.data

import com.levinzonr.otterfinder.features.otters.domain.models.Otter
import com.levinzonr.otterfinder.features.otters.domain.repository.OttersRepository
import com.levinzonr.otterfinder.features.rescue.domain.models.Location
import com.levinzonr.otterfinder.features.rescue.domain.models.Rescue
import com.levinzonr.otterfinder.features.rescue.domain.repository.RescuesRepository
import kotlinx.coroutines.flow.first
import java.util.UUID
import kotlin.math.*

class RescuesRepositoryImpl(
    private val ottersRepository: OttersRepository
) : RescuesRepository {

    private val rescueMessages = listOf(
        "Help! My favorite toy broke and I need someone to fix it 🧸",
        "Looking for a cozy spot to relax, any suggestions? 🏖️",
        "Can someone tell me what time it is? I lost track ⏰",
        "Need help finding the best place to take a nap 😴",
        "My snack stash ran out, anyone have extra? 🐟",
        "Looking for a friend to play hide and seek with 🎮",
        "Lost my way, can someone help me get back home? 🏠",
        "Need someone to help me count my pebbles collection 🪨",
        "Looking for the perfect spot to watch the sunset 🌅",
        "Can someone help me organize my shell collection? 🐚",
        "Need a buddy to go swimming with! 🏊",
        "Help! I can't decide what to have for lunch 🍽️",
        "Looking for someone to share stories with 📖",
        "Need help finding the warmest rock to sunbathe on ☀️",
        "Can someone help me practice my backstroke? 🏊‍♂️",
        "Looking for a friend to explore the river with 🌊",
        "Help! I'm too comfy to move, need assistance 🛋️",
        "Need someone to help me find the best fishing spot 🎣",
        "Can someone tell me if it's nap time yet? 😴",
        "Looking for a cozy friend to cuddle with 🫂"
    )

    override suspend fun get(center: Location, radiusKm: Int): List<Rescue> {
        // Get available otters
        val otters = ottersRepository.observe().first()
        if (otters.isEmpty()) {
            return emptyList()
        }

        val numberOfRescues = max(3 * radiusKm, 3)

        return (1..numberOfRescues).map {
            val randomLocation = generateRandomLocationInCircle(center, radiusKm)
            val randomOtter = otters.random()
            val randomMessage = rescueMessages.random()

            Rescue(
                id = UUID.randomUUID().toString(),
                postedBy = randomOtter,
                message = randomMessage,
                location = randomLocation
            )
        }
    }

    /**
     * Generates a random location within a circle centered at the given location
     * Uses polar coordinates to ensure uniform distribution within the circle
     */
    private fun generateRandomLocationInCircle(center: Location, radiusKm: Int): Location {
        // Generate random angle (0 to 2π)
        val angle = kotlin.random.Random.nextDouble() * 2 * PI

        // Generate random distance from center (0 to radius)
        // Using square root to ensure uniform distribution
        val distanceKm = sqrt(kotlin.random.Random.nextDouble()) * radiusKm

        // Convert distance to degrees
        // Approximately: 1 degree latitude ≈ 111 km
        // 1 degree longitude ≈ 111 km * cos(latitude)
        val latOffset = distanceKm / 111.0
        val lonOffset = distanceKm / (111.0 * cos(Math.toRadians(center.latitude)))

        // Calculate new location
        val newLat = center.latitude + latOffset * cos(angle)
        val newLon = center.longitude + lonOffset * sin(angle)

        return Location(
            latitude = newLat,
            longitude = newLon
        )
    }
}
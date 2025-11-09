package com.levinzonr.otterfinder.features.rescue.data

import com.levinzonr.otterfinder.core.location.Location
import com.levinzonr.otterfinder.features.otters.domain.repository.OttersRepository
import com.levinzonr.otterfinder.features.rescue.domain.models.Rescue
import com.levinzonr.otterfinder.features.rescue.domain.models.RescueType
import com.levinzonr.otterfinder.features.rescue.domain.repository.RescuesRepository
import java.util.UUID
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin
import kotlin.math.sqrt
import kotlinx.coroutines.flow.first

class RescuesRepositoryImpl(
    private val ottersRepository: OttersRepository,
) : RescuesRepository {

    private val messagesByType = mapOf(
        RescueType.ToyTrouble to listOf(
            "Help! My favorite toy broke and I need someone to fix it 🧸",
            "Need someone to help me count my pebbles collection 🪨",
            "Can someone help me organize my shell collection? 🐚",
            "Help! I can't decide what to have for lunch 🍽️",
        ),
        RescueType.CozySpot to listOf(
            "Looking for a cozy spot to relax, any suggestions? 🏖️",
            "Need help finding the best place to take a nap 😴",
            "Looking for the perfect spot to watch the sunset 🌅",
            "Need help finding the warmest rock to sunbathe on ☀️",
            "Can someone tell me if it's nap time yet? 😴",
            "Lost my way, can someone help me get back home? 🏠",
        ),
        RescueType.PlayDate to listOf(
            "Looking for a friend to play hide and seek with 🎮",
            "Need a buddy to go swimming with! 🏊",
            "Looking for someone to share stories with 📖",
            "Can someone help me practice my backstroke? 🏊‍♂️",
            "Looking for a friend to explore the river with 🌊",
            "Looking for a cozy friend to cuddle with 🫂",
            "My snack stash ran out, anyone have extra? 🐟",
            "Need someone to help me find the best fishing spot 🎣",
            "Can someone tell me what time it is? I lost track ⏰",
            "Help! I'm too comfy to move, need assistance 🛋️",
        ),
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

            // Randomly select a rescue type
            val randomType = RescueType.entries.random()
            // Get a random message for that type
            val randomMessage = messagesByType[randomType]?.random()
                ?: "Need help! 🆘"

            Rescue(
                id = UUID.randomUUID().toString(),
                postedBy = randomOtter,
                message = randomMessage,
                location = randomLocation,
                type = randomType,
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
            longitude = newLon,
        )
    }
}

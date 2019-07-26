package fr.denel.simon.masuperbelibrairie.api

data class LivrePutDto(
        val titre: String,
        val auteur: String,
        val disponible: Boolean,
        val version: Int // TODO type Version, positif ou nul
)
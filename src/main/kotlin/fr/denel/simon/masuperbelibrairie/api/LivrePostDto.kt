package fr.denel.simon.masuperbelibrairie.api

import java.util.*

data class LivrePostDto(
        val titre: String,
        val auteur: String,
        val disponible: Boolean
)
package fr.denel.simon.masuperbelibrairie.model

import java.util.*

data class LivreEntity(
        val uuid: UUID,
        val titre: String,
        val auteur: String, // TODO : auteurs, en tant que liste de AuteurBindings(auteurUuid, type = Auteur ou Préface en ENUM.)
        val disponible: Boolean,
        val version: Int = 0
)
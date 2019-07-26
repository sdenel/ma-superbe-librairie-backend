package fr.denel.simon.masuperbelibrairie.services

import fr.denel.simon.masuperbelibrairie.model.LivreEntity
import fr.denel.simon.masuperbelibrairie.api.LivrePostDto
import org.springframework.stereotype.Service
import java.util.*
import java.util.UUID.randomUUID

@Service
class LivreService {

    private val livres = mutableMapOf<UUID, LivreEntity>()

    init {
        add(LivreEntity(
                randomUUID(),
                "Principles: Life and Work",
                "Ray Dalio",
                true
        ))
        add(LivreEntity(
                randomUUID(),
                "How to win Friends & Influence People",
                "Dale Carnegie",
                true
        ))
        add(LivreEntity(
                randomUUID(),
                "The DevOps Handbook: How to Create World-Class Agility, Reliability, and Security in Technology Organizations",
                "Gene Kim (Author), Patrick Debois (Author), John Willis (Author), Jez Humble (Author), John Allspaw (Foreword)",
                false
        ))
        add(LivreEntity(
                randomUUID(),
                "The Phoenix Project: A Novel about IT, DevOps, and Helping Your Business Win",
                "Gene Kim (Author), Kevin Behr (Author), George Spafford (Author)",
                true
        ))
    }

    fun get(uuid: UUID) = livres[uuid]

    fun getAll() = livres.values.toList()

    fun createLivreFromPostDto(livrePostDto: LivrePostDto): LivreEntity {
        return LivreEntity(
                randomUUID(),
                livrePostDto.titre,
                livrePostDto.auteur,
                livrePostDto.disponible
        )
    }

    final fun add(livreEntity: LivreEntity) {
        livres[livreEntity.uuid] = livreEntity // TODO gestion correcte des erreurs
    }

    fun delete(uuid: UUID) {
        livres.remove(uuid)
    }
}

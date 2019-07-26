package fr.denel.simon.masuperbelibrairie.api

import fr.denel.simon.masuperbelibrairie.model.LivreEntity
import fr.denel.simon.masuperbelibrairie.services.LivreService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*


@RestController
@RequestMapping("/api/v1/livres/")
class LivreController(
        val livreService: LivreService
) {

    @GetMapping
    @ApiOperation("Récupérer l'ensemble des livres présents dans la librairie.")
    fun getAll() = livreService.getAll()

    @PostMapping
    @ApiOperation("Ajouter un livre dans la librairie.")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun create(@RequestBody livrePostDto: LivrePostDto): ResponseEntity<Any> {
        val livre = livreService.createLivreFromPostDto(livrePostDto)
        livreService.add(livre)
        val location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/${livre.uuid}")
                .build().toUri()
        return ResponseEntity.created(location).build()
    }

    @GetMapping("{uuid}")
    @ApiOperation("Récupérer un livre en particulier dans la librairie.")
    fun read(@PathVariable uuid: UUID): LivreEntity { // TODO : UUID et pas String
        return livreService.get(uuid)!!
    }

//    @PutMapping("{uuid}")
//    @ApiOperation("Modifier un livre de la librairie. L'incrémentation du compteur de version est à la charge du consommateur.")
//    @ResponseStatus(value = HttpStatus.OK)
//    fun update(@PathVariable uuid: UUID, @RequestBody livrePutDto: LivrePutDto) {
//        // TODO
//    }

    @DeleteMapping("{uuid}")
    @ApiOperation("Supprimer un livre de la librairie.")
    @ResponseStatus(value = HttpStatus.OK)
    fun update(@PathVariable uuid: UUID) {
        val livre = livreService.delete(uuid)
    }

}
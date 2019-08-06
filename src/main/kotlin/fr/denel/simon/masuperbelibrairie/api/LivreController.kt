package fr.denel.simon.masuperbelibrairie.api

import fr.denel.simon.masuperbelibrairie.model.LivreEntity
import fr.denel.simon.masuperbelibrairie.services.LivreService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*


@RestController
@RequestMapping("/api/v1/livres/")
//@Api(value = "/api/v1/livres/", description = "Some description", produces = "application/json")
class LivreController(
        val livreService: LivreService
) {

    @GetMapping(produces= ["application/json"])
    @ApiOperation("Récupérer l'ensemble des livres présents dans la librairie.")
    fun getAll() = livreService.getAll()

    @PostMapping(produces= ["application/json"])
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

    @GetMapping("{uuid}", produces= ["application/json"])
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

    @DeleteMapping("{uuid}", produces= ["application/json"])
    @ApiOperation("Supprimer un livre de la librairie.")
    @ResponseStatus(value = HttpStatus.OK)
    fun update(@PathVariable uuid: UUID) {
        val livre = livreService.delete(uuid)
    }

}
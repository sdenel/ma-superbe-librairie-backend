Une application en Java Sprint Boot **jouet** servant de bac à sable pour quelques uns de mes articles de blog (https://simon.denel.fr). L'application simule une librairie.

* Codée en Kotlin
* Utilisation de Springfox Swagger pour générer le contrat au format OpenAPI et une GUI

# Backlog
* API respectant quelques un des principes listés dans cet article de blog : https://simon.denel.fr/api-http-quelques-bonnes-pratiques.html
* Stocker les données en base, avec en dev, le choix entre postgres et H2 (pour faciliter le lancement sans Docker)
* Ajouter Flyway
* Ajouter des tests : des controlleurs, des repositories...
* Augmenter le modèle de données pour amener des problématiques plus réelles.

# Lancement en local
```bash
mvn spring-boot:run
# Puis http://localhost:8080/swagger-ui.html
```




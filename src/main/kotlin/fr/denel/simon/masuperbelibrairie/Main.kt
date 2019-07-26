package fr.denel.simon.masuperbelibrairie

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
class Main

@Configuration
@EnableSwagger2
@EnableScheduling
class SwaggerConfig(@Autowired private val env: Environment) {
    /**
     * Activation de Swagger
     */
    @Bean
    fun api(): Docket {
        val apis = RequestHandlerSelectors.withClassAnnotation(RestController::class.java)
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(apis)
                .paths(PathSelectors.any())
                .build()
                .host(env.getProperty("host"))
                .protocols(setOf(env.getProperty("protocol")))
    }
}

fun main(args: Array<String>) {
	runApplication<Main>(*args)
}


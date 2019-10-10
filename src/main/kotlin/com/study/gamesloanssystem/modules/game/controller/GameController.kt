package com.study.gamesloanssystem.modules.game.controller

import com.study.gamesloanssystem.modules.game.service.GameService
import com.study.gamesloanssystem.modules.game.viewmodels.CreateGameRequest
import com.study.gamesloanssystem.modules.game.viewmodels.GameResponse
import com.study.gamesloanssystem.modules.game.viewmodels.UpdateGameRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController("/game")
class GameController @Autowired constructor(

        private val gameService: GameService
) {

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    fun createGame(@RequestBody game: CreateGameRequest): Mono<GameResponse> {
        return gameService.createGame(game)
    }

    @GetMapping("/game/all")
    fun listAllGames(): Flux<GameResponse> {
        return gameService.listAllGames()
    }

    @GetMapping("/{id}")
    fun getGameById(@PathVariable id: String): Mono<GameResponse>{
        return gameService.getGameById(id)
    }

    @PutMapping
    fun updateGame(@RequestBody game: UpdateGameRequest): Mono<GameResponse>{
        return gameService.updateGame(game)
    }
}
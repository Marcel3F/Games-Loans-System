package com.study.gamesloanssystem.modules.game.service

import com.study.gamesloanssystem.modules.game.viewmodels.CreateGameRequest
import com.study.gamesloanssystem.modules.game.viewmodels.GameResponse
import com.study.gamesloanssystem.modules.game.viewmodels.UpdateGameRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface GameService {

    fun createGame(game: CreateGameRequest): Mono<GameResponse>
    fun listAllGames(): Flux<GameResponse>
    fun getGameById(id: String): Mono<GameResponse>
    fun updateGame(game: UpdateGameRequest): Mono<GameResponse>
}
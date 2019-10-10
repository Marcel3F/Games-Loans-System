package com.study.gamesloanssystem.modules.game.service.impl

import com.study.gamesloanssystem.modules.game.entity.Game
import com.study.gamesloanssystem.modules.game.repository.GameRepository
import com.study.gamesloanssystem.modules.game.service.GameService
import com.study.gamesloanssystem.modules.game.viewmodels.CreateGameRequest
import com.study.gamesloanssystem.modules.game.viewmodels.GameResponse
import com.study.gamesloanssystem.modules.game.viewmodels.UpdateGameRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class GameServiceImpl @Autowired constructor(

        private val gameRepository: GameRepository

): GameService  {

    override fun createGame(gameRequest: CreateGameRequest): Mono<GameResponse> {
        return  Mono.just(Game(UUID.randomUUID().toString(), gameRequest.name, gameRequest.imageUrl))
                .flatMap { game -> gameRepository.save(game).map { GameResponse(it.id, it.name, it.imageUrl) } }
    }

    override fun listAllGames(): Flux<GameResponse> {
        return gameRepository.findAll()
                .map { GameResponse(it.id, it.name, it.imageUrl) }
    }

    override fun getGameById(id: String): Mono<GameResponse> {
        return gameRepository.findById(id)
                .map { GameResponse(it.id, it.name, it.imageUrl) }
    }

    override fun updateGame(gameRequest: UpdateGameRequest): Mono<GameResponse> {
        return  Mono.just(Game(gameRequest.id, gameRequest.name, gameRequest.imageUrl) )
                .flatMap { game -> gameRepository.save(game).map { GameResponse(it.id, it.name, it.imageUrl) } }
    }
}
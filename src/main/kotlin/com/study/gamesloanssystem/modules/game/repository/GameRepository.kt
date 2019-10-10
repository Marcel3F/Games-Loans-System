package com.study.gamesloanssystem.modules.game.repository

import com.study.gamesloanssystem.modules.game.entity.Game
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository: ReactiveCrudRepository<Game, String>
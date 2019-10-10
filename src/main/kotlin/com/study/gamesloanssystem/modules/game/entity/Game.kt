package com.study.gamesloanssystem.modules.game.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "game")
data class Game (

        @Id
        val id: String,
        val name: String,
        val imageUrl: String
)
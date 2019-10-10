package com.study.gamesloanssystem.modules.friend.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "friend")
data class Friend (

        @Id
        val id: String,
        val name: String
)
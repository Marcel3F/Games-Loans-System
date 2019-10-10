package com.study.gamesloanssystem.modules.friend.repository

import com.study.gamesloanssystem.modules.friend.entity.Friend
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FriendRepository: ReactiveCrudRepository<Friend, String>
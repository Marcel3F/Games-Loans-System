package com.study.gamesloanssystem.modules.friend.service.impl

import com.study.gamesloanssystem.modules.friend.entity.Friend
import com.study.gamesloanssystem.modules.friend.viewmodels.CreateFriendRequest
import com.study.gamesloanssystem.modules.friend.viewmodels.FriendResponse
import com.study.gamesloanssystem.modules.friend.repository.FriendRepository
import com.study.gamesloanssystem.modules.friend.service.FriendService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class FriendServiceImpl @Autowired constructor(
        private val friendRepository: FriendRepository

): FriendService {

    override fun createFriend(friendRequest: CreateFriendRequest): Mono<FriendResponse> {
        return Mono.just(Friend(UUID.randomUUID().toString(), friendRequest.name))
                .flatMap { friend -> friendRepository.save(friend).map { FriendResponse(it.id.toString(), it.name) } }

    }

    override fun listAllFriends(): Flux<FriendResponse> {
        return friendRepository.findAll().map { FriendResponse(it.id.toString(), it.name) }

    }
}
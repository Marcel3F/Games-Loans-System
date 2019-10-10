package com.study.gamesloanssystem.modules.friend.service

import com.study.gamesloanssystem.modules.friend.viewmodels.CreateFriendRequest
import com.study.gamesloanssystem.modules.friend.viewmodels.FriendResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FriendService {

    fun createFriend(friend: CreateFriendRequest): Mono<FriendResponse>

    fun listAllFriends(): Flux<FriendResponse>

}
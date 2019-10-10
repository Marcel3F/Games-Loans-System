package com.study.gamesloanssystem.modules.friend.controller

import com.study.gamesloanssystem.modules.friend.viewmodels.CreateFriendRequest
import com.study.gamesloanssystem.modules.friend.viewmodels.FriendResponse
import com.study.gamesloanssystem.modules.friend.service.FriendService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController("/friend")
class FriendController @Autowired constructor(
        private val friendService: FriendService
){

    @PostMapping("/friend")
    @ResponseStatus(HttpStatus.CREATED)
    fun createFriend(@RequestBody friend: CreateFriendRequest): Mono<FriendResponse>{
        return friendService.createFriend(friend)
    }

    @GetMapping("/friend/all")
    fun listAllFriends(): Flux<FriendResponse>{
        return friendService.listAllFriends()
    }

}
package com.rodan.rockpaperscissors.manager

import com.rodan.rockpaperscissors.enum.PlayerMenu


class GameManager(): PlayerList(){

    fun getComputerMenu(){
        computer.random()
    }

}

open class PlayerList(){
    val player1 = mutableListOf(PlayerMenu.ROCK, PlayerMenu.PAPER, PlayerMenu.SCISSORS)
    val computer = mutableListOf(PlayerMenu.ROCK, PlayerMenu.PAPER, PlayerMenu.SCISSORS)


}
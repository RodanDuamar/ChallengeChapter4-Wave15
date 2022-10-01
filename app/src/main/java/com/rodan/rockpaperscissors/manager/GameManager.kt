package com.rodan.rockpaperscissors.manager

import com.rodan.rockpaperscissors.enum.Status

interface GameManager{
    fun rockLeft()
    fun paperLeft()
    fun scissorsLeft()
    fun startGame(gameStatus: Status)
}


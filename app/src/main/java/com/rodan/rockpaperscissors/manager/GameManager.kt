package com.rodan.rockpaperscissors.manager

import com.rodan.rockpaperscissors.enum.GameState
import com.rodan.rockpaperscissors.enum.PlayerMenu
import com.rodan.rockpaperscissors.enum.PlayerSide
import com.rodan.rockpaperscissors.model.Player
import kotlin.random.Random

interface GameManager {
    fun initGame()
    fun restartGame()
}

interface GameListener {
    fun onGameStateChanged(gameState: GameState)
    fun onGameFinished(p1: PlayerSide, p2: PlayerSide)
}

class ComputerEnemyGameManager(private val listener: GameListener): GameManager{
    private val playerOne: Player by lazy {
        Player(PlayerSide.PLAYER_ONE)
    }
    private val playerTwo: Player by lazy {
        Player(PlayerSide.PLAYER_TWO)
    }
    private val rock: PlayerMenu by lazy {
        PlayerMenu.ROCK
    }
    private val paper: PlayerMenu by lazy {
        PlayerMenu.PAPER
    }
    private val scissors: PlayerMenu by lazy {
        PlayerMenu.SCISSORS
    }

    private lateinit var gameState : GameState

    override fun initGame(){
        setGameState(GameState.STARTED)

        startGame()
    }

    private fun setGameState(newGameState: GameState){
        gameState = newGameState
        listener.onGameStateChanged(gameState)
    }

    fun startGame(){
        playerTwo.apply {
            getPlayerTwoMenu()
        }
    }

    private fun getPlayerTwoMenu(): PlayerMenu{
        val randomMenu = Random.nextInt(0, until = PlayerMenu.values().size)
        return getPlayerMenuByOrdinal(randomMenu)
    }

    private fun getPlayerMenuByOrdinal(index: Int): PlayerMenu {
        return PlayerMenu.values()[index]
    }



    fun resetGame() {
        initGame()
    }

    override fun restartGame() {
        if (gameState != GameState.FINISHED){
            startGame()
        }else {
            resetGame()
        }
    }
}
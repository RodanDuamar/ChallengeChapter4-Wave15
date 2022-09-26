package com.rodan.rockpaperscissors.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodan.rockpaperscissors.R
import com.rodan.rockpaperscissors.databinding.ActivityGameBinding
import com.rodan.rockpaperscissors.enum.GameState
import com.rodan.rockpaperscissors.enum.PlayerMenu
import com.rodan.rockpaperscissors.enum.PlayerSide
import com.rodan.rockpaperscissors.manager.ComputerEnemyGameManager
import com.rodan.rockpaperscissors.manager.GameListener
import com.rodan.rockpaperscissors.manager.GameManager

class GameActivity : AppCompatActivity(), GameListener {
    private val binding: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }

    private val gameManager: GameManager by lazy {
        ComputerEnemyGameManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        gameManager.initGame()
        setOnClickListener()
    }

    private fun setOnClickListener(){
        binding.apply {
            ivRockLeftPlayer.setOnClickListener {
                chooseMenu()
            }
            ivPaperLeftPlayer.setOnClickListener {
                chooseMenu()
            }
            ivScissorLeftPlayer.setOnClickListener {
                chooseMenu()
            }
            ivRestart.setOnClickListener {
                gameManager.restartGame()
            }
        }
    }

    fun chooseMenu() {

    }

    override fun onGameStateChanged(gameState: GameState) {

    }

    override fun onGameFinished(p1: PlayerSide, p2: PlayerSide) {
    }

//    override fun onGameFinished(p1: PlayerSide, p2: PlayerSide) {
//        val playerCalc = (p1 + 1) % 3
//        if (playerCalc == p2){
//            binding.tvStatusGame.text = getString(R.string.pemain_2_menang)
//        }else if (p1 == p2){
//            binding.tvStatusGame.text = getString(R.string.draw)
//        }else {
//            binding.tvStatusGame.text = getString(R.string.pemain_1_menang)
//        }
//    }
}
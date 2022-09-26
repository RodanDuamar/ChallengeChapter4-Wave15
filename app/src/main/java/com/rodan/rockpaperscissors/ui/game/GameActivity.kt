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
        val rock: Int by lazy {
            PlayerMenu.ROCK.ordinal
        }
        val paper: Int by lazy {
            PlayerMenu.PAPER.ordinal
        }
        val scissors: Int by lazy {
            PlayerMenu.SCISSORS.ordinal
        }

        binding.apply {
            ivRockLeftPlayer.setOnClickListener {
                rock
            }
            ivPaperLeftPlayer.setOnClickListener {
                paper
            }
            ivScissorLeftPlayer.setOnClickListener {
                scissors
            }
            ivRestart.setOnClickListener {
                gameManager.restartGame()
            }
        }
    }

    override fun gameWinner(p1: Int, p2: Int) {
        if ((p1 + 1) % 3 == p2){
            binding.tvStatusGame.text = getString(R.string.pemain_2_menang)
        }else if (p1 == p2){
            binding.tvStatusGame.text = getString(R.string.draw)
        }else {
            binding.tvStatusGame.text = getString(R.string.pemain_1_menang)
        }
    }
}
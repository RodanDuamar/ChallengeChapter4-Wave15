package com.rodan.rockpaperscissors.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodan.rockpaperscissors.R
import com.rodan.rockpaperscissors.databinding.ActivityGameBinding
import com.rodan.rockpaperscissors.enum.PlayerMenu
import com.rodan.rockpaperscissors.manager.GameManager
import com.rodan.rockpaperscissors.manager.PlayerList

class GameActivity : AppCompatActivity(){
    private val binding: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }

    val manageGame = GameManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        binding.ivRockLeftPlayer.setOnClickListener{
            manageGame.player1[0]
        }
        binding.ivPaperLeftPlayer.setOnClickListener{
            manageGame.player1[1]
        }
        binding.ivScissorLeftPlayer.setOnClickListener{
            manageGame.player1[2]
        }

        playGame(manageGame.player1.toString(), manageGame.computer.toString())

        binding.ivRockRightPlayer.setOnClickListener{
            manageGame.getComputerMenu()
        }
        binding.ivPaperRightPlayer.setOnClickListener{
            manageGame.getComputerMenu()
        }
        binding.ivScissorRightPlayer.setOnClickListener{
            manageGame.getComputerMenu()
        }
    }

    fun playGame(pemain1: String, pemain2: String){
        when{pemain1 == pemain2 -> {
            binding.tvStatusGame.text = getString(R.string.draw)
        }
            pemain1 == manageGame.player1[2] && pemain2 == manageGame.computer[0] -> {
                binding.tvStatusGame.text = getString(R.string.pemain_2_menang)
            }
            pemain1 == manageGame.player1[2] && pemain2 == manageGame.computer[1] -> {
                binding.tvStatusGame.text = getString(R.string.pemain_1_menang)
            }
            pemain1 == manageGame.player1[1] && pemain2 == manageGame.computer[0] -> {
                binding.tvStatusGame.text = getString(R.string.pemain_1_menang)
            }
            pemain1 == manageGame.player1[1] && pemain2 == manageGame.computer[2] -> {
                binding.tvStatusGame.text = getString(R.string.pemain_2_menang)
            }
            pemain1 == manageGame.player1[0] && pemain2 == manageGame.computer[2] -> {
                binding.tvStatusGame.text = getString(R.string.pemain_1_menang)
            }
            pemain1 == manageGame.player1[0] && pemain2 == manageGame.computer[1] -> {
                binding.tvStatusGame.text = getString(R.string.pemain_2_menang)
            }
        }
    }
}
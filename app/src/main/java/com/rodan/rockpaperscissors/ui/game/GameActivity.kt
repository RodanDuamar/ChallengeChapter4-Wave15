package com.rodan.rockpaperscissors.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rodan.rockpaperscissors.R
import com.rodan.rockpaperscissors.databinding.ActivityGameBinding
import com.rodan.rockpaperscissors.enum.PlayerMenu
import com.rodan.rockpaperscissors.enum.Status
import com.rodan.rockpaperscissors.manager.GameManager
import kotlin.random.Random

class GameActivity : AppCompatActivity(), GameManager{

    lateinit var player1Choice: PlayerMenu
    lateinit var start: Status

    private val binding: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initGame()
    }

    override fun startGame(gameStatus: Status) {
        start = gameStatus
    }

    fun initGame(){
        startGame(Status.IDLE)
        startGame(Status.STARTED)
        binding.flStartGame.setOnClickListener {
            Log.d(TAG, "Start button clicked")
            setOnClickListener()
            binding.tvStatusGame.text = getString(R.string.versus)
        }
    }

    private fun setOnClickListener() {
        binding.ivRockLeftPlayer.setOnClickListener{
            Log.d(TAG, "Rock button clicked")
            rockLeft()
        }
        binding.ivPaperLeftPlayer.setOnClickListener{
            Log.d(TAG,"Paper button clicked")
            paperLeft()
        }
        binding.ivScissorLeftPlayer.setOnClickListener{
            Log.d(TAG, "Scissor button clicked")
            scissorsLeft()
        }
        binding.ivRestart.setOnClickListener{
            Log.d(TAG, "Restart button clicked")
            binding.tvStatusGame.text = getString(R.string.versus)
        }
    }

    override fun rockLeft(){
        val computerChoice = Random.nextInt(3)
        when (computerChoice){
            0 -> binding.tvWhatTheyChoose.text = getString(R.string.rock)
            1 -> binding.tvWhatTheyChoose.text = getString(R.string.paper)
            2 -> binding.tvWhatTheyChoose.text = getString(R.string.scissors)
        }
        player1Choice = PlayerMenu.ROCK
        when (computerChoice){
            0 -> binding.tvStatusGame.text = getString(R.string.draw)
            1 -> binding.tvStatusGame.text = getString(R.string.pemain_1_menang)
            2 -> binding.tvStatusGame.text = getString(R.string.pemain_2_menang)
        }
    }
    override fun paperLeft(){
        val computerChoice = Random.nextInt(3)
        when (computerChoice){
            0 -> binding.tvWhatTheyChoose.text = getString(R.string.rock)
            1 -> binding.tvWhatTheyChoose.text = getString(R.string.paper)
            2 -> binding.tvWhatTheyChoose.text = getString(R.string.scissors)
        }
        player1Choice = PlayerMenu.PAPER
        when (computerChoice){
            0 -> binding.tvStatusGame.text = getString(R.string.pemain_1_menang)
            1 -> binding.tvStatusGame.text = getString(R.string.draw)
            2 -> binding.tvStatusGame.text = getString(R.string.pemain_2_menang)
        }
    }
    override fun scissorsLeft(){
        val computerChoice = Random.nextInt(3)
        when (computerChoice){
            0 -> binding.tvWhatTheyChoose.text = getString(R.string.rock)
            1 -> binding.tvWhatTheyChoose.text = getString(R.string.paper)
            2 -> binding.tvWhatTheyChoose.text = getString(R.string.scissors)
        }
        player1Choice = PlayerMenu.SCISSORS
        when (computerChoice) {
            0 -> binding.tvStatusGame.text = getString(R.string.pemain_2_menang)
            1 -> binding.tvStatusGame.text = getString(R.string.pemain_1_menang)
            2 -> binding.tvStatusGame.text = getString(R.string.draw)
        }
    }

    companion object {
        private val TAG = GameActivity::class.java.simpleName
    }
}
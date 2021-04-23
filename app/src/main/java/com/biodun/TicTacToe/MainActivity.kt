package com.biodun.TicTacToe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

     fun butClick (view:View) {
        val butSelected = view as Button
        var cellId = 0
        when(butSelected.id) {
            R.id.but1 -> cellId = 1
            R.id.but2 -> cellId = 2
            R.id.but3 -> cellId = 3
            R.id.but4 -> cellId = 4
            R.id.but5 -> cellId = 5
            R.id.but6 -> cellId = 6
            R.id.but7 -> cellId = 7
            R.id.but8 -> cellId = 8
            R.id.but9 -> cellId = 9
        }
        //Toast.makeText(this, "Id:" + cellId, Toast.LENGTH_SHORT).show()
        playGame(cellId, butSelected)

    }
    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()
    var activePlayer = 1


    fun playGame (cellId:Int, butSelected:Button){
        if(activePlayer == 1){
            butSelected.text = "X"
            butSelected.setBackgroundColor(Color.RED)
            playerOne.add(cellId)
            activePlayer = 2
            autoPlay()
        }else{
            butSelected.text = "O"
            butSelected.setBackgroundColor(Color.BLUE)
            playerTwo.add(cellId)
            activePlayer = 1
        }
        butSelected.isEnabled = false  //this line disables a button after it has been clicked
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        //row 1
        if(playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)){
            winner = 1
        }
        if(playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)) {
            winner = 2
        }
        //row 2
        if(playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)){
            winner = 1
        }
        if(playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)) {
            winner = 2
        }
        //row 3
        if(playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)){
            winner = 1
        }
        if(playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)) {
            winner = 2
        }



        //column 1
        if(playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)){
            winner = 1
        }
        if(playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)) {
            winner = 2
        }
        //column 2
        if(playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)){
            winner = 1
        }
        if(playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)) {
            winner = 2
        }
        //column 3
        if(playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)){
            winner = 1
        }
        if(playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)) {
            winner = 2
        }


        //diagonal 1
        if(playerOne.contains(1) && playerOne.contains(5) && playerOne.contains(9)){
            winner = 1
        }
        if(playerTwo.contains(1) && playerTwo.contains(5) && playerTwo.contains(9)){
            winner = 2
        }
        //diagonal 2
        if(playerOne.contains(3) && playerOne.contains(5) && playerOne.contains(7)){
            winner = 1
        }
        if(playerTwo.contains(3) && playerTwo.contains(5) && playerTwo.contains(7)){
            winner = 2
        }


        //display winner

        //if(winner != -1){}

        if(winner == 1){
            Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show()
        }
        if(winner == 2){
            Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show()
        }

    }

    fun autoPlay(){
        var emptyCells = ArrayList<Int>()
        for(cellId in 1..9){
            if(!(playerOne.contains(cellId) || playerTwo.contains(cellId))){
                emptyCells.add(cellId)
            }
        }

        val r = Random()
        val randomIndex = r.nextInt(emptyCells.size - 0) + 0
        val cellId = emptyCells.get(randomIndex)

        var butSelect: Button?
        when(cellId){
            1 -> butSelect = but1
            2 -> butSelect = but2
            3 -> butSelect = but3
            4 -> butSelect = but4
            5 -> butSelect = but5
            6 -> butSelect = but6
            7 -> butSelect = but7
            8 -> butSelect = but8
            9 -> butSelect = but9
            else ->{
                butSelect = but1
            }
        }
        playGame(cellId, butSelect)
    }
}
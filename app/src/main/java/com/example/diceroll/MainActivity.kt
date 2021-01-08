
//import bibliotek itp.

package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.diceroll.R
import org.jetbrains.annotations.NotNull
import java.util.*
import kotlin.concurrent.schedule

//klasa main (czyli to, co wykonuje program z pomocą activity_main.xml)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //opis działania buttona - button wykonuje funkcję rzutu kostką

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollButton.setOnClickListener {
                rollDice()
            }
        }

    }

//funkcja rzutu kostkami

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val dice2 = Dice.Dice2(6)
        val diceRoll2 = dice.roll()

        val dice3 = Dice.Dice3(6)
        val diceRoll3 = dice.roll()

        val dice4 = Dice.Dice4(6)
        val diceRoll4 = dice.roll()

        val sumOfDiceRoll = diceRoll + diceRoll2

        //główna gra

        fun fight() {

//to sa wlasnosci przeciwnika

            val healthBossa = 8
            val healthLeft = healthBossa - sumOfDiceRoll //odejmujemy sume wyrzuconych oczek od zadanego zycia przeciwnika
            //tu mamy ifa ktory wyswietla prawidlowa wartosc na kostkach (gornych - usera) w zaleznosci od wyrzuconych oczek
            val diceImage: ImageView = findViewById(R.id.imageView)
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                6 -> diceImage.setImageResource(R.drawable.dice_6)
            }
            val diceImage2: ImageView = findViewById(R.id.imageView4)
            when (diceRoll2) {
                1 -> diceImage2.setImageResource(R.drawable.dice_1)
                2 -> diceImage2.setImageResource(R.drawable.dice_2)
                3 -> diceImage2.setImageResource(R.drawable.dice_3)
                4 -> diceImage2.setImageResource(R.drawable.dice_4)
                5 -> diceImage2.setImageResource(R.drawable.dice_5)
                6 -> diceImage2.setImageResource(R.drawable.dice_6)
            }

            //jesli przeciwnikowi zostalo mniej lub rowne 0 punktow zycia, to display toast, czyli komunikat ze wygrales

            if (healthLeft <= 0) {
                val toast = Toast.makeText(this, "Udało Ci sie pokonać przeciwnika", Toast.LENGTH_SHORT)
                toast.show()

            //jesli nie pokonales przeciwnika, czyli zostalo mu wiecej niz 0 hp, to dysplayujemy że nie pokonałeś + wykonujemy jego ruch

            } else {

                val toast = Toast.makeText(this, "Nie pokonałeś przeciwnika, zostało mu $healthLeft punktów życia, teraz on spróbuje Cię pokonać", Toast.LENGTH_SHORT)
                toast.show()


                //tu mamy ruch przeciwnika

                val sumOfDiceRollBossa = diceRoll3 + diceRoll4
                val healthUsera = 8
                val healthLeftUsera = healthUsera - sumOfDiceRollBossa


                if (healthLeftUsera <= 0) {
                    Handler(Looper.getMainLooper()).postDelayed({
                    val toast = Toast.makeText(this, "Zostałeś pokonany", Toast.LENGTH_SHORT)
                    toast.show()
                    }, 5500)
                } else {


                    val toast = Toast.makeText(this, "Przeżyłeś walkę, zostało Ci $healthLeftUsera punktów życia", Toast.LENGTH_SHORT)
                    toast.show()
                }

                //tu jest to samo, co z kostkami usera, tylko rollujemy te na dole

                Handler(Looper.getMainLooper()).postDelayed({

                val diceImage: ImageView = findViewById(R.id.imageView2)
                when (diceRoll3) {
                    1 -> diceImage.setImageResource(R.drawable.dice_1_boss)
                    2 -> diceImage.setImageResource(R.drawable.dice_2_boss)
                    3 -> diceImage.setImageResource(R.drawable.dice_3_boss)
                    4 -> diceImage.setImageResource(R.drawable.dice_4_boss)
                    5 -> diceImage.setImageResource(R.drawable.dice_5_boss)
                    6 -> diceImage.setImageResource(R.drawable.dice_6_boss)
                }
                val diceImage2: ImageView = findViewById(R.id.imageView3)
                when (diceRoll4) {
                    1 -> diceImage2.setImageResource(R.drawable.dice_1_boss)
                    2 -> diceImage2.setImageResource(R.drawable.dice_2_boss)
                    3 -> diceImage2.setImageResource(R.drawable.dice_3_boss)
                    4 -> diceImage2.setImageResource(R.drawable.dice_4_boss)
                    5 -> diceImage2.setImageResource(R.drawable.dice_5_boss)
                    6 -> diceImage2.setImageResource(R.drawable.dice_6_boss)
                }
                }, 5000)
            }

            //to zlejcie, jest mi potrzebne w konsoli
            println(healthLeft)
        }
        println(fight())


    }


    // tu mamy nasze kostki w klasach z funkcją rzutu

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()

        }


        class Dice2(private val numSides: Int) {

            fun roll(): Int {
                return (1..numSides).random()

            }
        }

        class Dice3(private val numSides: Int) {

            fun roll(): Int {
                return (1..numSides).random()

            }
        }
        class Dice4(private val numSides: Int) {

            fun roll(): Int {
                return (1..numSides).random()

            }
        }
    }
}

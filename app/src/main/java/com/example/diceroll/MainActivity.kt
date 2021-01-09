
//import bibliotek itp.

package com.example.diceroll

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
    //funkcja rzutu kostkami

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        val diceRoll3 = dice.roll()
        val diceRoll4 = dice.roll()

        val sumOfDiceRoll = diceRoll + diceRoll2

        fun diceImagePick(diceRoll: Int) {
            val diceImage: ImageView = findViewById(R.id.imageView)
            val diceImage2: ImageView = findViewById(R.id.imageView4)
            val diceImage3: ImageView = findViewById(R.id.imageView2)
            val diceImage4: ImageView = findViewById(R.id.imageView3)
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                6 -> diceImage.setImageResource(R.drawable.dice_6)
            }
            when (diceRoll2) {
                1 -> diceImage2.setImageResource(R.drawable.dice_1)
                2 -> diceImage2.setImageResource(R.drawable.dice_2)
                3 -> diceImage2.setImageResource(R.drawable.dice_3)
                4 -> diceImage2.setImageResource(R.drawable.dice_4)
                5 -> diceImage2.setImageResource(R.drawable.dice_5)
                6 -> diceImage2.setImageResource(R.drawable.dice_6)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                when (diceRoll3) {
                    1 -> diceImage3.setImageResource(R.drawable.dice_1_boss)
                    2 -> diceImage3.setImageResource(R.drawable.dice_2_boss)
                    3 -> diceImage3.setImageResource(R.drawable.dice_3_boss)
                    4 -> diceImage3.setImageResource(R.drawable.dice_4_boss)
                    5 -> diceImage3.setImageResource(R.drawable.dice_5_boss)
                    6 -> diceImage3.setImageResource(R.drawable.dice_6_boss)
                }
                when (diceRoll4) {
                    1 -> diceImage4.setImageResource(R.drawable.dice_1_boss)
                    2 -> diceImage4.setImageResource(R.drawable.dice_2_boss)
                    3 -> diceImage4.setImageResource(R.drawable.dice_3_boss)
                    4 -> diceImage4.setImageResource(R.drawable.dice_4_boss)
                    5 -> diceImage4.setImageResource(R.drawable.dice_5_boss)
                    6 -> diceImage4.setImageResource(R.drawable.dice_6_boss)
                }
            }, 4500)
        }


        //główna gra

        fun fight() {

//to sa wlasnosci przeciwnika

            val healthBossa = 8
            val healthLeft = healthBossa - sumOfDiceRoll //odejmujemy sume wyrzuconych oczek od zadanego zycia przeciwnika
            //tu mamy ifa ktory wyswietla prawidlowa wartosc na kostkach (gornych - usera) w zaleznosci od wyrzuconych oczek

            diceImagePick(diceRoll)
            diceImagePick(diceRoll2)

            /*val diceImage: ImageView = findViewById(R.id.imageView)
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
            }*/

            //jesli przeciwnikowi zostalo mniej lub rowne 0 punktow zycia, to display toast, czyli komunikat ze wygrales

            if (healthLeft <= 0) {
                val toast =
                    Toast.makeText(this, "Udało Ci sie pokonać przeciwnika", Toast.LENGTH_SHORT)
                toast.show()

                //jesli nie pokonales przeciwnika, czyli zostalo mu wiecej niz 0 hp, to dysplayujemy że nie pokonałeś + wykonujemy jego ruch

            } else {

                val toast = Toast.makeText(
                    this,
                    "Nie pokonałeś przeciwnika, zostało mu $healthLeft HP, teraz on spróbuje Cię pokonać",
                    Toast.LENGTH_SHORT
                )
                toast.show()

                //tu mamy ruch przeciwnika

                val sumOfDiceRollBossa = diceRoll3 + diceRoll4
                val healthUsera = 8
                val healthLeftUsera = healthUsera - sumOfDiceRollBossa


                if (healthLeftUsera <= 0) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        val toast = Toast.makeText(this, "Zostałeś pokonany", Toast.LENGTH_SHORT)
                        toast.show()
                    }, 5000)
                } else {
                    Handler(Looper.getMainLooper()).postDelayed({
                        val toast = Toast.makeText(
                            this,
                            "Przeżyłeś walkę, zostało Ci $healthLeftUsera HP",
                            Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }, 5000)
                }

                //tu jest to samo, co z kostkami usera, tylko rollujemy te na dole

                diceImagePick(diceRoll3)
                diceImagePick(diceRoll4)

                /*  val diceImage: ImageView = findViewById(R.id.imageView2)
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

            }

            //to zlejcie, jest mi potrzebne w konsoli
            println(healthLeft) */
            }
            println(fight())
        }

        // tu mamy nasze kostki w klasach z funkcją rzutu


    }
}

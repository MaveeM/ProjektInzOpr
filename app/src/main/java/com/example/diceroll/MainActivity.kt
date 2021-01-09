
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

        //opis działania buttona - button wykonuje funkcję fight, czyli calej gry

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollButton.setOnClickListener {

                fight()
            }
        }
    }

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
//tu wybieramy poprawny obrazek w zależności od wartości wyrzuconych oczek
    fun diceImagePick(diceRoll: Int, diceImage: ImageView, isBoss:Boolean) {

        if (isBoss) {
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.dice_1_boss)
                2 -> diceImage.setImageResource(R.drawable.dice_2_boss)
                3 -> diceImage.setImageResource(R.drawable.dice_3_boss)
                4 -> diceImage.setImageResource(R.drawable.dice_4_boss)
                5 -> diceImage.setImageResource(R.drawable.dice_5_boss)
                6 -> diceImage.setImageResource(R.drawable.dice_6_boss)
            }
        }
            else {
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                6 -> diceImage.setImageResource(R.drawable.dice_6)
            }
        }
    }

        //główna gra

        fun fight() {

            val dice = Dice(6)
            val diceRoll = dice.roll()
            val diceRoll2 = dice.roll()
            val diceRoll3 = dice.roll()
            val diceRoll4 = dice.roll()
            val sumOfDiceRoll = diceRoll + diceRoll2

            val healthBossa = 8
            val healthLeft = healthBossa - sumOfDiceRoll //odejmujemy sume wyrzuconych oczek od zadanego zycia przeciwnika

            //tu mamy ifa ktory wyswietla prawidlowa wartosc na kostkach (gornych - usera) w zaleznosci od wyrzuconych oczek

            val diceImage: ImageView = findViewById(R.id.imageView)
            val diceImage2: ImageView = findViewById(R.id.imageView4)
            val diceImage3: ImageView = findViewById(R.id.imageView2)
            val diceImage4: ImageView = findViewById(R.id.imageView3)

            diceImagePick(diceRoll, diceImage, false)
            diceImagePick(diceRoll2, diceImage2, false)


            //jesli przeciwnikowi zostalo mniej lub rowne 0 punktow zycia, to display toast, czyli komunikat ze wygrales

            if (healthLeft <= 0) {
                val toast = Toast.makeText(this, "Udało Ci sie pokonać przeciwnika", Toast.LENGTH_SHORT)
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
                Handler(Looper.getMainLooper()).postDelayed({
                    diceImagePick(diceRoll3, diceImage3, true)
                    diceImagePick(diceRoll4, diceImage4, true)
                }, 4500)
            }

        }

    }


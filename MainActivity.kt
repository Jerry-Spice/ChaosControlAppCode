package com.example.chaoscontrol

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setting Up all the text variables
        var order1 = findViewById<TextView>(R.id.order1)
        var order2 = findViewById<TextView>(R.id.order2)
        var order3 = findViewById<TextView>(R.id.order3)
        var order4 = findViewById<TextView>(R.id.order4)
        var order5 = findViewById<TextView>(R.id.order5)
        var points = findViewById<TextView>(R.id.points)

        val electrons = findViewById<TextView>(R.id.currentElectron)

        val livesTextElement = findViewById<TextView>(R.id.errors)

        val titleScreen = findViewById<View>(R.id.startGameView)
        val startGameText =  findViewById<TextView>(R.id.titleText)
        val startGameButton = findViewById<Button>(R.id.startGameButton)

        val endGamePopUp = findViewById<View>(R.id.losescreen)
        val endgameText = findViewById<TextView>(R.id.loseMessage)
        val endgameButton = findViewById<Button>(R.id.playagainbutton)

        val order1Bar = findViewById<ProgressBar>(R.id.progressBar1)
        val order2Bar = findViewById<ProgressBar>(R.id.progressBar2)
        val order3Bar = findViewById<ProgressBar>(R.id.progressBar3)
        val order4Bar = findViewById<ProgressBar>(R.id.progressBar4)
        val order5Bar = findViewById<ProgressBar>(R.id.progressBar5)

        val stabalizeCoreSwitch = findViewById<Switch>(R.id.stabalizeCoreSwitch)
        val neutralizeElectronsSeekBar = findViewById<SeekBar>(R.id.seekBar2)
        val coolReactorButton = findViewById<Button>(R.id.coolReactorBtn)
        val fixLightsButton = findViewById<Button>(R.id.fixLightsBtn)

        //variable for lives
        var lives = 0
        var livesText = ""

        var playing = true

        //variables for ordersTexts
        var order1Text = ""
        var order2Text = ""
        var order3Text = ""
        var order4Text = ""
        var order5Text = ""

        var currentElectron = 0

        //variables for the progress bars
        var order1BarProgress = 0;
        var order2BarProgress = 0;
        var order3BarProgress = 0;
        var order4BarProgress = 0;
        var order5BarProgress = 0;

        var timer = 5000;
        var completed = 5;
        var targetElectrons = Random.nextInt(5)
        var totalPoints = 0

        var addMoreLimit = 20

        order1.text = order1Text

        //end game pop-up functions
        fun showPopup() {
            endGamePopUp.visibility =  View.VISIBLE
            endgameButton.visibility = View.VISIBLE
            endgameText.visibility = View.VISIBLE
            playing = false
        }
        fun destroyPopup() {
            endGamePopUp.visibility =  View.INVISIBLE
            endgameButton.visibility = View.INVISIBLE
            endgameText.visibility = View.INVISIBLE
        }
        fun resetData() {
            lives = 0
            livesText = ""
            playing = true
            order1Text = ""
            order2Text = ""
            order3Text = ""
            order4Text = ""
            order5Text = ""
            order1BarProgress = 0;
            order2BarProgress = 0;
            order3BarProgress = 0;
            order4BarProgress = 0;
            order5BarProgress = 0;
            timer = 5000;
            completed = 5;
            targetElectrons = Random.nextInt(5)
            totalPoints = 0
            lives = 0
            livesText = ""
            progressBar1.progress = 100
            progressBar2.progress = 100
            progressBar3.progress = 100
            progressBar4.progress = 100
            progressBar5.progress = 100
            order1.text = order1Text
            order2.text = order2Text
            order3.text = order3Text
            order4.text = order4Text
            order5.text = order5Text
            livesTextElement.text = ""
        }

        //setting up in-game events

        fun findNextEmptySlot(): Int {
            if (order1.text == "") {
                return 0
            } else if (order2.text == "") {
                return 1
            } else if (order3.text == "") {
                return 2
            } else if (order4.text == "") {
                return 3
            } else if (order5.text == "") {
                return 4
            } else {
                return 6
            }
        }

        var colors = arrayOf("#FF0000","#5262EC","#7C7979","#FFEB3B")

        fun addAnOrder(slot: Int) {
            var orderNumber = Random.nextInt(4)
            var addMore = Random.nextInt(addMoreLimit)
            if (slot == 0) {
                if (orderNumber == 0) {
                    order1Text = "Cool Reactor"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FF0000"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 1) {
                    order1Text = "Fix Lights"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#5262EC"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 2) {
                    order1Text = "Stabalize Core"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#7C7979"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 3) {
                    order1Text = "Neutralize Electrons ("+targetElectrons.toString()+")"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FFEB3B"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                }
            }
            if (slot == 1) {
                if (orderNumber == 0) {
                    order1Text = "Cool Reactor"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FF0000"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 1) {
                    order1Text = "Fix Lights"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#5262EC"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 2) {
                    order1Text = "Stabalize Core"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#7C7979"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 3) {
                    order1Text = "Neutralize Electrons ("+targetElectrons.toString()+")"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FFEB3B"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                }
            }
            if (slot == 2) {
                if (orderNumber == 0) {
                    order1Text = "Cool Reactor"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FF0000"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 1) {
                    order1Text = "Fix Lights"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#5262EC"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 2) {
                    order1Text = "Stabalize Core"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#7C7979"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 3) {
                    order1Text = "Neutralize Electrons ("+targetElectrons.toString()+")"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FFEB3B"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                }
            }
            if (slot == 3) {
                if (orderNumber == 0) {
                    order1Text = "Cool Reactor"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FF0000"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 1) {
                    order1Text = "Fix Lights"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#5262EC"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 2) {
                    order1Text = "Stabalize Core"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#7C7979"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 3) {
                    order1Text = "Neutralize Electrons ("+targetElectrons.toString()+")"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FFEB3B"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                }
            }
            if (slot == 4) {
                if (orderNumber == 0) {
                    order1Text = "Cool Reactor"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FF0000"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 1) {
                    order1Text = "Fix Lights"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#5262EC"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 2) {
                    order1Text = "Stabalize Core"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#7C7979"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                } else if (orderNumber == 3) {
                    order1Text = "Neutralize Electrons ("+targetElectrons.toString()+")"
                    if (totalPoints <= 5000) {
                        order1.setTextColor(Color.parseColor("#FFEB3B"))
                    } else {
                        var randomNumber = Random.nextInt(4);
                        order1.setTextColor(Color.parseColor(colors[randomNumber]))
                    }
                }
            }
            order1.text = order1Text
            order2.text = order2Text
            order3.text = order3Text
            order4.text = order4Text
            order5.text = order5Text
            if (addMore == 0 && slot + 1 < 5) {
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        (Random.nextInt(10) * 1000).toLong()
                )
                println("Adding another order")
            }
        }

        fun checkItems() {
            if (playing == true) {
                points.text = "Points: "+totalPoints.toString()

                //timer progress bars
                if (order1.text != "") {
                    progressBar1.progress -= 1
                    progressBar1.visibility = View.VISIBLE
                } else {
                    progressBar1.visibility = View.INVISIBLE
                }
                if (order2.text != "") {
                    progressBar2.progress -= 1
                    progressBar2.visibility = View.VISIBLE
                } else {
                    progressBar2.visibility = View.INVISIBLE
                }
                if (order3.text != "") {
                    progressBar3.progress -= 1
                    progressBar3.visibility = View.VISIBLE
                } else {
                    progressBar3.visibility = View.INVISIBLE
                }
                if (order4.text != "") {
                    progressBar4.progress -= 1
                    progressBar4.visibility = View.VISIBLE
                } else {
                    progressBar4.visibility = View.INVISIBLE
                }
                if (order5.text != "") {
                    progressBar5.progress -= 1
                    progressBar5.visibility = View.VISIBLE
                } else {
                    progressBar5.visibility = View.INVISIBLE
                }
                //resetting if they are empty
                if (progressBar1.progress <= 0) {
                    addAnOrder(0)
                    if (progressBar1.max - 100 > 100) {
                        progressBar1.max -= 100
                    }
                    progressBar1.progress = progressBar1.max
                    lives ++;
                    livesText += "X "
                }
                if (progressBar2.progress <= 0) {
                    addAnOrder(1)
                    if (progressBar2.max - 100 > 100) {
                        progressBar2.max -= 100
                    }
                    var lowerAddMoreLimit = Random.nextInt(2)
                    if (lowerAddMoreLimit == 0) {
                        addMoreLimit -= 1
                    }
                    progressBar2.progress = progressBar2.max
                    lives ++;
                    livesText += "X "
                }
                if (progressBar3.progress <= 0) {
                    addAnOrder(2)
                    if (progressBar3.max - 100 > 100) {
                        progressBar3.max -= 100
                    }
                    progressBar3.progress = progressBar3.max
                    lives ++;
                    livesText += "X "
                }
                if (progressBar4.progress <= 0) {
                    addAnOrder(3)
                    if (progressBar4.max - 100 > 100) {
                        progressBar4.max -= 100
                    }
                    progressBar4.progress = progressBar4.max
                    lives ++;
                    livesText += "X "
                }
                if (progressBar5.progress <= 0) {
                    addAnOrder(4)
                    if (progressBar5.max - 100 > 100) {
                        progressBar5.max -= 100
                    }
                    progressBar5.progress = progressBar5.max
                    lives ++;
                    livesText += "X "
                }
                //electrons swtich details
                electrons.text = neutralizeElectronsSeekBar.progress.toString()
                if (neutralizeElectronsSeekBar.progress.toInt() == targetElectrons.toInt()) {
                    targetElectrons = Random.nextInt(5)
                    if ("Neutralize Electrons" in order1.text) {
                        order1Text = ""
                        order1.text = ""
                        Handler().postDelayed(
                                { addAnOrder(findNextEmptySlot()) },
                                700
                        )
                        if (progressBar1.max - 100 > 100) {
                            progressBar1.max -= 100
                        }
                        totalPoints += 100
                        progressBar1.progress = progressBar1.max
                        var lowerAddMoreLimit = Random.nextInt(2)
                        if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                            addMoreLimit -= 1
                        }
                        completed --;
                        if (completed <= 0) {
                            timer -= 200;
                            completed = 5;
                        }
                    }
                    if ("Neutralize Electrons" in order2.text) {
                        order2Text = ""
                        order2.text = ""
                        if (progressBar2.max - 100 > 100) {
                            progressBar2.max -= 100
                        }
                        totalPoints += 100
                        progressBar2.progress = progressBar2.max
                        var lowerAddMoreLimit = Random.nextInt(2)
                        if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                            addMoreLimit -= 1
                        }
                        Handler().postDelayed(
                                { addAnOrder(findNextEmptySlot()) },
                                700
                        )

                        if (completed <= 0) {
                            timer -= 200;
                            completed = 5;
                        }
                    }
                    if ("Neutralize Electrons" in order3.text) {
                        order3Text = ""
                        order3.text = ""
                        if (progressBar3.max - 100 > 100) {
                            progressBar3.max -= 100
                        }
                        totalPoints += 100
                        progressBar3.progress = progressBar3.max
                        var lowerAddMoreLimit = Random.nextInt(2)
                        if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                            addMoreLimit -= 1
                        }
                        Handler().postDelayed(
                                { addAnOrder(findNextEmptySlot()) },
                                700
                        )
                        if (completed <= 0) {
                            timer -= 200;
                            completed = 5;
                        }
                    }
                    if ("Neutralize Electrons" in order4.text) {
                        order4Text = ""
                        order4.text = ""
                        if (progressBar4.max - 100 > 100) {
                            progressBar4.max -= 100
                        }
                        totalPoints += 100
                        progressBar4.progress = progressBar4.max
                        var lowerAddMoreLimit = Random.nextInt(2)
                        if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                            addMoreLimit -= 1
                        }
                        Handler().postDelayed(
                                { addAnOrder(findNextEmptySlot()) },
                                700
                        )
                        if (completed <= 0) {
                            timer -= 200;
                            completed = 5;
                        }
                    }
                    if ("Neutralize Electrons" in order5.text) {
                        order5Text = ""
                        order5.text = ""
                        if (progressBar5.max - 100 > 100) {
                            progressBar5.max -= 100
                        }
                        totalPoints += 100
                        progressBar5.progress = progressBar5.max
                        var lowerAddMoreLimit = Random.nextInt(2)
                        if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                            addMoreLimit -= 1
                        }
                        Handler().postDelayed(
                                { addAnOrder(findNextEmptySlot()) },
                                700
                        )

                        if (completed <= 0) {
                            timer -= 200;
                            completed = 5;
                        }
                    }
                }

                //managing the life things and the life texts
                livesTextElement.text = livesText
                if (lives >= 3) {
                    showPopup()
                } else {
                    destroyPopup()
                }

                //looping function so put everything else before this code
                Handler().postDelayed(
                        { checkItems() },
                        100
                )
            }
        }

        //button functions
        coolReactorButton.setOnClickListener() {
            if (order1.text == "Cool Reactor") {
                order1Text = ""
                order1.text = ""
                totalPoints += 100
                if (progressBar1.max - 100 > 100) {
                    progressBar1.max -= 100
                }
                progressBar1.progress = progressBar1.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order2.text == "Cool Reactor") {
                order2Text = ""
                order2.text = ""
                totalPoints += 100
                if (progressBar2.max - 100 > 100) {
                    progressBar2.max -= 100
                }
                progressBar2.progress = progressBar2.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order3.text == "Cool Reactor") {
                order3Text = ""
                order3.text = ""
                totalPoints += 100
                if (progressBar3.max - 100 > 100) {
                    progressBar3.max -= 100
                }
                progressBar3.progress = progressBar3.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order4.text == "Cool Reactor") {
                order4Text = ""
                order4.text = ""
                totalPoints += 100
                if (progressBar4.max - 100 > 100) {
                    progressBar4.max -= 100
                }
                progressBar4.progress = progressBar4.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order5.text == "Cool Reactor") {
                order5Text = ""
                order5.text = ""
                totalPoints += 100
                if (progressBar5.max - 100 > 100) {
                    progressBar5.max -= 100
                }
                progressBar5.progress = progressBar5.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }

        }
        fixLightsButton.setOnClickListener() {
            if (order1.text == "Fix Lights") {
                order1Text = ""
                order1.text = ""
                totalPoints += 100
                if (progressBar1.max - 100 > 100) {
                    progressBar1.max -= 100
                }
                progressBar1.progress = progressBar1.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order2.text == "Fix Lights") {
                order2Text = ""
                order2.text = ""
                totalPoints += 100
                if (progressBar2.max - 100 > 100) {
                    progressBar2.max -= 100
                }
                progressBar2.progress = progressBar2.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order3.text == "Fix Lights") {
                order3Text = ""
                order3.text = ""
                totalPoints += 100
                if (progressBar3.max - 100 > 100) {
                    progressBar3.max -= 100
                }
                progressBar3.progress = progressBar3.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order4.text == "Fix Lights") {
                order4Text = ""
                order4.text = ""
                totalPoints += 100
                if (progressBar4.max - 100 > 100) {
                    progressBar4.max -= 100
                }
                progressBar4.progress = progressBar4.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order5.text == "Fix Lights") {
                order5Text = ""
                order5.text = ""
                totalPoints += 100
                if (progressBar5.max - 100 > 100) {
                    progressBar5.max -= 100
                }
                progressBar5.progress = progressBar5.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
        }
        stabalizeCoreSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (order1.text == "Stabalize Core") {
                order1Text = ""
                order1.text = ""
                totalPoints += 100
                if (progressBar1.max - 100 > 100) {
                    progressBar1.max -= 100
                }
                progressBar1.progress = progressBar1.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order2.text == "Stabalize Core") {
                order2Text = ""
                order2.text = ""
                totalPoints += 100
                if (progressBar2.max - 100 > 100) {
                    progressBar2.max -= 100
                }
                progressBar2.progress = progressBar2.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order3.text == "Stabalize Core") {
                order3Text = ""
                order3.text = ""
                totalPoints += 100
                if (progressBar3.max - 100 > 100) {
                    progressBar3.max -= 100
                }
                progressBar3.progress = progressBar3.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order4.text == "Stabalize Core") {
                order4Text = ""
                order4.text = ""
                totalPoints += 100
                if (progressBar4.max - 100 > 100) {
                    progressBar4.max -= 100
                }
                progressBar4.progress = progressBar4.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order5.text == "Stabalize Core") {
                order5Text = ""
                order5.text = ""
                totalPoints += 100
                if (progressBar5.max - 100 > 100) {
                    progressBar5.max -= 100
                }
                progressBar5.progress = progressBar5.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            Handler().postDelayed(
                    { stabalizeCoreSwitch.isChecked = false  },
                    500
            )
        })
        stabalizeCoreSwitch.setOnClickListener() {
            if (order1.text == "Stabalize Core") {
                order1Text = ""
                order1.text = ""
                totalPoints += 100
                if (progressBar1.max - 100 > 100) {
                    progressBar1.max -= 100
                }
                progressBar1.progress = progressBar1.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order2.text == "Stabalize Core") {
                order2Text = ""
                order2.text = ""
                totalPoints += 100
                if (progressBar2.max - 100 > 100) {
                    progressBar2.max -= 100
                }
                progressBar2.progress = progressBar2.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order3.text == "Stabalize Core") {
                order3Text = ""
                order3.text = ""
                totalPoints += 100
                if (progressBar3.max - 100 > 100) {
                    progressBar3.max -= 100
                }
                progressBar3.progress = progressBar3.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order4.text == "Stabalize Core") {
                order4Text = ""
                order4.text = ""
                totalPoints += 100
                if (progressBar4.max - 100 > 100) {
                    progressBar4.max -= 100
                }
                progressBar4.progress = progressBar4.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            if (order5.text == "Stabalize Core") {
                order5Text = ""
                order5.text = ""
                totalPoints += 100
                if (progressBar5.max - 100 > 100) {
                    progressBar5.max -= 100
                }
                progressBar5.progress = progressBar5.max
                var lowerAddMoreLimit = Random.nextInt(2)
                if (lowerAddMoreLimit == 0 && addMoreLimit - 1 > 2) {
                    addMoreLimit -= 1
                }
                Handler().postDelayed(
                        { addAnOrder(findNextEmptySlot()) },
                        700
                )
                if (completed <= 0) {
                    timer -= 200;
                    completed = 5;
                }
            }
            //fixing the switch
            Handler().postDelayed(
                    { stabalizeCoreSwitch.isChecked = false  },
                    500
            )
        }

        neutralizeElectronsSeekBar.setOnClickListener() {
            checkItems()
        }

        startGameButton.setOnClickListener() {
            //making the start screen vanish
            startGameButton.visibility = View.INVISIBLE
            startGameText.visibility = View.INVISIBLE
            titleScreen.visibility = View.INVISIBLE
            destroyPopup()
            //starting the game functions
            //initial order
            addAnOrder(findNextEmptySlot())
            //starting the check items loop
            checkItems()
        }
        endgameButton.setOnClickListener() {
            destroyPopup()
            resetData()
            playing = true
            addAnOrder(findNextEmptySlot())
            checkItems()
        }


    }
}

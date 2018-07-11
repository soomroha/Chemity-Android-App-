package com.example.android.chemapp

import android.widget.Toast
import java.util.*
import java.util.ArrayList

class TopicPeriodicTableQuestionsLibrary {

    private val elementnames = ArrayList<String>()
    private val groupnames = ArrayList<String>()
    private val elementInfo  = mutableListOf<MutableList<String>>()
    private val totalQuestions = 10

    var choice1: String? = null
        private set
    var choice2: String? = null
        private set
    var choice3: String? = null
        private set
    var correctAnswer: String? = null
        private set

    private var r = Random()


    private var questionTypesSeen = mutableListOf<Int>()
    private var numberOfQuestionTypes = 9


    fun getQuestion(): String {

        if (questionTypesSeen.size == numberOfQuestionTypes) {

            questionTypesSeen.clear()
            // Theory questions should not be repeated
            questionTypesSeen.add(9)
            questionTypesSeen.add(10)
        }

        var index = r.nextInt(9) + 1
        while (questionTypesSeen.contains(index)) {
            index = r.nextInt(9) + 1
        }
        questionTypesSeen.add(index)


        //Question : X Element has how many valence electrons ?
        if (index == 1) {
            val index_correct = r.nextInt(elementnames.size)
            var name = elementnames[index_correct]
            var index_c1 = r.nextInt(elementnames.size) + 0

            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(elementnames.size) + 0
            }

            var index_c2 = r.nextInt(elementnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(elementnames.size) + 0
            }

            var index_c3 = r.nextInt(elementnames.size) + 0

            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(elementnames.size) + 0
            }

            this.choice1 = elementInfo[index_c1][5]
            this.choice2 = elementInfo[index_c2][5]
            this.choice3 = elementInfo[index_c3][5]
            this.correctAnswer = elementInfo[index_correct][5]

            val question = "How many valence electrons does $name have? "
            return question

        } else if (index == 2) {
            val index_correct = r.nextInt(elementnames.size)

            var index_c1 = r.nextInt(elementnames.size) + 0

            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(elementnames.size) + 0
            }

            var index_c2 = r.nextInt(elementnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(elementnames.size) + 0
            }

            var index_c3 = r.nextInt(elementnames.size) + 0

            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(elementnames.size) + 0
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]

            val question = "Which element has the highest reactivity?"
            return question
        } else if (index == 3) {
            val index_correct = r.nextInt(elementnames.size)

            var index_c1 = r.nextInt(elementnames.size) + 0

            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(elementnames.size) + 0
            }

            var index_c2 = r.nextInt(elementnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(elementnames.size) + 0
            }

            var index_c3 = r.nextInt(elementnames.size) + 0

            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(elementnames.size) + 0
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]

            val question = "Which element has the lowest reactivity?"
            return question
        } else if (index == 4) {
            val index_correct = r.nextInt(elementnames.size)
            var name = elementnames[index_correct]

            var index_c1 = r.nextInt(elementnames.size) + 0

            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(elementnames.size) + 0
            }

            var index_c2 = r.nextInt(elementnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(elementnames.size) + 0
            }

            var index_c3 = r.nextInt(elementnames.size) + 0

            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(elementnames.size) + 0
            }

            this.choice1 = elementInfo[index_c1][6]
            this.choice2 = elementInfo[index_c2][6]
            this.choice3 = elementInfo[index_c3][6]
            this.correctAnswer = elementInfo[index_correct][6]

            val question = "Which group does $name belong to?"
            return question
        } else if (index == 5) {
            val index_correct = r.nextInt(groupnames.size)
            var group = groupnames[index_correct]

            var index_c1 = r.nextInt(groupnames.size) + 0

            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(groupnames.size) + 0
            }

            var index_c2 = r.nextInt(groupnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(groupnames.size) + 0
            }

            var index_c3 = r.nextInt(groupnames.size) + 0

            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(groupnames.size) + 0
            }

            this.choice1 = groupnames[index_c1][0]
            this.choice2 = groupnames[index_c2][0]
            this.choice3 = groupnames[index_c3][0]
            this.correctAnswer = groupnames[index_correct][0]

            val question = "Which element does not belong to $group?"
            return question
        } else if (index == 6) {
            val index_correct = r.nextInt(elementnames.size)
            var name = elementInfo[index_correct][0]

            var index_c1 = r.nextInt(elementnames.size) + 0

            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(elementnames.size) + 0
            }

            var index_c2 = r.nextInt(elementnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(elementnames.size) + 0
            }

            var index_c3 = r.nextInt(elementnames.size) + 0

            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(elementnames.size) + 0
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]

            val question = "Which element is apart of the transition metal?"
            return question
        } else if (index == 7) {
            val index_correct = r.nextInt(elementnames.size)
            var name = elementnames[index_correct]

            var index_c1 = r.nextInt(elementnames.size) + 0

            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(elementnames.size) + 0
            }

            var index_c2 = r.nextInt(elementnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(elementnames.size) + 0
            }

            var index_c3 = r.nextInt(elementnames.size) + 0

            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(elementnames.size) + 0
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]
            val question = "Which element is apart of the halogens?"
            return question
        } else if (index == 8) {
            val index_correct = r.nextInt(elementnames.size)
            var name = elementnames[index_correct]

            var index_c1 = r.nextInt(elementnames.size) + 0

            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(elementnames.size) + 0
            }

            var index_c2 = r.nextInt(elementnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(elementnames.size) + 0
            }

            var index_c3 = r.nextInt(elementnames.size) + 0

            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(elementnames.size) + 0
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]
            val question = "Which element is apart of the noble gases?"
            return question
        } else if (index == 9) {

            val index_correct = r.nextInt(groupnames.size)
            var name = groupnames[index_correct][1]

            var index_c1 = r.nextInt(groupnames.size) + 0
            while (index_c1 == index_correct) {
                index_c1 = r.nextInt(groupnames.size) + 0
            }

            var index_c2 = r.nextInt(groupnames.size) + 0

            while (index_c2 == index_c1 || index_c2 == index_correct) {
                index_c2 = r.nextInt(groupnames.size) + 0
            }

            var index_c3 = r.nextInt(groupnames.size) + 0
            while (index_c3 == index_c2 || index_c3 == index_c1 || index_c3 == index_correct) {
                index_c3 = r.nextInt(groupnames.size) + 0
            }

            this.choice1 = groupnames[index_c1][1]
            this.choice2 = groupnames[index_c2][1]
            this.choice3 = groupnames[index_c3][1]
            this.correctAnswer = groupnames[index_correct][1]

            val question = "$name are found on which side of the periodic table?"
            return question
        } else if (index == 10) {
            Toast.makeText(this@TopicPeriodicTableQuestionsLibrary, "filler for lewis dot", Toast.LENGTH_SHORT).show()
        }

    }
}

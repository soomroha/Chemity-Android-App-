package com.example.android.chemapp

import java.util.*
import java.util.ArrayList

class TopicPeriodicTableQuestionsLibrary {

    private val elementnames = ArrayList<String>()
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
            var indexcorrect = r.nextInt(elementnames.size)
            var name = elementnames[indexcorrect]
            var indexc1 = r.nextInt(elementnames.size) + 0

            while (indexc1 == indexcorrect) {
                indexc1 = r.nextInt(elementnames.size) + 0
            }

            var indexc2 = r.nextInt(elementnames.size) + 0

            while (indexc2 == indexc1 || indexc2 == indexcorrect) {
                indexc2 = r.nextInt(elementnames.size) + 0
            }

            var indexc3 = r.nextInt(elementnames.size) + 0

            while (indexc3 == indexc2 || indexc3 == indexc1 || indexc3 == indexcorrect) {
                indexc3 = r.nextInt(elementnames.size) + 0
            }

            this.choice1 = elementInfo[indexc1][5]
            this.choice2 = elementInfo[indexc2][5]
            this.choice3 = elementInfo[indexc3][5]
            this.correctAnswer = elementInfo[indexcorrect][5]

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
            var name = elementInfo[index_correct][0]
            var group = elementInfo[index_correct][6]

            var index_c1 = r.nextInt(elementInfo.size) + 0

            var valid = true
            while (valid ) {
                index_c1 = r.nextInt(elementInfo.size) + 0
                if(index_c1 != index_correct && elementInfo[index_c1][6] != group){
                    valid = false
                }
            }

            var index_c2 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                index_c2 = r.nextInt(elementInfo.size) + 0
                if(index_c2 != index_correct && elementInfo[index_c2][6] != group && index_c2 != index_c1 ){
                    valid = false
                }
            }

            var index_c3 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                index_c3 = r.nextInt(elementInfo.size) + 0
                if(index_c3 != index_correct && elementInfo[index_c3][6] != group && index_c3 != index_c1 && index_c3 != index_c2){
                    valid = false
                }
            }

            this.choice1 = elementInfo[index_c1][6]
            this.choice2 = elementInfo[index_c2][6]
            this.choice3 = elementInfo[index_c3][6]
            this.correctAnswer = elementInfo[index_correct][6]

            val question = "Which group does $name belong to?"
            return question
        } else if (index == 5) {
            val index_correct = r.nextInt(elementInfo.size)
            var group = elementInfo[index_correct][6]

            var index_c1 = r.nextInt(elementInfo.size) + 0

            var valid = true
            while (valid ) {
                index_c1 = r.nextInt(elementInfo.size) + 0
                if(index_c1 != index_correct && elementInfo[index_c1][6] != group){
                    valid = false
                }
             }

            var index_c2 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                index_c2 = r.nextInt(elementInfo.size) + 0
                if(index_c2 != index_correct && elementInfo[index_c2][6] != group && index_c2 != index_c1 ){
                    valid = false
                }
            }

            var index_c3 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                index_c3 = r.nextInt(elementInfo.size) + 0
                if(index_c3 != index_correct && elementInfo[index_c3][6] != group && index_c3 != index_c1 && index_c3 != index_c2){
                    valid = false
                }
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]

            val question = "Which element does not belong to $group?"
            return question
        } else if (index == 6) {

            var index_correct = r.nextInt(elementInfo.size)
            var isnottransmetal = true
            while(isnottransmetal){
                index_correct = r.nextInt(elementInfo.size)
                if(elementInfo[index_correct][6] == "Transition Metal"){
                    isnottransmetal = false
                }
            }

            var index_c1 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c1][6] == "Transition Metal" && index_c1 != index_correct){
                    isnottransmetal = false
                }
            }

            var index_c2 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c2][6] == "Transition Metal" && index_c2 != index_correct && index_c2 != index_c1){
                    isnottransmetal = false
                }
            }

            var index_c3 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c3 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c3][6] == "Transition Metal" && index_c3 != index_correct && index_c3 != index_c2 && index_c3 != index_c1){
                    isnottransmetal = false
                }
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]

            val question = "Which element is apart of the transition metal?"
            return question
        } else if (index == 7) {
            var index_correct = r.nextInt(elementInfo.size)
            var isnottransmetal = true
            while(isnottransmetal){
                index_correct = r.nextInt(elementInfo.size)
                if(elementInfo[index_correct][6] == "halogens"){
                    isnottransmetal = false
                }
            }

            var index_c1 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c1][6] == "halogens" && index_c1 != index_correct){
                    isnottransmetal = false
                }
            }

            var index_c2 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c2][6] == "halogens" && index_c2 != index_correct && index_c2 != index_c1){
                    isnottransmetal = false
                }
            }

            var index_c3 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c3 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c3][6] == "halogens" && index_c3 != index_correct && index_c3 != index_c2 && index_c3 != index_c1){
                    isnottransmetal = false
                }
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]

            val question = "Which element is apart of the Halogens?"
            return question
        } else if (index == 8) {
            var index_correct = r.nextInt(elementInfo.size)
            var isnottransmetal = true
            while(isnottransmetal){
                index_correct = r.nextInt(elementInfo.size)
                if(elementInfo[index_correct][6] == "Noble Gases"){
                    isnottransmetal = false
                }
            }

            var index_c1 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c1][6] == "Noble Gases" && index_c1 != index_correct){
                    isnottransmetal = false
                }
            }

            var index_c2 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c2][6] == "Noble Gases" && index_c2 != index_correct && index_c2 != index_c1){
                    isnottransmetal = false
                }
            }

            var index_c3 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                index_c3 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[index_c3][6] == "Noble Gases" && index_c3 != index_correct && index_c3 != index_c2 && index_c3 != index_c1){
                    isnottransmetal = false
                }
            }

            this.choice1 = elementInfo[index_c1][0]
            this.choice2 = elementInfo[index_c2][0]
            this.choice3 = elementInfo[index_c3][0]
            this.correctAnswer = elementInfo[index_correct][0]

            val question = "Which element is apart of the Noble Gases?"
            return question
        }

        /*
        else if (index == 9) {

            Toast.makeText(this@TopicPeriodicTableQuestionsLibrary, "filler for autmoated theory", Toast.LENGTH_SHORT).show()
        } else if (index == 10) {
            Toast.makeText(this@TopicPeriodicTableQuestionsLibrary, "filler for lewis dot", Toast.LENGTH_SHORT).show()
        }
        */
        return ""
    }
    fun obtainChoice1() : String?{
        return this.choice1

    }

    fun obtainChoice2() : String?{
        return this.choice2

    }

    fun obtainChoice3() : String?{
        return this.choice3

    }

    fun obtainCorrectAnswer() : String?{
        return this.correctAnswer

    }
    fun obtainTotalNumberofQuestions() : Int{
        return this.totalQuestions
    }
    fun addElementInfo(element: String, symbol : String, atomicNumber: String, atomicWeight: String){

        elementInfo.add(mutableListOf(element, symbol, atomicNumber, atomicWeight))
    }
}

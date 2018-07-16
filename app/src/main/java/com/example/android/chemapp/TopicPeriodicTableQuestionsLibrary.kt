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
            val indexcorrect = r.nextInt(elementnames.size) + 0
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
            val indexcorrect = r.nextInt(elementnames.size) + 0

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

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the highest reactivity?"
            return question
        } else if (index == 3) {
            val indexcorrect = r.nextInt(elementnames.size)  + 0

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

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the lowest reactivity?"
            return question
        } else if (index == 4) {
            val indexcorrect = r.nextInt(elementnames.size)
            val name = elementInfo[indexcorrect][0]
            val group = elementInfo[indexcorrect][6]

            var indexc1 = r.nextInt(elementInfo.size) + 0

            var valid = true
            while (valid ) {
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(indexc1 != indexcorrect && elementInfo[indexc1][6] != group){
                    valid = false
                }
            }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(indexc2 != indexcorrect && elementInfo[indexc2][6] != group && indexc2 != indexc1 ){
                    valid = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                indexc3 = r.nextInt(elementInfo.size) + 0
                if(indexc3 != indexcorrect && elementInfo[indexc3][6] != group && indexc3 != indexc1 && indexc3 != indexc2){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][6]
            this.choice2 = elementInfo[indexc2][6]
            this.choice3 = elementInfo[indexc3][6]
            this.correctAnswer = elementInfo[indexcorrect][6]

            val question = "Which group does $name belong to?"
            return question
        } else if (index == 5) {
            val indexcorrect = r.nextInt(elementInfo.size) + 0
            val group = elementInfo[indexcorrect][6]

            var indexc1 = r.nextInt(elementInfo.size) + 0

            var valid = true
            while (valid ) {
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(indexc1 != indexcorrect && elementInfo[indexc1][6] != group){
                    valid = false
                }
             }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(indexc2 != indexcorrect && elementInfo[indexc2][6] != group && indexc2 != indexc1 ){
                    valid = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                indexc3 = r.nextInt(elementInfo.size) + 0
                if(indexc3 != indexcorrect && elementInfo[indexc3][6] != group && indexc3 != indexc1 && indexc3 != indexc2){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element does not belong to $group?"
            return question

        } else if (index == 6) {

            var indexcorrect = r.nextInt(elementInfo.size) + 0
            var isnottransmetal = true
            while(isnottransmetal){
                indexcorrect = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexcorrect][6] == "Transition Metal"){
                    isnottransmetal = false
                }
            }

            var indexc1 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc1][6] == "Transition Metal" && indexc1 != indexcorrect){
                    isnottransmetal = false
                }
            }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc2][6] == "Transition Metal" && indexc2 != indexcorrect && indexc2 != indexc1){
                    isnottransmetal = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc3 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc3][6] == "Transition Metal" && indexc3 != indexcorrect && indexc3 != indexc2 && indexc3 != indexc1){
                    isnottransmetal = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element is apart of the transition metal?"
            return question
        } else if (index == 7) {
            var indexcorrect = r.nextInt(elementInfo.size)
            var isnottransmetal = true
            while(isnottransmetal){
                indexcorrect = r.nextInt(elementInfo.size)
                if(elementInfo[indexcorrect][6] == "halogens"){
                    isnottransmetal = false
                }
            }

            var indexc1 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc1][6] == "halogens" && indexc1 != indexcorrect){
                    isnottransmetal = false
                }
            }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc2][6] == "halogens" && indexc2 != indexcorrect && indexc2 != indexc1){
                    isnottransmetal = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc3 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc3][6] == "halogens" && indexc3 != indexcorrect && indexc3 != indexc2 && indexc3 != indexc1){
                    isnottransmetal = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element is apart of the Halogens?"
            return question
        } else if (index == 8) {
            var indexcorrect = r.nextInt(elementInfo.size)
            var isnottransmetal = true
            while(isnottransmetal){
                indexcorrect = r.nextInt(elementInfo.size)
                if(elementInfo[indexcorrect][6] == "Noble Gases"){
                    isnottransmetal = false
                }
            }

            var indexc1 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc1][6] == "Noble Gases" && indexc1 != indexcorrect){
                    isnottransmetal = false
                }
            }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc2][6] == "Noble Gases" && indexc2 != indexcorrect && indexc2 != indexc1){
                    isnottransmetal = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc3 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc3][6] == "Noble Gases" && indexc3 != indexcorrect && indexc3 != indexc2 && indexc3 != indexc1){
                    isnottransmetal = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

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
    fun addElementInfo(element: String, symbol : String, atomicNumber: String, atomicWeight: String, unknownnum :String,  numvalence: String , group: String){

        elementInfo.add(mutableListOf(element, symbol, atomicNumber, atomicWeight,unknownnum, numvalence , group))
    }
}

package com.example.android.chemapp

import java.util.*
import java.util.ArrayList

class TopicPeriodicTableQuestionsLibrary {
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
    private var numberOfQuestionTypes = 14

    fun getQuestion(): String {

        if (questionTypesSeen.size == numberOfQuestionTypes) {

            questionTypesSeen.clear()
            // Theory questions should not be repeated
            questionTypesSeen.add(9)
            questionTypesSeen.add(10)
            questionTypesSeen.add(11)
            questionTypesSeen.add(12)
            questionTypesSeen.add(13)
            //questionTypesSeen.add(14)
        }

        //nextInt(# of question types) + 1
        // remember to update when it changes to 15
        //Chooses the question type to do. as long as the question has not been seen before
        var index = r.nextInt(14) + 1
        while (questionTypesSeen.contains(index)) {
            index = r.nextInt(14) + 1
        }
        questionTypesSeen.add(index)

       /* index = 0
        if(index == 0) {
            this.choice1 = "a"
            this.choice2 = "b"
            this.choice3 = "c"
            this.correctAnswer = "d"

            val question = "Its A"
            return question
            //Question : X Element has how many valence electrons ?
        }else*/
        if (index == 1) {
            val indexcorrect = r.nextInt(elementInfo.size)

            var nooverlap = true
            var indexc1 = r.nextInt(elementInfo.size)

            while(nooverlap){
                indexc1 = r.nextInt(elementInfo.size)
                if(indexc1 != indexcorrect){
                    if(elementInfo[indexc1][1] != elementInfo[indexcorrect][1]){
                        nooverlap = false
                    }
                }
            }
            nooverlap = true

            var indexc2 = r.nextInt(elementInfo.size)
            while(nooverlap){
                indexc2 = r.nextInt(elementInfo.size)
                if(indexc2 != indexcorrect && indexc2 != indexc1){
                    if(elementInfo[indexc2][1] != elementInfo[indexcorrect][1] && elementInfo[indexc2][1] != elementInfo[indexc1][1]){
                        nooverlap = false
                    }
                }
            }
            nooverlap = true
            var indexc3 = r.nextInt(elementInfo.size)
            while(nooverlap){
                indexc3 = r.nextInt(elementInfo.size)
                if(indexc3 != indexcorrect && indexc3 != indexc2 && indexc3 != indexc1){
                    if(elementInfo[indexc3][1] != elementInfo[indexcorrect][1] && elementInfo[indexc3][1] != elementInfo[indexc2][1] && elementInfo[indexc3][1] != elementInfo[indexc1][1]){
                        nooverlap = false
                    }
                }
            }

            this.choice1 = elementInfo[indexc1][1]
            this.choice2 = elementInfo[indexc2][1]
            this.choice3 = elementInfo[indexc3][1]
            this.correctAnswer = elementInfo[indexcorrect][1]

            var name = elementInfo[indexcorrect][0]
            val question = "How many valence electrons does $name have? "
            return question

        }else if(index == 2 || index == 3 || index == 14){
            this.choice1 = "a"
            this.choice2 = "b"
            this.choice3 = "c"
            this.correctAnswer = "d"

            val question = "Its $index"
            return question
        }
       /* else if (index == 2) {
           //Which element has the highest reactivity?
           // May just want to take this question out due to too many factors in determining reactivity.
            val indexcorrect = r.nextInt(elementInfo.size)

            var indexc1 = r.nextInt(elementInfo.size)
            while (indexc1 == indexcorrect) {
                indexc1 = r.nextInt(elementInfo.size)
            }
            var indexc2 = r.nextInt(elementInfo.size)
            while (indexc2 == indexc1 || indexc2 == indexcorrect) {
                indexc2 = r.nextInt(elementInfo.size)
            }
            var indexc3 = r.nextInt(elementInfo.size)
            while (indexc3 == indexc2 || indexc3 == indexc1 || indexc3 == indexcorrect) {
                indexc3 = r.nextInt(elementInfo.size)
            }
            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the highest reactivity?"
            return question

        }

        else if (index == 3) {
            val indexcorrect = r.nextInt(elementInfo.size)
            var indexc1 = r.nextInt(elementInfo.size) + 0

            while (indexc1 == indexcorrect) {
                indexc1 = r.nextInt(elementInfo.size) + 0
            }

            var indexc2 = r.nextInt(elementInfo.size) + 0

            while (indexc2 == indexc1 || indexc2 == indexcorrect) {
                indexc2 = r.nextInt(elementInfo.size) + 0
            }

            var indexc3 = r.nextInt(elementInfo.size) + 0

            while (indexc3 == indexc2 || indexc3 == indexc1 || indexc3 == indexcorrect) {
                indexc3 = r.nextInt(elementInfo.size) + 0
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the lowest reactivity?"
            return question
        }  */
        else if (index == 4) {
            val indexcorrect = r.nextInt(elementInfo.size)
            val name = elementInfo[indexcorrect][0]
            val group = elementInfo[indexcorrect][2]

            var indexc1 = r.nextInt(elementInfo.size)
            var valid = true
            while (valid ) {
                indexc1 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc1][2] != group){
                    valid = false
                }
            }
            var indexc2 = r.nextInt(elementInfo.size)
            valid = true
            while (valid ) {
                indexc2 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc2][2] != group && indexc2 != indexc1 && elementInfo[indexc2][2] != elementInfo[indexc1][2]){
                    valid = false
                }
            }
            var indexc3 = r.nextInt(elementInfo.size)
            valid = true
            while (valid ) {
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][2] != group && indexc3 != indexc1 && indexc3 != indexc2 && elementInfo[indexc3][2] != elementInfo[indexc2][2] && elementInfo[indexc3][2] != elementInfo[indexc1][2]){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][2]
            this.choice2 = elementInfo[indexc2][2]
            this.choice3 = elementInfo[indexc3][2]
            this.correctAnswer = group

            val question = "Which group does $name belong to?"
            return question
        } else if (index == 5) {
            val keepgroupindex = r.nextInt(elementInfo.size)
            val staygroup = elementInfo[keepgroupindex][2]

            var indexc1 = r.nextInt(elementInfo.size)
            var valid = true
            while (valid ) {
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc1][2] == staygroup){
                    valid = false
                }
             }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            valid = true
            while (valid ) {
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc2][2] == staygroup && indexc2 != indexc1 ){
                    valid = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size)
            valid = true
            while (valid ) {
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][2] == staygroup && indexc3 != indexc1 && indexc3 != indexc2){
                    valid = false
                }
            }

            var indexfailure = r.nextInt(elementInfo.size)
            valid = true
            while (valid ) {
                indexfailure= r.nextInt(elementInfo.size)
                if(elementInfo[indexfailure][2] != staygroup){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexfailure][0]

            val question = "Which element does not belong to $staygroup?"
            return question

        } else if (index == 6) {
            var isnottransmetal = true

            var indexcorrect = r.nextInt(elementInfo.size)
            while(isnottransmetal){
                indexcorrect = r.nextInt(elementInfo.size)
                if(elementInfo[indexcorrect][2] == "Tranisition-Metal") {
                    isnottransmetal = false
                }
            }

            var indexc1 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc1][2] != "Transition-Metal"){
                    isnottransmetal = false
                }
            }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            isnottransmetal = true
            while(isnottransmetal){
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc2][2] != "Transition-Metal" && indexc2 != indexc1){
                    isnottransmetal = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size)
            isnottransmetal = true
            while(isnottransmetal){
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][2] != "Transition-Metal"  && indexc3 != indexc2 && indexc3 != indexc1){
                    isnottransmetal = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element is a part of the Transition-Metal?"
            return question
        } else if (index == 7) {
            var indexcorrect = r.nextInt(elementInfo.size)
            var isnothalogen = true
            while(isnothalogen){
                indexcorrect = r.nextInt(elementInfo.size)
                if(elementInfo[indexcorrect][2] == "Halogen"){
                    isnothalogen = false
                }
            }
            var indexc1 = r.nextInt(elementInfo.size) + 0
            isnothalogen = true
            while(isnothalogen){
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc1][2] != "Halogen"){
                    isnothalogen = false
                }
            }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            isnothalogen = true
            while(isnothalogen){
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc2][2] != "Halogen" && indexc2 != indexc1){
                    isnothalogen = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size) + 0
            isnothalogen = true
            while(isnothalogen){
                indexc3 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc3][2] != "Halogen" && indexc3 != indexc2 && indexc3 != indexc1){
                    isnothalogen = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element is a part of the Halogen?"
            return question
        } else if (index == 8) {
            var indexcorrect = r.nextInt(elementInfo.size)
            var isnotnoblegas = true
            while(isnotnoblegas){
                indexcorrect = r.nextInt(elementInfo.size)
                if(elementInfo[indexcorrect][2] == "Noble-Gases"){
                    isnotnoblegas = false
                }
            }

            var indexc1 = r.nextInt(elementInfo.size) + 0
            isnotnoblegas = true
            while(isnotnoblegas){
                indexc1 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc1][2] != "Noble-Gases"){
                    isnotnoblegas = false
                }
            }

            var indexc2 = r.nextInt(elementInfo.size) + 0
            isnotnoblegas = true
            while(isnotnoblegas){
                indexc2 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc2][2] != "Noble-Gases" && indexc2 != indexc1){
                    isnotnoblegas = false
                }
            }

            var indexc3 = r.nextInt(elementInfo.size) + 0
            isnotnoblegas = true
            while(isnotnoblegas){
                indexc3 = r.nextInt(elementInfo.size) + 0
                if(elementInfo[indexc3][2] != "Noble-Gases" && indexc3 != indexc2 && indexc3 != indexc1){
                    isnotnoblegas = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element is a part of the Noble Gases?"
            return question
        }

        else if (index == 9) {
            this.choice1 = "Groups 1 "
            this.choice2 = "Groups 13 - 16"
            this.choice3 = "Group 18"
            this.correctAnswer = "Groups 3 - 12"

            val question = "Transition Metals are found in which group"
            return question

        } else if (index == 10) {
            this.choice1 = "Groups 2"
            this.choice2 = "Groups 13 - 16"
            this.choice3 = "Group 18"
            this.correctAnswer = "Groups 16"
            val question = "Halogens are found in which group?"
            return question
        } else if (index == 11) {
            this.choice1 = "Groups 2"
            this.choice2 = "Groups 13 - 16"
            this.choice3 = "Group 1"
            this.correctAnswer = "Groups 18"
            val question = "Noble gases are found in which group?"
            return question
        } else if (index == 12) {
            this.choice1 = "Groups 1"
            this.choice2 = "Groups 13 - 16"
            this.choice3 = "Group 3 - 12"
            this.correctAnswer = "Groups 2"
            val question = "Akaline Earth Metals are found in which group?"
            return question
        } else if (index == 13) {
            this.choice1 = "Groups 2"
            this.choice2 = "Groups 13 - 16"
            this.choice3 = "Group 3 - 12"
            this.correctAnswer = "Groups 1"
            val question = "Alkali Metals are found in which group?"
            return question
        }


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
    fun addElementInfo(element: String,  numvalence: String , group: String){

        elementInfo.add(mutableListOf(element, numvalence , group))
    }
}

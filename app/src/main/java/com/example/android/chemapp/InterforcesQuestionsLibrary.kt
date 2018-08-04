package com.example.android.chemapp

import java.util.*
import java.util.ArrayList

class InterforcesQuestionsLibrary {
    //private val elementInfo  = mutableListOf<MutableList<String>>()
    private val totalQuestions = 6

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
    private var numberOfQuestionTypes = 6

    fun getQuestion(): String {

        if (questionTypesSeen.size == numberOfQuestionTypes) {

            questionTypesSeen.clear()
            // Theory questions should not be repeated
            for (i in 1..6) {
                questionTypesSeen.add(i)
            }

        }

        //nextInt(# of question types) + 1
        // remember to update when it changes to 15
        //Chooses the question type to do. as long as the question has not been seen before
        var index = r.nextInt(6) + 1
        while (questionTypesSeen.contains(index)) {
            index = r.nextInt(6) + 1
        }
        questionTypesSeen.add(index)

        if(index == 1){

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
    /*
    fun addElementInfo(element: String, atomicradii: String , electroneg : String , atomicaffine: String){

        elementInfo.add(mutableListOf(element,atomicradii,electroneg,atomicaffine))
    }
    */
}

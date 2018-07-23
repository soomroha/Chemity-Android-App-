package com.example.android.chemapp

import java.util.*
import java.util.ArrayList

class CharElementsQuestionsLibrary {
    private val elementInfo  = mutableListOf<MutableList<String>>()
    private val totalQuestions = 13

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
            for (i in 2..12) {
                questionTypesSeen.add(i)
            }
        }

        //Chooses the question type to do. as long as the question has not been seen before
        var index = r.nextInt(15) + 1
        while (questionTypesSeen.contains(index)) {
            index = r.nextInt(15) + 1
        }
        questionTypesSeen.add(index)

        if(index == 1){
            var valid = true
            var indexcorrect = r.nextInt(elementInfo.size)
            var group = elementInfo[indexcorrect][5]
            while(valid) {
                indexcorrect = r.nextInt(elementInfo.size)
                group = elementInfo[indexcorrect][5]
                valid = false
                if(group == "Metalloid"){
                    this.correctAnswer = "have properties of both metals and non-metal"
                }else if(group == "Alkaline-Earth-Metals") {
                    this.correctAnswer = "Shiny and Silvery , extremely reactive, missing 2 electrons"
                }else if(group == "Transition-Metal"){
                    this.correctAnswer ="Good conductors, malleable , typically have high melting points, typically solid "
                }else if(group == "Halogen"){
                    this.correctAnswer = "Brittle, poor conductors, most reactive of all non-metals"
                }else if(group == "Non-Metal"){
                    this.correctAnswer = "brittle, poor conductors , are found in different states"
                }else if(group == "Noble-Gases"){
                    this.correctAnswer = "Unreactive, colourless and odorless gases"
                }else if(group == "Alkali-Metals"){
                    this.correctAnswer = "Soft and sliverly , extremely reactive , missing 1 electron"
                }else{
                    valid = true
                }
            }

            var indexc1 = r.nextInt(elementInfo.size)
            var group1 = elementInfo[indexc1][5]
            while(valid) {
                indexc1 = r.nextInt(elementInfo.size)
                group1 = elementInfo[indexc1][5]
                if(indexc1 != indexcorrect && group != group1) {
                    valid = false
                    if (group1 == "Metalloid") {
                        this.choice1 = "have properties of both metals and non-metal"
                    } else if (group1 == "Alkaline-Earth-Metals") {
                        this.choice1 ="Shiny and Silvery , extremely reactive, missing 2 electrons"
                    } else if (group1 == "Transition-Metal") {
                        this.choice1 = "Good conductors, malleable , typically have high melting points, typically solid "
                    } else if (group1 == "Halogen") {
                        this.choice1 = "Brittle, poor conductors, most reactive of all non-metals"
                    } else if (group1 == "Non-Metal") {
                        this.choice1 = "brittle, poor conductors , are found in different states"
                    } else if (group1 == "Noble-Gases") {
                        this.choice1 ="Unreactive, colourless and odorless gases"
                    } else if (group1 == "Alkali-Metals") {
                        this.choice1 = "Soft and sliverly , extremely reactive , missing 1 electron"
                    } else {
                        valid = true
                    }
                }
            }

            var indexc2 = r.nextInt(elementInfo.size)
            var group2 = elementInfo[indexc2][5]
            while(valid) {
                indexc2 = r.nextInt(elementInfo.size)
                group2 = elementInfo[indexc2][5]
                if(indexc2 != indexcorrect && indexc2 != indexc1 && group != group2 && group1 != group2) {
                    valid = false
                    if (group2 == "Metalloid") {
                        this.choice2 = "have properties of both metals and non-metal"
                    } else if (group2 == "Alkaline-Earth-Metals") {
                        this.choice2 ="Shiny and Silvery , extremely reactive, missing 2 electrons"
                    } else if (group2 == "Transition-Metal") {
                        this.choice2 = "Good conductors, malleable , typically have high melting points, typically solid "
                    } else if (group2 == "Halogen") {
                        this.choice2 = "Brittle, poor conductors, most reactive of all non-metals"
                    } else if (group2 == "Non-Metal") {
                        this.choice2 = "brittle, poor conductors , are found in different states"
                    } else if (group2 == "Noble-Gases") {
                        this.choice2 ="Unreactive, colourless and odorless gases"
                    } else if (group2 == "Alkali-Metals") {
                        this.choice2 = "Soft and sliverly , extremely reactive , missing 1 electron"
                    } else {
                        valid = true
                    }
                }
            }

            var indexc3 = r.nextInt(elementInfo.size)
            var group3 = elementInfo[indexc3][5]
            while(valid) {
                indexc3 = r.nextInt(elementInfo.size)
                group3 = elementInfo[indexc3][5]
                if(indexc3 != indexcorrect && indexc3 != indexc2 && indexc3 != indexc1 && group3 != group && group3 != group2 && group3 != group1){
                    valid = false
                    if (group3 == "Metalloid") {
                        this.choice3  = "have properties of both metals and non-metal"
                    } else if (group3 == "Alkaline-Earth-Metals") {
                        this.choice3  ="Shiny and Silvery , extremely reactive, missing 2 electrons"
                    } else if (group3 == "Transition-Metal") {
                        this.choice3 = "Good conductors, malleable , typically have high melting points, typically solid "
                    } else if (group3 == "Halogen") {
                        this.choice3 = "Brittle, poor conductors, most reactive of all non-metals"
                    } else if (group3 == "Non-Metal") {
                        this.choice3 = "brittle, poor conductors , are found in different states"
                    } else if (group3 == "Noble-Gases") {
                        this.choice3 ="Unreactive, colourless and odorless gases"
                    } else if (group3 == "Alkali-Metals") {
                        this.choice3 = "Soft and sliverly , extremely reactive , missing 1 electron"
                    } else {
                        valid = true
                    }
                }
            }

            val name = elementInfo[indexcorrect][0]
            val question = "The best characteristics describing $name is:"
            return question
        }else if (index == 2) {
            this.choice1 = "Hard and Dark , non - reactive , stable and found in nature, has 2 extra electrons"
            this.choice2 = "Hard and sliverly , extremely reactive , not found in nature , has 2 missing electrons"
            this.choice3 = "Soft and Dark ,  slightly reactive , found in nature, has 1 extra electron"
            this.correctAnswer ="Soft and sliverly , extremely reactive , missing 1 electron"
            val question = "Characteristics of Alkali Metals are:"
            return question

        }else if(index == 3){
            this.choice1 = "Found in nature"
            this.choice2 = "Shiny and silvery, non reactive , has 2 extra electrons"
            this.choice3 = "Dull and dark , non reactive, has 2 extra electrons "
            this.correctAnswer ="Shiny and Silvery , extremely reactive, missing 2 electrons"
            val question = "Characteristics of Alkaline Earth Metals are:"
            return question

        }else if(index == 4){
            this.choice1 = "it is actually a noble gas"
            this.choice2 = " it's actually a alkaline earth metal "
            this.choice3 = "it's not strange at all"
            this.correctAnswer ="it shares the same number of valence electrons of alkali metals"
            val question = "Hydrogen is strange because ____"
            return question

        }else if(index == 5){
            this.choice1 = "malleable , weak conductors , never solid at room temperature"
            this.choice2 = "Ductile , good conductors , all are solid at room temperature"
            this.choice3 = "Brittle , weak conductors , mostly solid at room temperature"
            this.correctAnswer = "Malleable, ductile , good conductors , mostly solid at room temperature"
            val question = "Characteristics of Transition Metals are:"
            return question

        }else if(index == 6){
            this.choice1 = "Good Conductors"
            this.choice2 = "Malleable, ductile , good conductors , solid at room temperature "
            this.choice3 = "Ductile , good conductors , found in pure states in nature"
            this.correctAnswer ="brittle, poor conductors , are found in different states"
            val question = "Characteristics of Non-Metals are:"
            return question

        }else if(index == 7){
            this.choice1 = "Extremely reactive"
            this.choice2 = "Unreactive, colourful and has distinct odors  "
            this.choice3 = "Reactive , behave similar to Halogens"
            this.correctAnswer ="unreactive, colourless and odorless gases"
            val question = " Characteristics of Noble Gases are:"
            return question

        }else if(index == 8){
            this.choice1 = "Stable "
            this.choice2 = "Including Metalloids"
            this.choice3 = "Always solid at room temperature"
            this.correctAnswer ="Atoms who have an incomplete subshell in the d subshells"

            val question = "Transition metals are referred to as _____"
            return question
        }else if(index == 9){
            this.choice1 = "Non-metals and halogens"
            this.choice2 = "Similar to Gases only "
            this.choice3 = "Similar to Transition metals only"
            this.correctAnswer ="both metals and non-metal"
            val question = "Metalloids have properties of_____"
            return question

        }else if(index == 10){
            this.choice1 = "They have the same number of shells"
            this.choice2 = "They have the same number of valence electrons"
            this.choice3 = "They have similar physical properties"
            this.correctAnswer ="They both only need to remove/add 1 valence electron to be stable "

            val question = "Why are the Alkali Metals and Halogens so reactive?"
            return question
        }else if(index == 11){
            this.choice1 = "Are extremely reactive"
            this.choice2 = "Always have the exact same reactivity"
            this.choice3 = "Be different from one another."
            this.correctAnswer ="have the same number of valence electrons"
            val question = "Elements in the same group tend to_____"
            return question

        }else if(index == 12){
            this.choice1 = "lose electrons"
            this.choice2 = "be more reactive than before"
            this.choice3 = "become Unstable"
            this.correctAnswer = "become  Stable"

            val question = "Elements are always looking to ___"
            return question
        }else if(index == 13){
            this.choice1 = "they are have the same number of shells"
            this.choice2 = "they have similar physical properties"
            this.choice3 = "they don't react the same "
            this.correctAnswer ="they typically have the same number of valence electrons"

            val question = "Why do groups elements react the same?"
            return question
        }else if(index == 14){
            this.choice1 = "They have the same number of shells"
            this.choice2 = " Everything reacts, noble gases react as well"
            this.choice3 = "They have the same physical properties"
            this.correctAnswer ="They already have full shells "

            val question = "Why do nobles gases not react"
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
    fun addElementInfo(element: String, symbol : String, atomicNumber: String, atomicWeight: String,  numvalence: String , group: String){
        elementInfo.add(mutableListOf(element, symbol, atomicNumber, atomicWeight, numvalence , group))
    }
}

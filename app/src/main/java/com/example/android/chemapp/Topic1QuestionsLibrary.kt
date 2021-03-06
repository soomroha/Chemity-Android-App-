package com.example.android.chemapp

import java.util.*



class Topic1QuestionsLibrary {

    private val names = ArrayList<String>()
    private val formulas = ArrayList<String>()

    private val elementInfo  = mutableListOf<MutableList<String>>()

    private val charges = mutableListOf<MutableList<String>>()

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

    private var numberOfQuestionTypes = 8


    fun getQuestion(): String {

        if(questionTypesSeen.size == numberOfQuestionTypes){

            questionTypesSeen.clear()
            // Theory questions should not be repeated
            questionTypesSeen.add(8)
        questionTypesSeen.add(9)
        questionTypesSeen.add(10)
    }



        var i = r.nextInt(8) + 1

        while(questionTypesSeen.contains(i)){
            i = r.nextInt(8) + 1
        }

        questionTypesSeen.add(i)


        // Formula to Name
        if (i == 1 || i == 2) {

            val indexcorrect = r.nextInt(names.size) + 0

            val name = names[indexcorrect]
            val formula = formulas[indexcorrect]

            var indexc1 = r.nextInt(names.size) + 0

            while (indexc1 == indexcorrect) {
                indexc1 = r.nextInt(names.size) + 0
            }

            var indexc2 = r.nextInt(names.size) + 0

            while (indexc2 == indexc1 || indexc2 == indexcorrect) {
                indexc2 = r.nextInt(names.size) + 0
            }

            var indexc3 = r.nextInt(names.size) + 0

            while (indexc3 == indexc2 || indexc3 == indexc1 || indexc3 == indexcorrect) {
                indexc3 = r.nextInt(names.size) + 0
            }

            if(i == 1){
                this.choice1 = names[indexc1]
                this.choice2 = names[indexc2]
                this.choice3 = names[indexc3]
                this.correctAnswer = names[indexcorrect]

                val question = "What is the name of the following compound:" + System.lineSeparator() + System.lineSeparator() + formula + System.lineSeparator()
                return question
            }

            else if (i == 2){
                this.choice1 = formulas[indexc1]
                this.choice2 = formulas[indexc2]
                this.choice3 = formulas[indexc3]
                this.correctAnswer = formulas[indexcorrect]

                val question = "What is the formula of $name"
                return question
            }


        }

        else if(i == 3){


            val indexcorrect = r.nextInt(elementInfo.size) + 0

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

            val question = "What is the name of the following chemical element:" + System.lineSeparator() + System.lineSeparator() + elementInfo[indexcorrect][1] + System.lineSeparator()

            return question
        }


        else if(i == 4){


            val indexcorrect = r.nextInt(elementInfo.size) + 0

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


            val elementName = elementInfo[indexcorrect][0]
            val atomicNumber = elementInfo[indexcorrect][2]
            val atomicWeight = elementInfo[indexcorrect][3]

            this.choice1 = atomicWeight
            this.choice2 = (atomicWeight.toInt() - atomicNumber.toInt()).toString()
            this.choice3 = (atomicWeight.toInt() + atomicNumber.toInt()).toString()
            this.correctAnswer = elementInfo[indexcorrect][2]

            val question = "The $elementName atom has an atomic number of $atomicNumber and an atomic weight of $atomicWeight." + System.lineSeparator() + "How many protons does $elementName atom have?"

            return question


        }

        else if(i == 5){

            val indexcorrect = r.nextInt(elementInfo.size) + 0

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


            val protons = elementInfo[indexcorrect][2].toInt()

            val randomRange = r.nextInt(4) + 1

            val neutrons = protons + randomRange

            val massNumber = protons + neutrons

            val wrong = neutrons - protons

            this.choice1 = neutrons.toString()
            this.choice2 = protons.toString()
            this.choice3 = wrong.toString()
            this.correctAnswer = massNumber.toString()

            val question = "An isotope has $protons protons and $neutrons neutrons." + System.lineSeparator() + "What is its mass number?"
            return question


        }

        else if(i == 6){

            val indexcorrect = r.nextInt(elementInfo.size) + 0

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


            val elementName = elementInfo[indexcorrect][0]
            val atomicNumber = elementInfo[indexcorrect][2]
            val atomicWeight = elementInfo[indexcorrect][3]

            this.choice1 = atomicNumber
            this.choice2 = atomicWeight
            this.choice3 = (atomicWeight.toInt() + atomicNumber.toInt()).toString()
            this.correctAnswer = (atomicWeight.toInt() - atomicNumber.toInt()).toString()


            val question = "If $elementName atom has a mass number of $atomicWeight, how many neutrons does it have?"

            return question

        }

        else if (i == 7){

            val indexcorrect = r.nextInt(charges.size) + 0

            var indexc1 = r.nextInt(charges.size) + 0

            while (indexc1 == indexcorrect) {
                indexc1 = r.nextInt(charges.size) + 0
            }

            var indexc2 = r.nextInt(charges.size) + 0

            while (indexc2 == indexc1 || indexc2 == indexcorrect) {
                indexc2 = r.nextInt(charges.size) + 0
            }

            var indexc3 = r.nextInt(charges.size) + 0

            while (indexc3 == indexc2 || indexc3 == indexc1 || indexc3 == indexcorrect) {
                indexc3 = r.nextInt(charges.size) + 0
            }



            val elementName = charges[indexcorrect][0]
            val charge = charges[indexcorrect][1]

            if(charge.contains('+')){
                this.choice1 = charge[0].toString() + "-"
                val secondchoice = charge[0] + 1
                this.choice2 = secondchoice.toString() + "+"
                val thirdchoice = charge[0] + 2
                this.choice3 = thirdchoice.toString() + "+"

            }
            else if(charge.contains('-')){

                this.choice1 = charge[0].toString() + "+"
                val secondchoice = charge[0] + 1
                this.choice2 = secondchoice.toString() + "-"
                val thirdchoice = charge[0] + 2
                this.choice3 = thirdchoice.toString() + "-"

            }
            else{

                this.choice1 = "1+"
                this.choice2 = "2-"
                this.choice3 = "3+"

            }


            this.correctAnswer = charge

            val temp = charge[0]

            val question = "When $elementName becomes an ion, what is its typical charge?"

            return question


        }

        else if (i == 8){

            this.choice1 = "Protons are negatively charged"
            this.choice2 = "Protons orbit the nucleus"
            this.choice3 = "Protons have no charge"
            this.correctAnswer = "Protons are positively charged"

            val question = "Which of the following statements is true about protons?"

            return question
        }



        // Add two more


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

    fun addName (name : String){
        this.names.add(name)
    }

    fun addFormula(formula : String){
        this.formulas.add(formula)
    }

    fun addElementInfo(element: String, symbol : String, atomicNumber: String, atomicWeight: String){

        elementInfo.add(mutableListOf(element, symbol, atomicNumber, atomicWeight))
    }

    fun addElementCharge(element: String, charge : String){

        charges.add(mutableListOf(element, charge))

    }

    private fun getOptionIndexes() : MutableList<Int>{

        val a = 1
        val b = 2
        val c = 3
        val d = 4

        return mutableListOf<Int>(a,b,c,d)

    }


}

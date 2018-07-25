package com.example.android.chemapp

import java.util.*
import java.util.ArrayList

class TrendsInPTQuestionsLibrary {
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
    private var numberOfQuestionTypes = 15

    fun getQuestion(): String {

        if (questionTypesSeen.size == numberOfQuestionTypes) {

            questionTypesSeen.clear()
            // Theory questions should not be repeated
            for (i in 7..15) {
                questionTypesSeen.add(i)
            }

        }

        //nextInt(# of question types) + 1
        // remember to update when it changes to 15
        //Chooses the question type to do. as long as the question has not been seen before
        var index = r.nextInt(15) + 1
        while (questionTypesSeen.contains(index)) {
            index = r.nextInt(15) + 1
        }
        questionTypesSeen.add(index)

        if(index == 1){

            var indexcorrect = r.nextInt(elementInfo.size)

            var valid = true
            var indexc1 = r.nextInt(elementInfo.size)
            while(valid){
                indexc1 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc1][1] < elementInfo[indexcorrect][1]){
                    valid = false
                }
            }
            valid = true
            var indexc2 = r.nextInt(elementInfo.size)
            while(valid){
                indexc2 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc2][1] < elementInfo[indexcorrect][1] && indexc2 != indexc1 && indexc2 != indexcorrect){
                    valid = false
                }
            }
            valid = true
            var indexc3 = r.nextInt(elementInfo.size)
            while(valid){
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][1] < elementInfo[indexcorrect][1] && indexc3 != indexc2 && indexc3 != indexc1 && indexc3 != indexcorrect){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the largest atomic radius?"
            return question
        }else if(index == 2){
            var indexcorrect = r.nextInt(elementInfo.size)

            var valid = true
            var indexc1 = r.nextInt(elementInfo.size)
            while(valid){
                indexc1 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc1][1] > elementInfo[indexcorrect][1]){
                    valid = false
                }
            }
            valid= true
            var indexc2 = r.nextInt(elementInfo.size)
            while(valid){
                indexc2 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc2][1] > elementInfo[indexcorrect][1] && indexc2 != indexc1 && indexc2 != indexcorrect){
                    valid = false
                }
            }
            valid = true
            var indexc3 = r.nextInt(elementInfo.size)
            while(valid){
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][1] > elementInfo[indexcorrect][1] && indexc3 != indexc2 && indexc3 != indexc1 && indexc3 != indexcorrect){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the smallest atomic radius?"
            return question
        }else if(index == 3){
            var indexcorrect = r.nextInt(elementInfo.size)

            var valid = true
            var indexc1 = r.nextInt(elementInfo.size)
            while(valid){
                indexc1 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc1][2] < elementInfo[indexcorrect][2]){
                    valid = false
                }
            }
            valid= true
            var indexc2 = r.nextInt(elementInfo.size)
            while(valid){
                indexc2 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc2][2] < elementInfo[indexcorrect][2] && indexc2 != indexc1 && indexc2 != indexcorrect){
                    valid = false
                }
            }
            valid = true
            var indexc3 = r.nextInt(elementInfo.size)
            while(valid){
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][2] < elementInfo[indexcorrect][1] && indexc3 != indexc2 && indexc3 != indexc1 && indexc3 != indexcorrect){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the highest electronegativity?"
            return question

        }else if(index == 4){
            var indexcorrect = r.nextInt(elementInfo.size)

            var valid = true
            var indexc1 = r.nextInt(elementInfo.size)
            while(valid){
                indexc1 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc1][2] > elementInfo[indexcorrect][2]){
                    valid = false
                }
            }
            valid= true
            var indexc2 = r.nextInt(elementInfo.size)
            while(valid){
                indexc2 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc2][2] > elementInfo[indexcorrect][2] && indexc2 != indexc1 && indexc2 != indexcorrect){
                    valid = false
                }
            }
            valid = true
            var indexc3 = r.nextInt(elementInfo.size)
            while(valid){
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][2] > elementInfo[indexcorrect][2] && indexc3 != indexc2 && indexc3 != indexc1 && indexc3 != indexcorrect){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the lowest electronegativity?"
            return question
        }else if(index == 5){
            var indexcorrect = r.nextInt(elementInfo.size)

            var valid = true
            var indexc1 = r.nextInt(elementInfo.size)
            while(valid){
                indexc1 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc1][3] > elementInfo[indexcorrect][3]){
                    valid = false
                }
            }
            valid= true
            var indexc2 = r.nextInt(elementInfo.size)
            while(valid){
                indexc2 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc2][3] > elementInfo[indexcorrect][3] && indexc2 != indexc1 && indexc2 != indexcorrect){
                    valid = false
                }
            }
            valid = true
            var indexc3 = r.nextInt(elementInfo.size)
            while(valid){
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][3] > elementInfo[indexcorrect][3] && indexc3 != indexc2 && indexc3 != indexc1 && indexc3 != indexcorrect){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]

            val question = "Which element has the lowest electron affinity?"
            return question
        }else if(index == 6){
            var indexcorrect = r.nextInt(elementInfo.size)

            var valid = true
            var indexc1 = r.nextInt(elementInfo.size)
            while(valid){
                indexc1 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc1][3] < elementInfo[indexcorrect][3]){
                    valid = false
                }
            }
            valid= true
            var indexc2 = r.nextInt(elementInfo.size)
            while(valid){
                indexc2 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc2][3] < elementInfo[indexcorrect][3] && indexc2 != indexc1 && indexc2 != indexcorrect){
                    valid = false
                }
            }
            valid = true
            var indexc3 = r.nextInt(elementInfo.size)
            while(valid){
                indexc3 = r.nextInt(elementInfo.size)
                if(elementInfo[indexc3][3] < elementInfo[indexcorrect][3] && indexc3 != indexc2 && indexc3 != indexc1 && indexc3 != indexcorrect){
                    valid = false
                }
            }

            this.choice1 = elementInfo[indexc1][0]
            this.choice2 = elementInfo[indexc2][0]
            this.choice3 = elementInfo[indexc3][0]
            this.correctAnswer = elementInfo[indexcorrect][0]
            val question = "Which element has the highest electron affinity?"
            return question

        }else if(index == 7){
            this.choice1 = "Going down a group it increases; going towards the metals it decreases"
            this.choice2 ="Going down a group it decreases; going towards the metals it decreases"
            this.choice3= "Going down a group it decreases; going towards the metals it increases"
            this.correctAnswer ="Going down a group it increases; going towards the metals it increases"
            val question = "What is the trend of atomic radius in elements?"
            return question

        }else if(index == 8){
            this.choice1 = "Going down a group it increases; going towards the metals it decreases"
            this.choice2 ="Going down a group it increases; going towards the metals it increases"
            this.choice3= "Going down a group it decreases; going towards the metals it increases"
            this.correctAnswer ="Going down a group it decreases; going towards the metals it decreases"
            val question = "What is the trend of ionization energy in elements?"
            return question

        }else if(index == 9){
            this.choice1 = "Going down a group it decreases; going towards the metals it decreases"
            this.choice2 ="Going down a group it increases; going towards the metals it increases"
            this.choice3= "Going down a group it decreases; going towards the metals it increases"
            this.correctAnswer = "Going down a group it increases; going towards the metals it decreases"
            val question = "What is the trend of electronegativity in elements?"
            return question

        }else if(index == 10){
            this.choice1 = "They are tightly bound together and share electrons"
            this.choice2 ="They are unwilling to share electrons and are tightly bound together"
            this.choice3= "Because they have lots of valence electrons that they want to give away"
            this.correctAnswer =" Their willingness to share electrons and be loosely bound together"

            val question =" Why are metals so conductive?"
            return question
        }else if(index == 11){
            this.choice1 = " The number of electrons that are attracted to an atom."
            this.choice2 =" The power of the atom to repel electrons"
            this.choice3= " The energy released when electrons are added"
            this.correctAnswer ="The power of an atom in a molecule to attract electrons to itself"
            val question ="What is electronegativity?"
            return question
        }else if(index == 12){
            this.choice1 = "How much electrons like one another."
            this.choice2 ="The amount of energy to get rid of an electron."
            this.choice3= "The same as ionization energy."
            this.correctAnswer ="The amount of energy required to add a electron "
            val question ="What is Electron affinity?"
            return question
        }else if(index == 13){
            this.choice1 ="Energy that is lost when adding an electron"
            this.choice2 =" Energy that is stored within an atom"
            this.choice3= "Energy required to add an electron to a shell"
            this.correctAnswer =" Energy required to remove an electron from a shell"
            val question ="Ionization energy is ____ "
            return question
        }else if(index == 14){
            this.choice1 = "They have more energy stored inside each electron"
            this.choice2 ="They have less electrons in their outer shell"
            this.choice3= "They don’t follow the octet rule"
            this.correctAnswer ="They have more electrons in their outer shell "


            val question =" Why are anions larger than neutral atoms?"
            return question
        }else if(index == 15){
            this.choice1 = "They have less energy stored inside each electron"
            this.choice2 ="They have more electrons in their outer shell"
            this.choice3= " They don’t follow the octet rule"
            this.correctAnswer =" They have less electrons in their outer shell"
            val question ="  Why are cations smaller than neutral atoms?"
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
    fun addElementInfo(element: String, atomicradii: String , electroneg : String , atomicaffine: String){

        elementInfo.add(mutableListOf(element,atomicradii,electroneg,atomicaffine))
    }
}

package kz.example.quizapp.fragments.models

import com.google.gson.annotations.SerializedName

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 6/2/21
 */

class QuestionModel(
    @SerializedName("id")
    val id: Long,

    @SerializedName("question")
    val question: String,

    @SerializedName("answers")
    val answersModel: AnswersModel,

    @SerializedName("multiple_correct_answers")
    val isMultiple: Boolean,

    @SerializedName("correct_answers")
    val correctAnswersModel: CorrectAnswersModel,

    //TODO: показать как заменить с String
    @SerializedName("category")
    val category: String,

    @SerializedName("difficulty")
    val difficult: String
)
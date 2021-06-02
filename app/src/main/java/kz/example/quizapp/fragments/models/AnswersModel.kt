package kz.example.quizapp.fragments.models

import com.google.gson.annotations.SerializedName

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 6/2/21
 */

class AnswersModel(
    @SerializedName("answer_a")
    val answerA: String,

    @SerializedName("answer_b")
    val answerB: String,

    @SerializedName("answer_c")
    val answerC: String,

    @SerializedName("answer_d")
    val answerD: String,

    @SerializedName("answer_e")
    val answerE: String,

    @SerializedName("answer_f")
    val answerF: String
)
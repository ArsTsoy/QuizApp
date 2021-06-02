package kz.example.quizapp.fragments.models

import com.google.gson.annotations.SerializedName

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 6/2/21
 */

class CorrectAnswersModel(
    @SerializedName("answer_a_correct")
    val answerA: Boolean,

    @SerializedName("answer_b_correct")
    val answerB: Boolean,

    @SerializedName("answer_c_correct")
    val answerC: Boolean,

    @SerializedName("answer_d_correct")
    val answerD: Boolean,

    @SerializedName("answer_e_correct")
    val answerE: Boolean,

    @SerializedName("answer_f_correct")
    val answerF: Boolean
)
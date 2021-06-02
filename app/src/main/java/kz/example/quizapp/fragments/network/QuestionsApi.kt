package kz.example.quizapp.fragments.network

import kz.example.quizapp.fragments.models.QuestionModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 6/2/21
 */

interface QuestionsApi {

    //    https://quizapi.io/api/v1/questions?apiKey=jpjg23GBrydqTQ4q7oox2udIx9EJTHGvNO3w6Xnq&category=Linux
    // Получить список вопросов
    @GET("api/v1/questions")
    fun getQuestions(
        @Query("apiKey") apiKey: String,
        @Query("category") category: String,
    ) : List<QuestionModel>

}
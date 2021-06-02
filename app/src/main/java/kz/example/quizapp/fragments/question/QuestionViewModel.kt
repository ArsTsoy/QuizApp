package kz.example.quizapp.fragments.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kz.example.quizapp.fragments.models.QuestionModel
import kz.example.quizapp.fragments.network.API_KEY
import kz.example.quizapp.fragments.network.NetworkSetuper
import kz.example.quizapp.fragments.network.QuestionsApi

class QuestionViewModel : ViewModel() {

    //region Vars
    private var questionsApi: QuestionsApi = NetworkSetuper.questionApi
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val listOfQuestions = mutableListOf<QuestionModel>()
    private var currentQuestionPosition = 0
    //endregion

    //region LiveData

    private val currentQuestion: MutableLiveData<QuestionModel> = MutableLiveData() // State вопроса для отображения
    fun observeCurrentQuestion(): LiveData<QuestionModel> = currentQuestion

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData() // State загружается ли что-либо
    fun observeIsLoadingState(): LiveData<Boolean> = isLoading

    private val isAnswerCorrect: MutableLiveData<Boolean> = MutableLiveData()
    fun observeIsAnswerCorrect(): LiveData<Boolean> = isAnswerCorrect
    //endregion

    init {
        getQuestions()
    }

    fun onNextQuestionClicked() {
        if (currentQuestionPosition < listOfQuestions.size) {
            isAnswerCorrect.postValue(false)
            currentQuestion.postValue(listOfQuestions.get(currentQuestionPosition++))
        }
    }

    private fun getQuestions() {
        // TODO:
        isLoading.postValue(true)
        val disposable = Single
            .fromCallable {
                Thread.sleep(500L)
                questionsApi.getQuestions(API_KEY, "Linux")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                listOfQuestions.addAll(it)
                if (currentQuestionPosition < listOfQuestions.size) {
                    currentQuestion.postValue(listOfQuestions[currentQuestionPosition])
                    currentQuestionPosition++
                }
                isLoading.postValue(false)
            }, {
                isLoading.postValue(false)
            })

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}
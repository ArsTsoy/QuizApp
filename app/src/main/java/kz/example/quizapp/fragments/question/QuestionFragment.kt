package kz.example.quizapp.fragments.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kz.example.quizapp.R
import kz.example.quizapp.fragments.models.QuestionModel

class QuestionFragment : Fragment() {

    //region Vars
    private val viewModel: QuestionViewModel by viewModels()
    private lateinit var progressBar: ProgressBar
    private lateinit var tvQuestion: TextView
    private lateinit var btnNext: Button
    //endregion


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.question_fragment, container, false)
        progressBar = view.findViewById(R.id.progressBar)
        tvQuestion = view.findViewById(R.id.tvQuestions)
        btnNext = view.findViewById(R.id.btnNext)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observeIsLoadingState()
            .observe(this.viewLifecycleOwner, {
                if (it == true) {
                    progressBar.visibility = View.VISIBLE
                } else {
                    progressBar.visibility = View.GONE
                }
            })

        viewModel.observeCurrentQuestion().observe(this.viewLifecycleOwner, {
            tvQuestion.text = it.question


        })


        btnNext.setOnClickListener {

            viewModel.onNextQuestionClicked()
        }
    }


}
// Extension func example
//fun String.newMethod(): Boolean {
//    return this.length <= 10
//}
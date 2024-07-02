package com.example.navi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navi.databinding.FragmentGamePageBinding

class GamePageFragment: Fragment(R.layout.fragment_game_page) {
    private var binding: FragmentGamePageBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGamePageBinding.bind(view)
        val gameTitle = arguments?.getString(ARG_TITLE) ?: "ERROR"

        binding?.apply {
            tvTitle.text = "$gameTitle ${tvTitle.text}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_TITLE = "ARG_TITLE"
        fun bundle(gameTitle: String): Bundle = Bundle().apply {
            putString(ARG_TITLE, gameTitle)
        }
    }
}
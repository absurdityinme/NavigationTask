package com.example.navi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.navi.databinding.FragmentGameBinding

class GameFragment: Fragment(R.layout.fragment_game) {
    private var binding: FragmentGameBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)
        init()
    }

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    fun init() {
        val gameId = arguments?.getInt(ARG_ID) ?: "ERROR"
        binding?.run {
            val game = GameRepository.games.find { it.id == gameId }
            if (game != null) {
                Glide.with(root.context)
                    .load(game.url)
                    .error(R.drawable.baseline_error_24)
                    .placeholder(R.drawable.baseline_videogame_gray_asset_24)
                    .apply(requestOptions)
                    .into(ivImage)
                tvTitle.text = game.title
                tvPrice.text = "${game.price} p"
                tvDescLong.text = game.descriptionLong
                tvDescShort.text = game.descriptionShort
            }
            else {
                tvTitle.text = "N/A game"
                tvPrice.text = ""
                tvDescLong.text = ""
                tvDescShort.text = ""
            }

            btn.setOnClickListener() {
                findNavController().navigate(
                    resId = R.id.action_gameFragment_to_wishlistFragment
                    )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        fun bundle(gameId: Int): Bundle = Bundle().apply {
            putInt(ARG_ID, gameId)
        }
    }
}
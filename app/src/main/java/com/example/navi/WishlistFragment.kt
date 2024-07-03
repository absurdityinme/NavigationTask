package com.example.navi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.navi.databinding.FragmentWishlistBinding

class WishlistFragment: Fragment(R.layout.fragment_wishlist) {
    private var binding: FragmentWishlistBinding? = null
    private var adapter: GameAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWishlistBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        binding?.run {
            adapter = GameAdapter(
                list = GameRepository.games,
                onClick = {
                    findNavController().navigate(
                        resId = R.id.action_wishlistFragment_to_gameFragment,
                        args = GameFragment.bundle(
                            gameId = it.id
                        )
                    )
                }
            )
            rvGame.adapter = adapter
            rvGame.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
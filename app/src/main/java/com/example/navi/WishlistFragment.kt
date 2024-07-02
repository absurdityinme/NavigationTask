package com.example.navi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navi.databinding.FragmentWishlistBinding

class WishlistFragment: Fragment(R.layout.fragment_wishlist) {
    private var binding: FragmentWishlistBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWishlistBinding.bind(view)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
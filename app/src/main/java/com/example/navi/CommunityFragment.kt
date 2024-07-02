package com.example.navi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navi.databinding.FragmentCommunityBinding

class CommunityFragment: Fragment(R.layout.fragment_community) {
    private var binding: FragmentCommunityBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCommunityBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
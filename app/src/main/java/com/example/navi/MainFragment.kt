package com.example.navi

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navi.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.NullPointerException

class MainFragment: Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.apply {
            btnBuy.setOnClickListener() {
                if (!etTitle.text.isNullOrBlank()) {
                    findNavController().navigate(
                        resId = R.id.action_mainFragment_to_gamePageFragment,
                        args = GamePageFragment.bundle(
                            gameTitle = etTitle.text.toString()
                        )
                    )
                }
                else {
                    Snackbar.make(root, "To send a text, fill the field", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
package com.aliceresponde.mercadoco.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aliceresponde.mercadoco.R
import com.aliceresponde.mercadoco.databinding.ActivityIntroBinding

class IntroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = ActivityIntroBinding.inflate(inflater, container, false).apply {
            lottie.addAnimatorUpdateListener { valueAnimator ->
                val progress = (valueAnimator.animatedValue as Float * 100).toInt()
                if (progress == 99) {
                    findNavController().navigate(R.id.action_introFragment_to_searchItemsFragment)
                }
            }
        }
        return binding.root
    }
}
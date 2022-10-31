package com.adityaamolbavadekar.metube.ui.auth.welcome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.adityaamolbavadekar.metube.R
import com.adityaamolbavadekar.metube.databinding.AuthOnboardingFragmentBinding
import com.adityaamolbavadekar.metube.ui.MainActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class OnboardingFragment : Fragment() {

    private var _binding: AuthOnboardingFragmentBinding? = null
    private val binding: AuthOnboardingFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AuthOnboardingFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Firebase.auth.currentUser != null) {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
            return requireActivity().finish()
        }
        binding.login.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.container)
                .navigate(R.id.action_onboardingFragment_to_loginFragment)
        }
        binding.signup.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.container)
                .navigate(R.id.action_onboardingFragment_to_signUpFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
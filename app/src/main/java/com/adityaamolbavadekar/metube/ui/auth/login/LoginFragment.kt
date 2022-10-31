package com.adityaamolbavadekar.metube.ui.auth.login

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adityaamolbavadekar.metube.databinding.LoginFragmentBinding
import com.adityaamolbavadekar.metube.ui.MainActivity
import com.adityaamolbavadekar.metube.utils.FieldValidator
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {

    // TODO: 10/31/2022 Update user login activity.

    private var _binding: LoginFragmentBinding? = null
    private val binding: LoginFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.continueButton.setOnClickListener {
            val password = (binding.password.text.toString())
            val isPasswordValid = FieldValidator.password(password)

            val email = (binding.username.text.toString())
            val isEmailValid = FieldValidator.email(email)

            if (isPasswordValid && isEmailValid) {
                val progress = ProgressDialog(requireContext())
                progress.setMessage("Loading...")
                progress.create()
                progress.show()
                Firebase.auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        progress.dismiss()
                        startActivity(Intent(requireActivity(), MainActivity::class.java))
                        return@addOnSuccessListener requireActivity().finish()
                    }
                    .addOnFailureListener {
                        progress.dismiss()
                        return@addOnFailureListener MaterialAlertDialogBuilder(requireContext())
                            .setTitle("Something went wrong! [${it.javaClass.simpleName}]")
                            .setMessage(it.localizedMessage)
                            .setCancelable(true)
                            .setPositiveButton("Close") { d, _ ->
                                return@setPositiveButton d.cancel()
                            }
                            .create()
                            .show()
                    }
            } else {
                return@setOnClickListener MaterialAlertDialogBuilder(requireContext())
                    .setMessage("Something went wrong! Please try again.")
                    .setCancelable(true)
                    .setPositiveButton("Close") { d, _ ->
                        return@setPositiveButton d.cancel()
                    }
                    .create()
                    .show()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
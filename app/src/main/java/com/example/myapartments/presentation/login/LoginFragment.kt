package com.example.myapartments.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.myapartments.R
import com.example.myapartments.databinding.FragmentLoginBinding
import com.example.myapartments.domain.model.Login
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch { observableState() }
        binding.loginBtn.setOnClickListener { loginBtnClick() }
    }

    private fun loginBtnClick() {
        val nickName = binding.nickNameLayout.editText!!.text.toString()
        val password = binding.passwordLayout.editText!!.text.toString()
        val login = Login(nickName, password)
        viewModel.onEvent(LoginFragmentOnEvent.Login(login))
    }

    private suspend fun observableState() {
        viewModel.state.collect {
            binding.loinProgress.visibility = View.GONE
            when (it) {
                is LoginFragmentState.Idle -> {

                }

                is LoginFragmentState.Loading -> {
                    binding.loinProgress.visibility = View.VISIBLE
                }

                is LoginFragmentState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }

                is LoginFragmentState.CorrectPassword -> {
                    Navigation.findNavController(requireView()).navigate(R.id.mainFragment)
                }

                is LoginFragmentState.WrongPassword -> {
                    Toast.makeText(requireContext(), requireContext().getString(R.string.wrong_password), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
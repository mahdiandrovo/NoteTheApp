package com.drovo.notetheapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.drovo.notetheapp.R
import com.drovo.notetheapp.data.User
import com.drovo.notetheapp.data.UserViewModel
import com.drovo.notetheapp.databinding.FragmentAddBinding
import com.drovo.notetheapp.databinding.FragmentListBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding = FragmentAddBinding.inflate(inflater, container, false)
        binding.addBtn.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val firstName = binding.addFirstNameEt.text.toString()
        val lastName = binding.addLastNameEt.text.toString()
        val age = binding.addAgeEt.text

        if (inputCheck(firstName, lastName, age)){
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "successfully added", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(), "please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age:Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(age))
    }

}
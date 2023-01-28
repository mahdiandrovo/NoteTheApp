package com.drovo.notetheapp.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.drovo.notetheapp.R
import com.drovo.notetheapp.databinding.FragmentAddBinding
import com.drovo.notetheapp.databinding.FragmentListBinding
import com.drovo.notetheapp.databinding.FragmentUpdateBinding
import com.drovo.notetheapp.model.User
import com.drovo.notetheapp.viewmodel.UserViewModel


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    lateinit var binding: FragmentUpdateBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding = FragmentUpdateBinding.inflate(inflater, container, false)

        binding.updateFirstNameEt.setText(args.currentUser.firstName)
        binding.updateLastNameEt.setText(args.currentUser.lastName)
        binding.updateAgeEt.setText(args.currentUser.age.toString())

        binding.updateBtn.setOnClickListener {
            updateItem()
        }

        return binding.root
    }

    private fun updateItem() {
        val firstName = binding.updateFirstNameEt.text.toString()
        val lastName = binding.updateLastNameEt.text.toString()
        val age = binding.updateAgeEt.text.toString()

        if (inputCheck(firstName, lastName, age)){
            val updateUser = User(args.currentUser.id, firstName, lastName, Integer.parseInt(age))
            //update the user
            userViewModel.updateUser(updateUser)
            //navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(requireContext(), "successfully updated", Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(requireContext(), "please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean {
        return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(age))
    }

}
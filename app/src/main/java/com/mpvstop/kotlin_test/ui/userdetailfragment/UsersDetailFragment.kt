package com.mpvstop.kotlin_test.ui.userdetailfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mpvstop.kotlin_test.R
import com.mpvstop.kotlin_test.core.base.BaseFragment
import com.mpvstop.kotlin_test.ui.userdetailfragment.UsersDetailFragmentArgs.fromBundle

import com.mpvstop.kotlin_test.ui.usersfragment.UsersAdapater
import kotlinx.android.synthetic.main.fragment_passenger_detail.*
import javax.inject.Inject

class UsersDetailFragment : BaseFragment<UserDetailViewModel>() {

    private lateinit var viewModel: UserDetailViewModel

    @Inject
    lateinit var useradater: UsersAdapater

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_passenger_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        name.text=fromBundle(requireArguments()).userName
    }


    override fun getViewModel(): UserDetailViewModel {
        viewModel = ViewModelProviders.of(this, factory).get(UserDetailViewModel::class.java)
        return viewModel
    }
}
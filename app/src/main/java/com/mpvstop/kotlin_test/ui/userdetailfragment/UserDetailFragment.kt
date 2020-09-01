package com.mpvstop.kotlin_test.ui.userdetailfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mpvstop.kotlin_test.R
import com.mpvstop.kotlin_test.core.base.BaseFragment
import com.mpvstop.kotlin_test.ui.userfragment.UserAdapater
import com.mpvstop.kotlin_test.ui.userfragment.UserViewModel
import javax.inject.Inject

class UserDetailFragment : BaseFragment<UserViewModel>() {

    private lateinit var viewModel: UserViewModel
    @Inject
    lateinit var useradater: UserAdapater
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
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun getViewModel(): UserViewModel {
        TODO("Not yet implemented")
    }
}
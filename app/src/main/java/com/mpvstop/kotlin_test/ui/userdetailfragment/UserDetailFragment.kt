package com.mpvstop.kotlin_test.ui.userdetailfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mpvstop.kotlin_test.R
import com.mpvstop.kotlin_test.core.base.BaseFragment
import com.mpvstop.kotlin_test.ui.userdetailfragment.UserDetailFragmentArgs.fromBundle
import com.mpvstop.kotlin_test.ui.userdetailfragment.models.Data
import com.mpvstop.kotlin_test.ui.userdetailfragment.models.UserDetail
import com.mpvstop.kotlin_test.ui.userfragment.UserAdapater
import com.mpvstop.kotlin_test.utils.Resource
import com.mpvstop.kotlin_test.utils.Status
import kotlinx.android.synthetic.main.fragment_user_detail.*
import javax.inject.Inject

class UserDetailFragment : BaseFragment<UserDetailViewModel>() {

    private lateinit var viewModel: UserDetailViewModel

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        subscribeObservers()
    }

    private fun subscribeObservers() {
        // by live data adapter pattern
        viewModel.getUserDetail(fromBundle(requireArguments()).userId)
            .observe(viewLifecycleOwner, Observer {
                consumeResponseLiveData(it)
            })
    }

    private fun consumeResponseLiveData(response: Resource<UserDetail>) {
        when (response.status) {
            Status.LOADING -> showProgressDialog()
            Status.SUCCESS -> {
                hideProgressDialog()
                renderSuccessResponse(response.data)
            }
            Status.ERROR -> {
                hideProgressDialog()
                Toast.makeText(activity, response.message, Toast.LENGTH_SHORT).show()
            }
            else -> {
            }
        }
    }

    private fun renderSuccessResponse(response: UserDetail?) {
        response.let {
            response?.data?.let { it -> updateUi(it) }
        }
    }

    private fun updateUi(data: Data) {
        firstName.setText(data.firstName)
        lastName.setText(data.lastName)
        age.setText(data.age.toString())
        gender.setText(data.gender)
        country.setText(data.country)
    }

    override fun getViewModel(): UserDetailViewModel {
        viewModel = ViewModelProviders.of(this, factory).get(UserDetailViewModel::class.java)
        return viewModel
    }
}
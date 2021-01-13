package com.mpvstop.kotlin_test.ui.passengersfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpvstop.kotlin_test.R
import com.mpvstop.kotlin_test.core.base.BaseFragment
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengersResonse
import com.mpvstop.kotlin_test.utils.Resource
import com.mpvstop.kotlin_test.utils.Status
import kotlinx.android.synthetic.main.fragment_passengers.*
import javax.inject.Inject

class PassengersFragment : BaseFragment<PassengersViewModel>() {

    private lateinit var viewModel: PassengersViewModel

    @Inject
    lateinit var useradater: PassengersAdapater

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
        return inflater.inflate(R.layout.fragment_passengers, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        initRecylerView()
        getUsersList()
        tvReload.setOnClickListener {
            getUsersList()
        }
    }

    private fun getUsersList() {
        viewModel.getPassngers().observe(viewLifecycleOwner, Observer {
            consumeResponseLiveData(it)
        })

    }

    private fun consumeResponseLiveData(response: Resource<PassengersResonse>) {
        when (response.status) {
            Status.LOADING -> layoutVisibilities(GONE, VISIBLE, GONE)
            Status.SUCCESS -> {
                layoutVisibilities(VISIBLE, GONE, GONE)
                renderSuccessResponse(response.data)
            }
            Status.ERROR -> {
                layoutVisibilities(GONE, VISIBLE, VISIBLE)
                tvErrorMessage.setText(response.message)
            }
            else -> {
            }
        }
    }

    private fun renderSuccessResponse(response: PassengersResonse?) {
        response.let {
            response?.data?.let { it -> useradater.setUserList(it) }
        }
    }

    private fun layoutVisibilities(
        rvUserVibility: Int,
        tvErrorMessageVisibility: Int,
        tvReloadVisibility: Int
    ) {
        rvUsers.visibility = rvUserVibility
        tvErrorMessage.visibility = tvErrorMessageVisibility
        tvReload.visibility = tvReloadVisibility
    }

    private fun initRecylerView() {
        rvUsers?.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvUsers.setAdapter(useradater)
    }


    override fun getViewModel(): PassengersViewModel {
        viewModel = ViewModelProviders.of(this, factory).get(PassengersViewModel::class.java)
        return viewModel
    }
}
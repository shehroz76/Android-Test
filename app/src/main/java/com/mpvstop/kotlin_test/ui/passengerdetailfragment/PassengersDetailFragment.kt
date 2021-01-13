package com.mpvstop.kotlin_test.ui.passengerdetailfragment

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
import com.mpvstop.kotlin_test.ui.passengerdetailfragment.PassengersDetailFragmentArgs.fromBundle
import com.mpvstop.kotlin_test.ui.passengersfragment.PassengersAdapater
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengerItem
import com.mpvstop.kotlin_test.utils.Resource
import com.mpvstop.kotlin_test.utils.Status
import kotlinx.android.synthetic.main.fragment_passenger_detail.*
import javax.inject.Inject

class PassengersDetailFragment : BaseFragment<PassengerDetailViewModel>() {

    private lateinit var viewModel: PassengerDetailViewModel

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
        return inflater.inflate(R.layout.fragment_passenger_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getPassengerById(fromBundle(requireArguments()).passengerId)
            .observe(viewLifecycleOwner, Observer {
                consumeResponseLiveData(it)
            })
    }

    private fun consumeResponseLiveData(response: Resource<PassengerItem>) {
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

    private fun renderSuccessResponse(response: PassengerItem?) {
        response.let {
            updateUi(it)
        }
    }

    private fun updateUi(data: PassengerItem?) {
        name.setText(data?.name)
        flight.setText(data?.airline?.name)
    }

    override fun getViewModel(): PassengerDetailViewModel {
        viewModel = ViewModelProviders.of(this, factory).get(PassengerDetailViewModel::class.java)
        return viewModel
    }
}
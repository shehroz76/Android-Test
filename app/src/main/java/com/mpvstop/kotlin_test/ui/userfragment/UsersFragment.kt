package com.mpvstop.kotlin_test.ui.userfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpvstop.kotlin_test.R
import com.mpvstop.kotlin_test.core.base.BaseFragment
import com.mpvstop.kotlin_test.ui.userfragment.models.Users
import com.mpvstop.kotlin_test.utils.Resource
import com.mpvstop.kotlin_test.utils.Status
import kotlinx.android.synthetic.main.fragment_users.*
import javax.inject.Inject

class UsersFragment : BaseFragment<UserViewModel>() {

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
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       initViews()
    }

    private fun initViews() {
        initRecylerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        // by live data adapter pattern
        viewModel.getUsers().observe(viewLifecycleOwner, Observer {
            consumeResponseLiveData(it)
        })
    }

    private fun consumeResponseLiveData(response: Resource<Users>) {
        when (response.status) {
            Status.LOADING -> showProgressDialog()
            Status.SUCCESS -> {
                hideProgressDialog()
                renderSuccessResponse(response.data)
            }
            Status.ERROR -> {
                hideProgressDialog()
                Toast.makeText(activity, "nertwork error", Toast.LENGTH_SHORT).show()
            }
            else -> {
            }
        }
    }

    private fun renderSuccessResponse(response: Users?) {
        response.let {
                response?.data?.let { it -> useradater.setUserList(it) }
        }
    }

    private fun initRecylerView() {
        rvUsers?.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvUsers.setAdapter(useradater)
    }

    fun navigateToUserDetail(id:String){
//        Navigation.findNavController(requireView())
//            .navigate(
//                UsersFragmentDirections.actionUserDetailFragment(
//                    id
//                )
//            )
    }

    override fun getViewModel(): UserViewModel {
        viewModel = ViewModelProviders.of(this, factory).get(UserViewModel::class.java)
        return viewModel
    }
}
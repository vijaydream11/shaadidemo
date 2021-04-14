package com.shaadidemo.view.activity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.shaadidemo.R
import com.shaadidemo.view.adapter.UserListAdapter
import com.shaadidemo.view.viewmodel.UserListViewModel
import com.shaadi.assignment.data.local.db.entity.InboxUser
import com.shaadi.assignment.data.local.db.typeconverters.UserStatus
import kotlinx.android.synthetic.main.activity_user_list.*

class UserListActivity : BaseActivity(), UserListAdapter.IUpdateStatusHandler {

    private lateinit var viewModel: UserListViewModel
    private var userListAdapter: UserListAdapter? = null

    override val layoutId: Int
        get() = R.layout.activity_user_list

    override fun init() {
        viewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)

        initLoader(resources.getString(R.string.loading), "", false)
        viewModel.userLiveData.observe(this, Observer {
            finishLoader()
            it?.let {
                userListAdapter = UserListAdapter(this, it as ArrayList<InboxUser>, this)
                rvUserData.adapter = userListAdapter
            }
        })
        viewModel.getUserList()
    }

    override fun updateStatus(userStatus: UserStatus, id: Long) {
        viewModel.updateUserStatus(userStatus, id)
    }

}

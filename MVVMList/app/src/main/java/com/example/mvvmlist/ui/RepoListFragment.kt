package com.example.mvvmlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mvvmlist.databinding.FragmentRepoListBinding
import com.example.mvvmlist.ui.adapter.RepoListAdapter
import com.example.mvvmlist.viewmodel.RepoListViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/*class RepoListFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentRepoListBinding
    private lateinit var adapter: RepoListAdapter
    private val repoListViewModel: RepoListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {
            viewmodel =
                ViewModelProviders.of(this@RepoListFragment).get(RepoListViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()
        view.setOnClickListener {

        }
        setupAdapter()
        setObservers()
    }

    private fun setObservers() {
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = RepoListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            repo_list_rv.adapter = adapter
        }
    }
}

 */
class RepoListFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentRepoListBinding
    private lateinit var adapter: RepoListAdapter
    private val repoListViewModel: RepoListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        viewDataBinding.viewmodel = repoListViewModel
        return viewDataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()
        setupAdapter()
        setObservers()
    }


    private fun setObservers() {
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = RepoListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            repo_list_rv.adapter = adapter
        }
    }


}
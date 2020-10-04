package com.example.mvvmlist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlist.data.model.ApiResponse
import com.example.mvvmlist.databinding.ViewRepoListItemBinding
import com.example.mvvmlist.ui.adapter.viewholder.RepoListViewHolder
import com.example.mvvmlist.viewmodel.RepoListViewModel


class RepoListAdapter(
    private val repoListViewModel: RepoListViewModel
) :
    RecyclerView.Adapter<RepoListViewHolder>() {
    var repoList: List<ApiResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewRepoListItemBinding.inflate(inflater, parent, false)
        return RepoListViewHolder(dataBinding)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.setup(repoList[position])
    }

    fun updateRepoList(repoList: List<ApiResponse>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }

}
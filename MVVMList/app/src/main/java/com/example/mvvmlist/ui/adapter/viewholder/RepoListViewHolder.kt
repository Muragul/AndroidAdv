package com.example.mvvmlist.ui.adapter.viewholder

import androidx.databinding.ViewDataBinding
import com.example.mvvmlist.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlist.data.model.ApiResponse
import com.example.mvvmlist.viewmodel.RepoListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_repo_list_item.view.*

class RepoListViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val repoListViewModel: RepoListViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.item_avatar
    fun setup(itemData: ApiResponse) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.thumbnailUrl).into(avatarImage);
    }
}
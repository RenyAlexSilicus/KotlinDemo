package com.fhs.core

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: Abstract Class
 * This class can be used with RecyclerView , to make pagination possible.
 */
abstract class PaginationListener(linearLayoutManager: LinearLayoutManager): RecyclerView.OnScrollListener() {

    private var manager: LinearLayoutManager = linearLayoutManager

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = manager.childCount
        val totalItemCount = manager.itemCount
        val firstVisibleItemPosition = manager.findFirstCompletelyVisibleItemPosition()

        if (!isLoading() && !isLastPage()){

            val temp = visibleItemCount + firstVisibleItemPosition
            if (temp >= totalItemCount && firstVisibleItemPosition >= 0){
                loadMoreItems()
            }
        }
    }

    protected abstract fun loadMoreItems()

    abstract fun getTotalPageCount() : Int

    abstract fun isLastPage(): Boolean

    abstract fun isLoading(): Boolean

}
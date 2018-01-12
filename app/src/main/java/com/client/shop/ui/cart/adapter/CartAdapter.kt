package com.client.shop.ui.cart.adapter

import android.content.Context
import android.view.View
import com.ui.base.recycler.OnItemClickListener
import com.ui.base.recycler.adapter.BaseRecyclerAdapter
import com.client.shop.ui.item.cart.CartItem
import com.domain.entity.CartProduct
import com.domain.formatter.NumberFormatter

class CartAdapter(dataList: List<CartProduct>, onItemClickListener: OnItemClickListener) :
        BaseRecyclerAdapter<CartProduct>(dataList, onItemClickListener) {

    var actionListener: CartItem.ActionListener? = null
    private val formatter = NumberFormatter()

    override fun bindData(itemView: View, data: CartProduct, position: Int) {
        if (itemView is CartItem) {
            itemView.setCartProduct(data)
            itemView.actionListener = actionListener
        }
    }

    override fun getItemView(context: Context, viewType: Int): View {
        return CartItem(context, formatter)
    }

    override fun getItemId(position: Int): Long {
        return if (dataList.size > position) {
            dataList[position].productVariant.id.hashCode().toLong()
        } else {
            -1
        }
    }
}
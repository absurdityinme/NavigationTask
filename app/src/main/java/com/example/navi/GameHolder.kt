package com.example.navi

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.navi.databinding.ItemGameBinding

class GameHolder(
    private val binding: ItemGameBinding,
    private val onClick: (Game) -> Unit,
): ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(game: Game) {
        binding.run {
            tvTitle.text = game.title
            tvPrice.text = "${game.price} p"
            Glide.with(root.context)
                .load(game.url)
                .error(R.drawable.baseline_error_24)
                .placeholder(R.drawable.baseline_videogame_gray_asset_24)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(game)
            }
        }
    }
}
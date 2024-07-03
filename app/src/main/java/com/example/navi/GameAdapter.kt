package com.example.navi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.navi.databinding.ItemGameBinding

class GameAdapter(
    private var list: List<Game>,
    private val onClick: (Game) -> Unit,
): RecyclerView.Adapter<GameHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): GameHolder = GameHolder(
        binding = ItemGameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onClick = onClick
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.onBind(list[position])
    }

}
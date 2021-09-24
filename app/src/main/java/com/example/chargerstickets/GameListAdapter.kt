package com.example.chargerstickets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chargerstickets.data.entities.Game
import com.example.chargerstickets.databinding.ItemGameBinding

class GameListAdapter(private val onGameClicked: (Game) -> Unit) :
    ListAdapter<Game, GameListAdapter.GameViewHolder>(DiffCallback)
{
    class GameViewHolder(private var binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setVisibility(byeWeek: Boolean){
            binding.apply {
                if(byeWeek){
                    byeLogo.visibility = View.VISIBLE
                    txtBye.visibility = View.VISIBLE
                    gameTeamAtTeam.visibility = View.GONE
                    gameTime.visibility = View.GONE
                    gamePlace.visibility = View.GONE
                    gameAwayTeam.visibility = View.GONE
                    gameHomeTeam.visibility = View.GONE
                } else{
                    byeLogo.visibility = View.GONE
                    txtBye.visibility = View.GONE
                    gameTeamAtTeam.visibility = View.VISIBLE
                    gameTime.visibility = View.VISIBLE
                    gamePlace.visibility = View.VISIBLE
                    gameAwayTeam.visibility = View.VISIBLE
                    gameHomeTeam.visibility = View.VISIBLE
                }
            }
        }


        fun bind(game: Game, onGameClicked: (Game) -> Unit) {
            binding.apply {
                root.setOnClickListener { if (!game.bye) onGameClicked(game) }

                gameHeading.text = root.resources.getString(
                    R.string.game_heading, game.gameId, game.date
                )
                if(game.bye){
                    setVisibility(true)
                }
                else {
                    setVisibility(false)
                    gameTeamAtTeam.text = root.resources.getString(
                        R.string.team_at_team, game.awayTeam, game.homeTeam
                    )
                    gameTime.text = game.time
                    gamePlace.text = game.stadium
                    gameAwayTeam.setImageDrawable(ResourcesCompat.getDrawable(root.resources,
                        logoMap[game.awayTeam]!!, null))
                    gameHomeTeam.setImageDrawable(ResourcesCompat.getDrawable(root.resources,
                        logoMap[game.homeTeam]!!, null))
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val currentGame = getItem(position)
        holder.bind(currentGame, onGameClicked)
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Game>() {
            override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
                return oldItem.gameId == newItem.gameId
            }

            override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
                return oldItem == newItem
            }
        }
    }

}
package dev.jmsaez.projectapi.view.leaderboard_viewholder

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import dev.jmsaez.projectapi.R
import dev.jmsaez.projectapi.model.entity.Leaderboard

class LeaderboardViewholder(itemView: View, recycler:RecyclerView) : RecyclerView.ViewHolder(itemView) {

    var rank:TextView = itemView.findViewById(R.id.tvPosition)
    var user:TextView = itemView.findViewById(R.id.tvPlayerName)
    var originalUser:TextView = itemView.findViewById(R.id.tvOriginalUsername)
    var level:TextView = itemView.findViewById(R.id.tvLevel)
    var kd:TextView = itemView.findViewById(R.id.tvKD)
    var accuracy:TextView = itemView.findViewById(R.id.tvAccu)
    var wins:TextView = itemView.findViewById(R.id.tvWins)
    var gamesPlayed:TextView = itemView.findViewById(R.id.tvGamesPlayed)
    var hours:TextView = itemView.findViewById(R.id.tvTimePlayed)
    var entry: Leaderboard.Entries? = null
    var expand: ImageButton = itemView.findViewById(R.id.btExpand)
    var rv:RecyclerView = recycler
    var expandLy = itemView.findViewById<View>(R.id.layoutExpand)

    init {
        expand.setOnClickListener {

            if (!expandLy.isVisible)
            {
                TransitionManager.beginDelayedTransition(rv, AutoTransition())
                expandLy.visibility = View.VISIBLE
                expand.setImageResource(R.drawable.ic_baseline_expand_less_24)
            }
            else
            {
                TransitionManager.beginDelayedTransition(rv, AutoTransition())
                expandLy.visibility = View.GONE
                expand.setImageResource(R.drawable.ic_baseline_expand_more_24)
            }
        }
    }
}
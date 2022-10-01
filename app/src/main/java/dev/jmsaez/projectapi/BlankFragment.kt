package dev.jmsaez.projectapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dev.jmsaez.projectapi.databinding.FragmentBlankBinding
import dev.jmsaez.projectapi.model.entity.Player
import dev.jmsaez.projectapi.viewmodel.PlayerViewModel
import kotlin.Exception


class BlankFragment : Fragment() {

    lateinit var player:String
    lateinit var platform: String
    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle = arguments
        player = bundle!!.getString("player")!!
        platform = bundle!!.getString("platform")!!
        Log.d("::>", player!!.toString())
        try {
            //putOnScreen(player)
            observePlayer(player, platform)
        } catch (e:Exception){
            //Not found player screen or drawable
            binding.ivPlayer.setImageResource(R.drawable.ic_launcher_background)
        }

    }
    private fun putOnScreen(player:Player){
        try {
            binding.tvPlayerName.append(": " + player.username)
            binding.tvPlayerLevel.append(": " + player.level.toString())
            binding.tvHours.append(": " + player.lifetime.all.properties.timePlayedTotal)
            binding.tvTotalGames.append(": " + player.lifetime.all.properties.gamesPlayed)
            binding.tvKd.append(": " + player.lifetime.all.properties.kdRatio)
            binding.tvBestkd.append(": " + player.lifetime.all.properties.bestKD)
            binding.tvKillstreak.append(": " + player.lifetime.all.properties.bestKillStreak)
            binding.tvAccuracy.append(": " + player.lifetime.all.properties.accuracy)
            binding.tvHeadshot.append(": " + (player.lifetime.all.properties.totalShots / player.lifetime.all.properties.headshots))
            binding.tvSpM.append(": " + player.lifetime.all.properties.scorePerMinute)
            binding.tvSpG.append(": " + player.lifetime.all.properties.scorePerGame)
            binding.tvWins.append(": " + player.lifetime.all.properties.wins)
            binding.tvTies.append(": " + player.lifetime.all.properties.ties)
            binding.tvLosses.append(": " + player.lifetime.all.properties.losses)
        } catch(ex: Exception){
            binding.ivPlayer.setImageResource(R.drawable.ic_launcher_background)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observePlayer(player:String, platform:String){
        var pvm = ViewModelProvider(this).get(PlayerViewModel::class.java)
        pvm.getPlayer(player, platform)
        var liveData = pvm.getPlayerLiveData()
        liveData?.observe(this.viewLifecycleOwner) {
            //Log.d(":::LIVEDATA", it.toString())
            //var bundle = Bundle();
            //bundle.putParcelable("player", it)
            //findNavController().navigate(R.id.action_SecondFragment_to_blankFragment, bundle)
            putOnScreen(it)
        }
    }
}
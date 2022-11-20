package dev.jmsaez.projectapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.jmsaez.projectapi.model.entity.Leaderboard
import dev.jmsaez.projectapi.view.leaderboard_adapter.LeaderboardAdapter
import dev.jmsaez.projectapi.viewmodel.LeaderboardViewModel
import dev.jmsaez.projectapi.viewmodel.PlayerViewModel

lateinit var leaderboard:MutableLiveData<Leaderboard>;


class LeaderboardFragment : Fragment() {

    lateinit var lvm: LeaderboardViewModel
    lateinit var rvLeaderboard: RecyclerView
    lateinit var leaderboardAdapter: LeaderboardAdapter
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leaderboard, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvLeaderboard = view.findViewById(R.id.rvLeaderboard)
        rvLeaderboard.layoutManager = LinearLayoutManager(view.context)
        lvm = ViewModelProvider(requireActivity()).get(LeaderboardViewModel::class.java)

        progressBar = view.findViewById(R.id.progressBar2)

        leaderboardAdapter = LeaderboardAdapter(view.context, rvLeaderboard)
        rvLeaderboard.adapter = leaderboardAdapter


        lvm.getLeaderboard("battle")
        var liveData = lvm.getLeaderborardLiveData()
        liveData?.observe(this.viewLifecycleOwner) {
            Log.d("::::LEADERTEST", it!!.toString())
            leaderboardAdapter.setEntriesList(it.entries)
            progressBar.visibility = View.GONE
            rvLeaderboard.visibility = View.VISIBLE

        }
    }
}
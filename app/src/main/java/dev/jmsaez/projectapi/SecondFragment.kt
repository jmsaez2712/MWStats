package dev.jmsaez.projectapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dev.jmsaez.projectapi.databinding.FragmentSecondBinding
import dev.jmsaez.projectapi.viewmodel.PlayerViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var player:String
    private lateinit var platform: String

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val platforms = resources.getStringArray(R.array.platforms)
        var arrayAdapter = ArrayAdapter(this.requireContext(), R.layout.dropdown_item, platforms)
        binding.tvDropdownItem.setAdapter(arrayAdapter)

        binding.btSearch.setOnClickListener{
            player = binding.itSearch.text.toString()
            platform = binding.dropdownPlatform.editText?.text.toString()
            Log.d(":::player", player)
            Log.d(":::platform", platform)
            observePlayer(player, platform)
        }


    }

    private fun observePlayer(player:String, platform:String){
        var pvm = ViewModelProvider(this).get(PlayerViewModel::class.java)
        pvm.getPlayer(player, platform)
        var liveData = pvm.getPlayerLiveData()
        liveData?.observe(viewLifecycleOwner) {
            Log.d(":::LIVEDATA", it.toString())
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
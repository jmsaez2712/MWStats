package dev.jmsaez.projectapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.jmsaez.projectapi.databinding.FragmentFirstBinding
import dev.jmsaez.projectapi.model.api.RestClient
import dev.jmsaez.projectapi.model.entity.Player
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardPlayer.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

//        var okHttpClient = OkHttpClient
//
//        var request = Request.Builder()
//            .url("https://call-of-duty-modern-warfare.p.rapidapi.com/battle/Amartin743")
//            .build()
//
//        try (var response = okHttpClient){
//
//        }



//        var retrofit = Retrofit.Builder()
//            .baseUrl("https://call-of-duty-modern-warfare.p.rapidapi.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()



//        var client = retrofit.create(RestClient::class.java)
//        var player: Call<Player> = client.getFullPlayer("Amartin743", "psn")
//        player.enqueue(object: Callback<Player>{
//            override fun onResponse(call: Call<Player>, response: Response<Player>) {
//                Log.v(":::XXX", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<Player>, t: Throwable) {
//                Log.v(":::XXX", t.toString())
//            }
//        })

        }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
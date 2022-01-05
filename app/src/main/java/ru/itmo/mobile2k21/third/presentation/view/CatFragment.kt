package ru.itmo.mobile2k21.third.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.itmo.mobile2k21.ItmoMobileApplication
import ru.itmo.mobile2k21.R


class CatFragment: Fragment() {
    private val catViewModel: CatViewModel by viewModels {
        CatViewModel.CatViewModelFactory(
            ((requireActivity().application) as ItmoMobileApplication).getRandomCatUseCase,
            ((requireActivity().application) as ItmoMobileApplication).catDataMapper
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ThirdTask", "OnCreateCat")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("ThirdTask", "onCreateViewCat")
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loadCatButton: Button = view.findViewById(R.id.load_cat_button)
        loadCatButton.setOnClickListener {
            catViewModel.loadRandomCat()
        }

        val catImage: ImageView = view.findViewById(R.id.cat_image)
        val catTitle: TextView = view.findViewById(R.id.cat_id_label)
        catViewModel.cat.observe(viewLifecycleOwner, { cat ->
            catTitle.text = cat.id.toString()
        })

        catViewModel.error.observe(viewLifecycleOwner, {
            Toast.makeText(
                requireContext(),
                getString(R.string.error_occured_text, it),
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}
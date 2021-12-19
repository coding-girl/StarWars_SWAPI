package com.example.rickandmorty.ui.characterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.databinding.CharacterDetailFragmentBinding
import com.example.rickandmorty.utils.Resource
import com.example.rickandmorty.utils.Utils
import com.example.rickandmorty.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private var binding: CharacterDetailFragmentBinding by autoCleared()
    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.character.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindCharacter(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.characterCl.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.characterCl.visibility = View.GONE
                }
            }
        })
    }



    private fun bindCharacter(character: Character) {
        binding.name.text = character.name
        binding.year.text = character.birth_year
        binding.eye.text = character.eye_color
        binding.gender.text = character.gender
        binding.height.text = character.height
        binding.mass.text = character.mass
        binding.hair.text = character.hair_color
        binding.skin.text = character.skin_color
      //  binding.films.text =  character.films!!.joinToString { x -> films[x[x.length - 2] - '1'] }

        Glide.with(binding.root)
            .load(Utils.getImagePeople(character.url!!))
            .transform(CircleCrop())
            .into(binding.image)
    }
}

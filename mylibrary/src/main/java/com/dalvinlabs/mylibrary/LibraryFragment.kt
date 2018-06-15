package com.dalvinlabs.mylibrary

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dalvinlabs.mylibrary.databinding.FragmentLibraryBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class LibraryFragment : Fragment() {

  @Inject lateinit var libraryResource: LibraryResource

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = FragmentLibraryBinding.inflate(inflater)
    binding.libraryResource = libraryResource.name
    return binding.root
  }

  override fun onAttach(context: Context?) {
    AndroidInjection.inject(this)
    super.onAttach(context)
  }

  companion object {
    @JvmStatic fun newInstance() = LibraryFragment()
  }

}

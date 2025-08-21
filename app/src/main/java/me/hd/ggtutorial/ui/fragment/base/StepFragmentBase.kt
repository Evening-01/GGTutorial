package me.hd.ggtutorial.ui.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class StepFragmentBase<VB : ViewBinding>(
    inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : FragmentBase<VB>(inflate) {
    protected abstract fun updateUiView()
    protected abstract fun initListener()
    protected abstract fun createdOrDestroy(isCreated: Boolean)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createdOrDestroy(true)
        updateUiView()
        initListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        createdOrDestroy(false)
    }
}
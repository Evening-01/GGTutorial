package me.hd.ggtutorial.ui.fragment.step.practical

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepPractical2Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

class StepPractical2 : StepFragmentBase<FragmentStepPractical2Binding>(
    FragmentStepPractical2Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun pos(): Float
    private external fun left()
    private external fun right()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepPractical2TvPos.text = getString(R.string.step_practical2_pos, pos())
    }

    override fun initListener() {
        updateUiView()
        binding.stepPractical2BtnLeft.setOnClickListener {
            left()
            updateUiView()
        }
        binding.stepPractical2BtnRight.setOnClickListener {
            right()
            updateUiView()
        }
        binding.stepPractical2BtnNext.setOnClickListener {
            updateUiView()
            if (success()) {
                AlertUtil.success(it.context, { findNavController().popBackStack() })
            } else {
                AlertUtil.failure(it.context)
            }
        }
    }

    override fun createdOrDestroy(isCreated: Boolean) {
        dataLoad(isCreated)
    }
}
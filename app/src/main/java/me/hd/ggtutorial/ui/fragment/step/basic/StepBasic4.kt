package me.hd.ggtutorial.ui.fragment.step.basic

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepBasic4Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

//加密搜索
class StepBasic4 : StepFragmentBase<FragmentStepBasic4Binding>(
    FragmentStepBasic4Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun show(): Int
    private external fun add()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepBasic4TvShow.text = getString(R.string.step_basic4_show, show())
    }

    override fun initListener() {
        updateUiView()
        binding.stepBasic4BtnAdd.setOnClickListener {
            add()
            updateUiView()
        }
        binding.stepBasic4BtnNext.setOnClickListener {
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
package me.hd.ggtutorial.ui.fragment.step.basic

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepBasic7Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

//文本搜索
class StepBasic7 : StepFragmentBase<FragmentStepBasic7Binding>(
    FragmentStepBasic7Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun user(): String
    private external fun switch()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepBasic7TvUser.text = getString(R.string.step_basic7_user, user())
    }

    override fun initListener() {
        updateUiView()
        binding.stepBasic7BtnSwitch.setOnClickListener {
            switch()
            updateUiView()
        }
        binding.stepBasic7BtnNext.setOnClickListener {
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
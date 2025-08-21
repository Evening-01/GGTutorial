package me.hd.ggtutorial.ui.fragment.step.basic

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepBasic8Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

//异或搜索
class StepBasic8 : StepFragmentBase<FragmentStepBasic8Binding>(
    FragmentStepBasic8Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun num(): Int
    private external fun change()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepBasic8TvNum.text = getString(R.string.step_basic8_num, num())
    }

    override fun initListener() {
        updateUiView()
        binding.stepBasic8BtnChange.setOnClickListener {
            change()
            updateUiView()
        }
        binding.stepBasic8BtnNext.setOnClickListener {
            updateUiView()
            if (success()) {
                AlertUtil.success(it.context, { findNavController().popBackStack() })
            } else {
                AlertUtil.failure(it.context)
            }
        }
    }

    override fun createdOrDestroy(isCreated: Boolean) {
        dataLoad(true)
    }
}
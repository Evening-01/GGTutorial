package me.hd.ggtutorial.ui.fragment.step.basic

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.databinding.FragmentStepBasic3Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

//范围搜索
class StepBasic3 : StepFragmentBase<FragmentStepBasic3Binding>(
    FragmentStepBasic3Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun hp(): Int
    private external fun attack()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepBasic3ProBarHp.progress = hp()
    }

    override fun initListener() {
        updateUiView()
        binding.stepBasic3BtnAttack.setOnClickListener {
            attack()
            updateUiView()
        }
        binding.stepBasic3BtnNext.setOnClickListener {
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
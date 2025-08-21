package me.hd.ggtutorial.ui.fragment.step.basic

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.databinding.FragmentStepBasic5Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

//模糊搜索
class StepBasic5 : StepFragmentBase<FragmentStepBasic5Binding>(
    FragmentStepBasic5Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun hp(): Int
    private external fun attack()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepBasic5ProBarHp.progress = hp()
    }

    override fun initListener() {
        updateUiView()
        binding.stepBasic5BtnAttack.setOnClickListener {
            attack()
            updateUiView()
        }
        binding.stepBasic5BtnNext.setOnClickListener {
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
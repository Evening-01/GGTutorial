package me.hd.ggtutorial.ui.fragment.step.basic

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepBasic2Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

//联合搜索
class StepBasic2 : StepFragmentBase<FragmentStepBasic2Binding>(
    FragmentStepBasic2Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun hpMpArray(): IntArray
    private external fun skill()
    private external fun success(): Boolean

    override fun updateUiView() {
        val hpMpArray = hpMpArray()
        binding.stepBasic2TvPlayer.text = getString(
            R.string.step_basic2_player,
            hpMpArray[0], hpMpArray[1]
        )
    }

    override fun initListener() {
        updateUiView()
        binding.stepBasic2BtnSkill.setOnClickListener {
            skill()
            updateUiView()
        }
        binding.stepBasic2BtnNext.setOnClickListener {
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
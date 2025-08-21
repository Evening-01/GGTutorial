package me.hd.ggtutorial.ui.fragment.step.basic

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepBasic6Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

//增量填充
class StepBasic6 : StepFragmentBase<FragmentStepBasic6Binding>(
    FragmentStepBasic6Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun skillArray(): IntArray
    private external fun upgrade()
    private external fun success(): Boolean

    override fun updateUiView() {
        val skillArray = skillArray()
        binding.stepBasic6TvSkill.text = getString(
            R.string.step_basic6_skill,
            skillArray[0], skillArray[1], skillArray[2], skillArray[3]
        )
    }

    override fun initListener() {
        updateUiView()
        binding.stepBasic6BtnUpgrade.setOnClickListener {
            upgrade()
            updateUiView()
        }
        binding.stepBasic6BtnNext.setOnClickListener {
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
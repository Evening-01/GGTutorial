package me.hd.ggtutorial.ui.fragment.step.basic

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepBasic1Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

//精确搜索
class StepBasic1 : StepFragmentBase<FragmentStepBasic1Binding>(
    FragmentStepBasic1Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun bullet(): Int
    private external fun shoot()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepBasic1TvBullet.text = getString(R.string.step_basic1_bullet, bullet())
    }

    override fun initListener() {
        updateUiView()
        binding.stepBasic1BtnShoot.setOnClickListener {
            shoot()
            updateUiView()
        }
        binding.stepBasic1BtnNext.setOnClickListener {
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
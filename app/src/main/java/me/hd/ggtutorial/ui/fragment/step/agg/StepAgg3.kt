package me.hd.ggtutorial.ui.fragment.step.agg

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepAgg3Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

class StepAgg3 : StepFragmentBase<FragmentStepAgg3Binding>(
    FragmentStepAgg3Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun bullet(): Int
    private external fun shoot()
    private external fun replenish()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepAgg3TvBullet.text = getString(R.string.step_agg3_bullet, bullet())
    }

    override fun initListener() {
        binding.stepAgg3BtnShoot.setOnClickListener {
            shoot()
            updateUiView()
        }
        binding.stepAgg3BtnReplenish.setOnClickListener {
            replenish()
            updateUiView()
        }
        binding.stepAgg3BtnNext.setOnClickListener {
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
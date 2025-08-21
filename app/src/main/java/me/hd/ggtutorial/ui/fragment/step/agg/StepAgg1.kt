package me.hd.ggtutorial.ui.fragment.step.agg

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepAgg1Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

class StepAgg1 : StepFragmentBase<FragmentStepAgg1Binding>(
    FragmentStepAgg1Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun bullet(): Int
    private external fun shoot()
    private external fun replenish()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepAgg1TvBullet.text = getString(R.string.step_agg1_bullet, bullet())
    }

    override fun initListener() {
        binding.stepAgg1BtnShoot.setOnClickListener {
            shoot()
            updateUiView()
        }
        binding.stepAgg1BtnReplenish.setOnClickListener {
            replenish()
            updateUiView()
        }
        binding.stepAgg1BtnNext.setOnClickListener {
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
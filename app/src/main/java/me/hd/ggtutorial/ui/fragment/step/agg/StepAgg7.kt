package me.hd.ggtutorial.ui.fragment.step.agg

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepAgg7Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

class StepAgg7 : StepFragmentBase<FragmentStepAgg7Binding>(
    FragmentStepAgg7Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun bullet(): Int
    private external fun shoot()
    private external fun replenish()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepAgg7TvBullet.text = getString(R.string.step_agg7_bullet, bullet())
    }

    override fun initListener() {
        binding.stepAgg7BtnShoot.setOnClickListener {
            shoot()
            updateUiView()
        }
        binding.stepAgg7BtnReplenish.setOnClickListener {
            replenish()
            updateUiView()
        }
        binding.stepAgg7BtnNext.setOnClickListener {
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
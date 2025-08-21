package me.hd.ggtutorial.ui.fragment.step.agg

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepAgg6Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

class StepAgg6 : StepFragmentBase<FragmentStepAgg6Binding>(
    FragmentStepAgg6Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun bullet(): Int
    private external fun shoot()
    private external fun replenish()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepAgg6TvBullet.text = getString(R.string.step_agg6_bullet, bullet())
    }

    override fun initListener() {
        binding.stepAgg6BtnShoot.setOnClickListener {
            shoot()
            updateUiView()
        }
        binding.stepAgg6BtnReplenish.setOnClickListener {
            replenish()
            updateUiView()
        }
        binding.stepAgg6BtnNext.setOnClickListener {
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
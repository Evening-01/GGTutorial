package me.hd.ggtutorial.ui.fragment.step.practical

import androidx.navigation.fragment.findNavController
import me.hd.ggtutorial.R
import me.hd.ggtutorial.databinding.FragmentStepPractical1Binding
import me.hd.ggtutorial.ui.fragment.base.StepFragmentBase
import me.hd.ggtutorial.util.AlertUtil

class StepPractical1 : StepFragmentBase<FragmentStepPractical1Binding>(
    FragmentStepPractical1Binding::inflate
) {
    private external fun dataLoad(isCreated: Boolean)
    private external fun price(): Int
    private external fun num(): Int
    private external fun sub()
    private external fun add()
    private external fun money(): Int
    private external fun buy()
    private external fun success(): Boolean

    override fun updateUiView() {
        binding.stepPractical1TvNum.text = getString(
            R.string.step_practical1_num,
            num(),
            price() * num()
        )
        binding.stepPractical1TvMoney.text = getString(R.string.step_practical1_money, money())
    }

    override fun initListener() {
        updateUiView()
        binding.stepPractical1BtnSub.setOnClickListener {
            sub()
            updateUiView()
        }
        binding.stepPractical1BtnAdd.setOnClickListener {
            add()
            updateUiView()
        }
        binding.stepPractical1BtnBuy.setOnClickListener {
            buy()
            updateUiView()
        }
        binding.stepPractical1BtnNext.setOnClickListener {
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
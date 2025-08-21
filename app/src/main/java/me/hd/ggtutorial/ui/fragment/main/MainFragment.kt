package me.hd.ggtutorial.ui.fragment.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.flexbox.FlexboxLayoutManager
import me.hd.ggtutorial.R
import me.hd.ggtutorial.data.StepDetail
import me.hd.ggtutorial.data.StepTitle
import me.hd.ggtutorial.databinding.FragmentMainBinding
import me.hd.ggtutorial.ui.adapter.StepAdapter
import me.hd.ggtutorial.ui.fragment.base.FragmentBase
import me.hd.ggtutorial.util.AlertUtil

class MainFragment : FragmentBase<FragmentMainBinding>(FragmentMainBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainRvStepList.layoutManager = FlexboxLayoutManager(requireContext())
        binding.mainRvStepList.adapter = StepAdapter(
            listOf(
                StepTitle("基础"),
                StepDetail("精确搜索") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_basic1)
                },
                StepDetail("联合搜索") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_basic2)
                },
                StepDetail("范围搜索") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_basic3)
                },
                StepDetail("加密搜索") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_basic4)
                },
                StepDetail("模糊搜索") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_basic5)
                },
                StepDetail("增量填充") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_basic6)
                },
                StepDetail("文本搜索") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_basic7)
                },
                StepDetail("异或搜索") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_basic8)
                },
                StepTitle("AGG"),
                StepDetail("MOV赋值") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_agg1)
                },
                StepDetail("ADD相加 | SUB相减") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_agg2)
                },
                StepDetail("EQ等于 | NE不等于") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_agg3)
                },
                StepDetail("GT大于 | LT小于") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_agg4)
                },
                StepDetail("GE大于等于 | LE小于等于") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_agg5)
                },
                StepDetail("CBZ判断为零 | CBNZ判断非零") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_agg6)
                },
                StepDetail("NOP空操作") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_agg7)
                },
                StepTitle("进阶"),
                StepDetail("特征编码") {
                    AlertUtil.wait(requireContext())
                },
                StepDetail("基址偏移") {
                    AlertUtil.wait(requireContext())
                },
                StepDetail("脚本编写") {
                    AlertUtil.wait(requireContext())
                },
                StepTitle("实战"),
                StepDetail("消费溢出") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_practical1)
                },
                StepDetail("多值检测") {
                    findNavController().navigate(R.id.action_nav_main_to_nav_step_practical2)
                },
            )
        )
    }
}
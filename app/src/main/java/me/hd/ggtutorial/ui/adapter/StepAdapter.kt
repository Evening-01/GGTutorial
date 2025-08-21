package me.hd.ggtutorial.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.hd.ggtutorial.data.StepDetail
import me.hd.ggtutorial.data.StepItem
import me.hd.ggtutorial.databinding.ItemRvStepDetailBinding
import me.hd.ggtutorial.databinding.ItemRvStepTitleBinding

class StepAdapter(
    private val stepList: List<StepItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_STEP_DETAIL = 1
        const val VIEW_STEP_TITLE = 0
    }

    override fun getItemViewType(position: Int): Int {
        return when (stepList[position]) {
            is StepDetail -> VIEW_STEP_DETAIL
            else -> VIEW_STEP_TITLE
        }
    }

    class StepDetailViewHolder(
        val binding: ItemRvStepDetailBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class StepTitleViewHolder(
        val binding: ItemRvStepTitleBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_STEP_DETAIL -> {
                StepDetailViewHolder(
                    ItemRvStepDetailBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                StepTitleViewHolder(
                    ItemRvStepTitleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val stepItem = stepList[position]
        when (holder) {
            is StepDetailViewHolder -> {
                holder.binding.apply {
                    itemRvStepDetailBtn.text = stepItem.title
                    itemRvStepDetailBtn.setOnClickListener { stepItem.onClick() }
                }
            }

            is StepTitleViewHolder -> {
                holder.binding.apply {
                    itemRvStepTitleTv.text = stepItem.title
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return stepList.size
    }
}
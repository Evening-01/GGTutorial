package me.hd.ggtutorial.data

open class StepItem(
    val title: String,
    val onClick: () -> Unit = {}
)

class StepTitle(
    title: String,
) : StepItem(title)

class StepDetail(
    title: String,
    onClick: () -> Unit = {}
) : StepItem(title, onClick)

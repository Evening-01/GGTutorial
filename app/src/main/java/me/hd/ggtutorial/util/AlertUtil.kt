package me.hd.ggtutorial.util

import android.app.AlertDialog
import android.content.Context
import me.hd.ggtutorial.R

object AlertUtil {
    private fun msg(
        ctx: Context,
        msg: Int,
        onPositive: () -> Unit,
        onNegative: () -> Unit
    ) {
        AlertDialog.Builder(ctx).apply {
            setTitle(R.string.tip_title)
            setMessage(msg)
            setPositiveButton(R.string.yes) { _, _ -> onPositive() }
            setNegativeButton(R.string.no) { _, _ -> onNegative() }
        }.show()
    }

    fun success(ctx: Context, onPositive: () -> Unit = {}, onNegative: () -> Unit = {}) {
        msg(ctx, R.string.tip_success, onPositive, onNegative)
    }

    fun failure(ctx: Context, onPositive: () -> Unit = {}, onNegative: () -> Unit = {}) {
        msg(ctx, R.string.tip_failure, onPositive, onNegative)
    }

    fun wait(ctx: Context, onPositive: () -> Unit = {}, onNegative: () -> Unit = {}) {
        msg(ctx, R.string.tip_wait, onPositive, onNegative)
    }
}
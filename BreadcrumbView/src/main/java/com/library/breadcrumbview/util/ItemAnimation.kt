package com.library.breadcrumbview.util

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

class ItemAnimation {

    companion object {

        private const val DURATION_IN_RIGHT_LEFT: Long = 50

        fun animateItem(view: View, position: Int) {
            var pos = position
            val notFirstItem = position == -1
            pos += 1
            view.translationX = view.x + 200
            view.alpha = 0f
            val animatorSet = AnimatorSet()
            val animatorTranslateY =
                ObjectAnimator.ofFloat(view, "translationX", view.x + 200, 0f)
            val animatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 1f)
            ObjectAnimator.ofFloat(view, "alpha", 0f).start()
            animatorTranslateY.startDelay =
                if (notFirstItem) DURATION_IN_RIGHT_LEFT else pos * DURATION_IN_RIGHT_LEFT
            animatorTranslateY.duration = (if (notFirstItem) 2 else 1) * DURATION_IN_RIGHT_LEFT
            animatorSet.playTogether(animatorTranslateY, animatorAlpha)
            animatorSet.start()
        }
    }
}
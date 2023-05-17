package com.photoworld.presenter.chat

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import com.photoworld.R
import com.sendbird.uikit.fragments.ChannelFragment
import com.sendbird.uikit.model.TextUIConfig
import com.sendbird.uikit.modules.ChannelModule

class CustomChannelFragment : ChannelFragment() {

    private lateinit var module: ChannelModule

    override fun onConfigureParams(module: ChannelModule, args: Bundle) {
        super.onConfigureParams(module, args)
        this.module = module
        val myMessageUIConfig = TextUIConfig.Builder()
            .setTextSize(14.spToPx(requireContext()))
            .setTextColor(requireContext().getColor(R.color.white))
            .build()
        val otherMessageUIConfig = TextUIConfig.Builder()
            .setTextSize(14.spToPx(requireContext()))
            .setTextColor(requireContext().getColor(R.color.white))
            .build()
        with(module.headerComponent.params) {
            setUseTypingIndicator(true)
            setUseRightButton(false)
            leftButtonIcon = getDrawable(R.drawable.ic_back)
            leftButtonIconTint = ColorStateList.valueOf(requireContext().getColor(R.color.white))
        }
        with(module.messageListComponent.params) {
            setMessageBackground(
                getDrawable(R.drawable.chat_message_background),
                getDrawable(R.drawable.chat_other_message_background),
            )
            setUseUserProfile(true)
            setReactionListBackground(
                getDrawable(R.drawable.chat_message_background),
                getDrawable(R.drawable.chat_other_message_background),
            )
            setMessageTextUIConfig(otherMessageUIConfig, myMessageUIConfig)
        }
        with(module.messageInputComponent.params) {
            setUseSuggestedMentionListDivider(true)
            setInputHint("Message")
            leftButtonIcon = getDrawable(R.drawable.ic_attach_image_icon)
            rightButtonIcon = getDrawable(R.drawable.ic_send_message_button)
            leftButtonIconTint = ColorStateList.valueOf(requireContext().getColor(R.color.gray_500))
            rightButtonIconTint = ColorStateList.valueOf(requireContext().getColor(R.color.gray_500))
        }
        module.messageListComponent.rootView?.setBackgroundColor(requireContext().getColor(R.color.background))
        module.messageListComponent.recyclerView?.setBackgroundColor(requireContext().getColor(R.color.background))
        module.messageListComponent.params.setReactionListBackground(
            getDrawable(R.drawable.chat_message_background),
            getDrawable(R.drawable.chat_message_background),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        module.messageListComponent.recyclerView?.setBackgroundColor(requireContext().getColor(R.color.background))
        module.headerComponent.rootView?.setBackgroundColor(requireContext().getColor(R.color.background))
        module.messageInputComponent.editTextView?.setBackgroundColor(requireContext().getColor(R.color.gray_1000))
        view.setBackgroundColor(requireContext().getColor(R.color.gray_1000))
    }

    private fun getDrawable(@DrawableRes drawable: Int) =
        AppCompatResources.getDrawable(requireContext(), drawable)

    private fun Int.spToPx(context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            this.toFloat(),
            context.resources.displayMetrics,
        ).toInt()
    }
}

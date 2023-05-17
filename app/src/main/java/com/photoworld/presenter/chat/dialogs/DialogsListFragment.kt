package com.photoworld.presenter.chat.dialogs

import android.os.Bundle
import android.view.View
import com.photoworld.R
import com.sendbird.android.channel.GroupChannel
import com.sendbird.uikit.fragments.ChannelListFragment
import com.sendbird.uikit.modules.ChannelListModule
import com.sendbird.uikit.modules.components.HeaderComponent

class DialogListFragment(
    val onItemClick: (channelUrl: String) -> Unit,
) : ChannelListFragment() {

    private lateinit var module: ChannelListModule

    override fun onCreateModule(args: Bundle): ChannelListModule {
        module = ChannelListModule(requireContext(), ChannelListModule.Params(requireContext(), R.style.CustomChannelListStyle))
        module.setHeaderComponent<HeaderComponent>(CustomChannelListHeaderComponent())
        return module
    }

    override fun onConfigureParams(module: ChannelListModule, args: Bundle) {
        super.onConfigureParams(module, args)
        module.params.setUseHeader(true)
    }

    override fun onItemClicked(view: View, position: Int, channel: GroupChannel) {
        onItemClick(channel.url)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        module.channelListComponent.rootView?.setBackgroundColor(requireContext().getColor(R.color.background))
    }
}

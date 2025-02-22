package com.example.rickandmortyapp.core.ui

import androidx.annotation.CallSuper
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class InstanceKeeperViewModel : InstanceKeeper.Instance {

    protected val viewModelScope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main.immediate
    )

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        viewModelScope.cancel()
    }
}
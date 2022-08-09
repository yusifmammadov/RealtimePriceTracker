package com.yusifmammadov.realtimepricetracker.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yusifmammadov.realtimepricetracker.data.Repository


@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory(Repository.getInstance()))
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "BTC Price in USDT",
            fontSize = 22.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = modifier.height(36.dp))
        Text(
            text = state.price.toString(),
            color = if (state.isMore) Color.Green else Color.Red,
            fontSize = 26.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )
    }

}
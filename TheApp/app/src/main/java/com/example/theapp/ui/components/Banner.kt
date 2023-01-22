package com.example.sdugaphql.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fragment.Banner

@Composable
fun Banner(banner: Banner) {
    androidx.compose.material.Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Blue,
    ) {
        Column(
            Modifier.padding(10.dp)
        ) {
            banner.secondaryText?.let { Text(text = it) }
            banner.primaryText?.let { Text(text = it, fontSize = 24.sp) }
        }

    }
}
package com.example.sdugaphql.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.fragment.Chip

@Composable
fun TextChip(
    chip : Chip
) {
    val shape = RoundedCornerShape(8.dp)
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = shape
            )
            .background(
                color = Color.LightGray,
                shape = shape
            )
            .clip(shape = shape)
            .clickable {
//                onChecked(!isSelected)
            }
            .padding(4.dp)
    ) {
        chip.chipLabel?.let {
            Text(
                text = it,
                color = Color.Unspecified
            )
        }
    }
}

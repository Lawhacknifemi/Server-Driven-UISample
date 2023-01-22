package com.example.theapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
 fun GeneralImage(url: String, alt: String) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = alt,
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit
    )
}

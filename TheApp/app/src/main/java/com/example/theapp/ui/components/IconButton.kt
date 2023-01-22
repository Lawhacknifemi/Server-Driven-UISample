package com.example.theapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(iconButton: com.example.fragment.IconButton, modifier: Modifier = Modifier) {
    val iconName = iconButton.icon
    if (getIcon(iconName) != null){
        Icon(
            getIcon(iconName)!!, contentDescription = "a notification Icon", modifier = modifier
                .size(40.dp)
                .padding(top = 10.dp)
        )
        return
    }
}

fun getIcon(iconName: String?): ImageVector? {
    return when(iconName){
        "notifications" ->  Icons.Default.Notifications
        "shopping cart" ->  Icons.Default.ShoppingCart
        else ->  null
    }
}
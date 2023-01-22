package com.example.sdugaphql.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.fragment.TextInput

@Composable
fun TextFieldInput(textInput : TextInput, textFieldValue : TextFieldValue) {
    TextField(
        value = textFieldValue.text,
        onValueChange = {
//            textFieldValue = it
        },
        leadingIcon ={
            Icon(Icons.Default.Search, contentDescription = "", tint = Color.DarkGray)
        },
        placeholder ={ textInput.placeholder?.let { Text(text = it, color = Color.DarkGray) } },
        singleLine = true,
        modifier = Modifier
            .width(width = 250.dp)
            .height(height = 60.dp)
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(30.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor =  Color.Transparent, //hide the indicator
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.Black)
    )
}
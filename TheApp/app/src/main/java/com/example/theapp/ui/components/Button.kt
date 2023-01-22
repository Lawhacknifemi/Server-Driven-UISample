package com.example.sdugaphql.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.fragment.Button
import com.example.type.ButtonSize
import com.example.type.ButtonTheme
import com.example.type.ButtonVariant

//@Composable
//fun Button(data: com.example.fragment.Button) {
//    when (data.action) {
//        is UrlAct -> GeneralButton(data = data)
////        is Buttons.FavouriteButton -> FavouriteButton(data = data)
//    }
//}

@Composable
fun GeneralButton(data: Button) {
    val uriHandler = LocalUriHandler.current

    androidx.compose.material.Button(
        onClick = { actionHandler(action = data.action, handler = uriHandler) },
        elevation = setElevation(disableElevation = data.disableElevation),
        enabled = !data.disabled,
        colors = if (data.buttonVariant == ButtonVariant.CONTAINED) {
            ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
        } else {
            ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background)
        },
        border = if (data.buttonVariant == ButtonVariant.OUTLINED) {
            when (data.buttonTheme) {
                ButtonTheme.PRIMARY -> BorderStroke(1.dp, MaterialTheme.colors.primary)
                ButtonTheme.SECONDARY -> BorderStroke(1.dp, MaterialTheme.colors.secondary)
                ButtonTheme.SUCCESS -> BorderStroke(1.dp, Color(Colors.Success))
                else -> BorderStroke(1.dp, MaterialTheme.colors.error)
            }
        } else {
            null
        },
        modifier = when (data.buttonSize) {
            ButtonSize.SMALL -> Modifier
                .height(30.dp)
                .width(80.dp)
            ButtonSize.MEDIUM -> Modifier
            ButtonSize.LARGE -> Modifier
                .height(60.dp)
                .width(180.dp)
            else -> Modifier.height(20.dp)
                .width(10.dp)
        }
    ) {
        if (data.icon != null) {
            Image(
                painter = rememberImagePainter(data.icon),
                contentDescription = "",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
            )
        }
        data.label?.let {
            Text(
                text = it,
                color = if (data.buttonVariant == ButtonVariant.CONTAINED) {
                    MaterialTheme.colors.onPrimary
                } else {
                    when (data.buttonTheme) {
                        ButtonTheme.PRIMARY -> MaterialTheme.colors.primary
                        ButtonTheme.SECONDARY -> MaterialTheme.colors.secondary
                        ButtonTheme.SUCCESS -> Color(0xFF2E7D32)
                        else -> MaterialTheme.colors.error
                    }
                },
                fontSize = when (data.buttonSize) {
                    ButtonSize.SMALL -> MaterialTheme.typography.button.fontSize.div(2)
                    ButtonSize.MEDIUM -> MaterialTheme.typography.button.fontSize
                    ButtonSize.LARGE -> MaterialTheme.typography.h3.fontSize.times(0.5)
                    else -> return@Button
                }
            )
        }
    }
}

//@ExperimentalCoilApi
//@Composable
//fun FavouriteButton(data: Buttons.FavouriteButton, viewModel: FeedFavouriteViewModel = hiltViewModel()) {
//    var isSaved by remember {
//        mutableStateOf(false)
//    }
//    var icon by remember {
//        mutableStateOf(data.icon)
//    }
//
//    data.signal?.let {
//        viewModel.listenTo(it).subscribe { event ->
//            event.values?.forEach { value ->
//                if (value.key == SignalValuePairKey.ICON) {
//                    if (value.value is SignalValue.SignalStringValue) {
//                        icon = value.value.text
//                    }
//                }
//            }
//        }
//    }
//    Image(
//        painter = rememberImagePainter(icon),
//        contentDescription = "",
//        alignment = Alignment.Center,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier.size(30.dp).padding(2.dp).clickable {
//            when(data.action) {
//                is FavouriteAction -> {
//                    if (isSaved) {
//                        data.action.unsave?.let { viewModel.emitSignals(it) }
//                        isSaved = !isSaved
//                    } else {
//                        data.action.save?.let { viewModel.emitSignals(it) }
//                        isSaved = !isSaved
//                    }
//                }
//                else -> Unit
//            }
//        }
//    )
//}

private fun actionHandler(action: Button.Action?, handler: UriHandler) {
    action?.urlAction?.let { handler.openUri(it.url) }
}

@Composable
private fun setElevation(disableElevation: Boolean): ButtonElevation? {
    return if (disableElevation) {
        null
    } else {
        ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    }
}


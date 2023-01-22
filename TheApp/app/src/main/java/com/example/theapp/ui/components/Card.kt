package com.example.theapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fragment.Card
import com.example.sdugaphql.component.GeneralButton


@Composable
fun Card(card: Card) {
    val uriHandler = LocalUriHandler.current

    val content = card.content


    androidx.compose.material.Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                card.action?.let {
                    uriHandler.openUri(it.urlAction!!.url)
                }
            },
        elevation = 10.dp
    ) {
        Column {
            if (card.media != null) {
                GeneralImage(url = card.media.image.url, alt = card.media.image.alt)
            }
            Column(
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp,start= 16.dp, end =16.dp)
            ) {
                Text(text = card.primary, fontSize = 24.sp, fontWeight = FontWeight.W400)
                card.secondaries?.forEach {
                    Row {
                        Text(text = it, color = Color.LightGray)
                    }
                }
                content?.forEach {
                    Text(text = it, fontSize = 16.sp, fontWeight = FontWeight.W400)
                }
                if (card.links != null) {
                    Row(modifier = Modifier.padding(top = 20.dp)) {
                        card.links.forEach {
                            Column(modifier = Modifier.padding(end = 6.dp)) {
                                GeneralButton(data = it.button!!)
                            }
                        }
                    }
                }
            }
        }
    }
}
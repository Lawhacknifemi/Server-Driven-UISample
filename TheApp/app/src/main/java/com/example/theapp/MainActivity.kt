package com.example.theapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.api.ApolloResponse
import com.example.GetSampleScreenElementViewQuery
import com.example.fragment.Container
import com.example.fragment.SampleScreenView
import com.example.sdugaphql.component.*
import com.example.theapp.ui.components.Card
import com.example.theapp.ui.components.GeneralImage
import com.example.theapp.ui.components.IconButton
import com.example.theapp.ui.theme.TheAppTheme
import com.example.type.ContainerType

class MainActivity : ComponentActivity() {
    lateinit var textFieldValue: TextFieldValue
    var response: ApolloResponse<GetSampleScreenElementViewQuery.Data>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenResumed {
            response = apolloCleint.query(GetSampleScreenElementViewQuery()).execute()
            setContent {
                TheAppTheme {
                    // A surface container using the 'background' color from the theme
                    var textFieldValue1 by remember {
                        mutableStateOf(TextFieldValue())
                    }
                    textFieldValue = textFieldValue1
                    val res by remember {
                        mutableStateOf(
                            response?.data?.sampleScreen?.sampleScreenView!!.elements
                        )
                    }

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        containerFactory(component = res)
                    }
                }
            }
        }
    }
    @Composable
    fun containerElementFactory(component : List<Container.Element>?) {
        component?.forEach {
            when(it.__typename){
                "Typography" -> Typography(data = it.typography!!)
                "Button" -> GeneralButton(data = it.button!!)
                "Image" -> GeneralImage(url = it.image?.url!!, alt = it.image.alt)
                "Card" -> Card(card = it.card!!)
                "TextInput" -> TextFieldInput(textInput = it.textInput!!, textFieldValue = textFieldValue )
                "Banner" -> Banner(banner = it.banner!!)
                "Chip" -> TextChip(chip = it.chip!!)
                "IconButton" -> IconButton(iconButton = it.iconButton!!)
                else -> Text(text = "Nothing to show ")
            }
        }
    }
    @Composable
    fun containerFactory(component : List<SampleScreenView.Element>) {
        Row (
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .padding(8.dp)
                .verticalScroll(rememberScrollState())){
            Column {
                component.forEach {
                    when(it.container!!.containerType){
                        ContainerType.FILL -> Column {
                            containerElementFactory(component = it.container.elements)
                        }
                        ContainerType.COLUMN -> Column(modifier = Modifier.padding(4.dp)) {
                            containerElementFactory(component = it.container.elements)
                        }
                        ContainerType.ROW -> Row(
                            Modifier
                                .horizontalScroll(rememberScrollState())
                                .padding(4.dp)) {
                            containerElementFactory(component = it.container.elements)
                        }
                        else -> Column {
                            containerElementFactory(component = it.container.elements)
                        }
                    }
                }
            }
        }
    }


}




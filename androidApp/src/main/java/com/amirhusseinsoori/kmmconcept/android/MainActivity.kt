package com.amirhusseinsoori.kmmconcept.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amirhusseinsoori.kmmconcept.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amirhusseinsoori.kmmconcept.SimpleCollection
import com.amirhusseinsoori.kmmconcept.android.ui.theme.Compose_ConceptTheme

fun greet(): String {
    return Greeting().greeting()
}

fun list(): List<String> {
    return SimpleCollection().showList()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ConceptTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        LazyColumn {
                            items(list()) { data ->
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp, bottom = 10.dp),
                                    text = data,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(
                                    modifier = Modifier
                                        .height(1.dp)
                                        .padding(end = 15.dp, start = 15.dp)
                                        .fillMaxWidth()
                                        .background(Color.Black)
                                )
                            }

                        }
                    }

                }
            }
        }
    }

}

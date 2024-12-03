package com.example.androidstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val languageList = rememberSaveable { mutableStateOf(rusProduct) }
            ListProduct(languageList)
        }
    }
}

class ListProduct(
    val title: String,
    val arrayList: ArrayList<String>,
    val textBTN: String,
): Serializable

val rusProduct = ListProduct(
    "Список продуктов",
    arrayListOf(
        "Бананы",
        "Яйца",
        "Курица",
        "Творог",
        "Йогурт"
    ),
    "Switch Language"
)
val engProduct = ListProduct(
    "List of product",
    arrayListOf(
        "Bananas",
        "Eggs",
        "Chicken",
        "Cottage cheese",
        "Yogurt"
    ),
    "Переключить язык"
)

@Composable
fun ListProduct(languageList: MutableState<ListProduct>) {
    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(Color.LightGray)
//                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxWidth()
            ) {
                Text(
                    text = languageList.value.title,
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
            Column(
                modifier = Modifier.padding(3.dp)
            ) {
                languageList.value.arrayList.forEach {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp)
                            .background(Color.White, shape = RoundedCornerShape(10.dp))

                    ) {
                        Text(
                            text = it,
                            modifier = Modifier
                        )
                    }
                }
            }

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = languageList.value.textBTN,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable(onClick = {
                        if(languageList.value == rusProduct) languageList.value = engProduct
                        else languageList.value = rusProduct
                    })
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListProduct() {
    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top,
//        modifier = Modifier
//            .background(Color.LightGray)
//            .padding(5.dp)
//            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(Color.LightGray)
//                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxWidth()
            ) {
                Text(
                    text = rusProduct.title,
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
            Column(
                modifier = Modifier.padding(3.dp)
            ) {
                rusProduct.arrayList.forEach {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp)
                            .background(Color.White, shape = RoundedCornerShape(10.dp))

                    ) {
                        Text(
                            text = it,
                            modifier = Modifier
                        )
                    }
                }
            }

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = rusProduct.textBTN,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
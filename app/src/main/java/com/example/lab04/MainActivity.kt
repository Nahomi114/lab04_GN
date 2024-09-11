package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04.ui.theme.MyComposeAppTheme
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { TopAppBarExample() },
        bottomBar = { BottomNavigationExample() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            FlowRowExample()
            Spacer(modifier = Modifier.height(16.dp))
            FlowColumnExample()
            Spacer(modifier = Modifier.height(16.dp))
            GridExample()
            Spacer(modifier = Modifier.height(16.dp))
            ControlExamples()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    TopAppBar(
        title = {
            Text(text = "Mi aplicacion", fontSize = 20.sp)
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BottomNavigationExample() {
    BottomAppBar {
        Text(text = "Bottom Navigation", modifier = Modifier.padding(16.dp))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowExample() {
    Text(
        text = "FlowRow Example",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 8.dp)
    )
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        repeat(6) { index ->
            Text(text = "Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowColumnExample() {
    Text(
        text = "Ejemplo",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 8.dp)
    )
    FlowColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        repeat(6) { index ->
            Text(text = "Column Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun GridExample() {
    Text(
        text = "Grid Example",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 8.dp)
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(6) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = "Grid Item $index",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun ControlExamples() {
    Text(
        text = "Controls Example",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    var checked by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableStateOf(0.5f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeAppTheme {
        MainScreen()
    }
}
@Composable
fun MyUpdatedTextComponent() {
    Text(
        text = "Updated Text",
        style = TextStyle(
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(16.dp)
    )
}

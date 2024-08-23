package com.ahmetkaragunlu.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmetkaragunlu.courses.ui.theme.CoursesTheme
import androidx.compose.foundation.lazy.grid.GridCells as GridCells1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp() {
    CoursesList(topicsList = DataSource.topics)
}

@Composable
fun CoursesList(topicsList: List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells1.Fixed(2), verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(topicsList) { navigate ->
            CoursesCard(navigate = navigate)
        }
    }
}

@Composable
fun CoursesCard(navigate: Topic, modifier: Modifier = Modifier) {

    Card(modifier.padding(4.dp)) {
        Row {
            Image(
                painter = painterResource(id = navigate.imageResource), contentDescription = null,
                modifier.size(68.dp),
                contentScale = ContentScale.Crop,
            )
            Column(modifier.padding(start = 16.dp, top = 16.dp)) {
                Text(
                    text = LocalContext.current.getString(navigate.stringResource),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier.height(8.dp))
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.vector_name),
                        contentDescription = null
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(text = navigate.modelVersion.toString())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesPreview() {
    CoursesTheme {
  CoursesApp()
    }
}
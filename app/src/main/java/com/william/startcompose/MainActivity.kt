package com.william.startcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenContent()
        }
    }
}

@Composable
fun ScreenContent() {
    val context = LocalContext.current
    CardItem(
        modifier = Modifier
            .defaultCardItem()
            .rippleClickable {
                Toast.makeText(context, "I'm clicked", Toast.LENGTH_SHORT).show()
            }
    )
}

@Composable
fun CardItem(modifier: Modifier) {
    Box(
        modifier = modifier.background(Color.Green)
    )
}

fun Modifier.rippleClickable(onClick: () -> Unit): Modifier = composed {
    this.clickable(
        interactionSource = remember {
            MutableInteractionSource()
        },
        indication = rememberRipple(),
        onClick = onClick
    )
}

fun Modifier.defaultCardItem(): Modifier = this
    .fillMaxWidth()
    .height(200.dp)

@Preview(showSystemUi = true)
@Composable
fun ScreenContentPreview() {
    ScreenContent()
}
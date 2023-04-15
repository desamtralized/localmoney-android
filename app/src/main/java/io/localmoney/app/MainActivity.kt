package io.localmoney.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.localmoney.app.ui.components.BuySellButtons
import io.localmoney.app.ui.components.Container
import io.localmoney.app.ui.components.Header
import io.localmoney.app.ui.theme.LocalMoneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalMoneyTheme {
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    Container {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            BuySellButtons()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LocalMoneyTheme {
        Container {
            Content()
        }
    }
}
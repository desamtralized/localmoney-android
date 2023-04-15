package io.localmoney.app.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import io.localmoney.app.R
import io.localmoney.app.ui.theme.background
import io.localmoney.app.ui.theme.baseText
import io.localmoney.app.ui.theme.gray200
import io.localmoney.app.ui.theme.gray300


@Composable
fun LogoIcon() {
    BoxWithConstraints {
        val imagePainter = painterResource(id = R.drawable.logo_icon_dark)
        val size = 56;
        val imageSize = IntSize(size, size)
        Box(
            Modifier
                .size(imageSize.width.dp, imageSize.height.dp)
                .padding(8.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "Local Money Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun Wallet() {
    Box(
        modifier = Modifier
            .height(56.dp)
            .wrapContentWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(gray200)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "kujira12...5s507w",
                color = baseText,
                fontWeight = FontWeight.SemiBold,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_wallet),
                contentDescription = "Wallet Icon",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun Container(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = background
    ) {
        Box {
            content()
        }
    }
}

@Composable
fun Header() {
    // Set the LogoIcon on the start and align the Wallet on the end
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LogoIcon()
            Wallet()
        }
    }
}

@Composable
fun BuySellButtons() {
    val activeButtonColor = gray300
    val inactiveButtonColor = Color.Transparent
    // Create a mutable state to keep track of the active button
    var activeButton = remember { mutableStateOf(0) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(gray200)
    ) {
        Button(
            // mutate the state when the button is clicked
            onClick = { activeButton.value = 0 },
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (activeButton.value == 0) activeButtonColor else inactiveButtonColor
            )
        ) {
            Text(text = "buy")
        }
        Button(
            onClick = { activeButton.value = 1 },
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (activeButton.value == 1) activeButtonColor else inactiveButtonColor
            )
        ) {
            Text(text = "sell")
        }
    }
}

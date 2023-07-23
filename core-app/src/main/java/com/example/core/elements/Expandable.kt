package com.example.core.elements

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.R
import com.example.core.ui.theme.ButtonTextColor
import com.example.core.ui.theme.Shapes

@Composable
fun Expandable(
    headerText: String,
    hiddenContent: @Composable () -> Unit
) {

    val expandedState = remember {
        mutableStateOf(false)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val dropDownRotate = animateFloatAsState(
        if (expandedState.value)
            90f
        else
            0f
    )

    Column(
        Modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .background(Color.Transparent)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                expandedState.value = !expandedState.value
            }
            .padding(vertical = 10.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = headerText,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontSize = 20.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_drop_down),
                contentDescription = null,
                modifier = Modifier.rotate(dropDownRotate.value)
            )
        }
        Divider(
            Modifier.clip(Shapes.medium)
        )

        if (expandedState.value)
            hiddenContent()

    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview(showBackground = true)
fun ExpandablePreview() {

    val listBut = listOf(
        "All-Preserver",
        "Shogun's Descent",
        "Pledge of Propriety",
        "Shogun's Descent",
        "All-Preserver",
        "Pledge of Propriety",
    )

    Expandable(
        "Skill talents"
    ){
        FlowRow(
            Modifier.padding(vertical = 10.dp)
        ) {
            listBut.forEach {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text(
                        text = it,
                        color = ButtonTextColor
                    )
                }
            }
        }
    }

}
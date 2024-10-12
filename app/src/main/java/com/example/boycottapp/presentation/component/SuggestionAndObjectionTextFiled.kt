package com.example.boycottapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip


@Composable
fun CustomTextFieldSuggetionAndObjection(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    leadingIconResId: Int,
    maxLines: Int = 1,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(15.dp)),
                painter = painterResource(id = leadingIconResId),
                contentDescription = null
            )
        },
        placeholder = { Text(text = placeholderText) },
        maxLines = maxLines,
        shape = RoundedCornerShape(12.dp),
    )
}

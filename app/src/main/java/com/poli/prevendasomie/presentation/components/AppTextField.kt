package com.poli.prevendasomie.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.poli.prevendasomie.ui.theme.TextFieldShape

@Composable
fun AppTextField(

    text: String,
    onTextChanged: (String) -> Unit,
    labelText: String?,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    placeholderText: String? = null,
) {

    val labelComposable: (@Composable () -> Unit)? = labelText?.let {

        @Composable {
            Text(
                text = labelText,
            )
        }
    }

    val placeholderComposable: (@Composable () -> Unit)? = labelText?.let {

        @Composable {
            Text(
                text = labelText,
            )
        }
    }

    Column {

        OutlinedTextField(

            value = text,
            onValueChange = onTextChanged,
            label = labelComposable,
            shape = TextFieldShape,
            modifier = Modifier
                .heightIn(48.dp)
                .fillMaxWidth(),
            isError = (errorMessage != null),
            enabled = enabled,
            placeholder = placeholderComposable,
        )

        if (errorMessage != null) {
            Text(
                text = errorMessage,
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        start = 16.dp
                    )
            )
        }
    }
}

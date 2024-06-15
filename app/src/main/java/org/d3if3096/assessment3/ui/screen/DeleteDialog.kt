package org.d3if3096.assessment3.ui.screen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.d3if3096.assessment3.R


@Composable
fun DeleteDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit

) {
    if (openDialog) {
        AlertDialog(
            text = { Text(text = stringResource(id = R.string.pesan_hapus)) },
            confirmButton = {
                TextButton(
                    onClick = { onConfirmation() }
                ) {
                    Text(text = stringResource(id = R.string.hapus))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { onDismissRequest() }
                ) {
                    Text(text = stringResource(id = R.string.batal))
                }
            },
            onDismissRequest = { onDismissRequest() }
        )
    }
}
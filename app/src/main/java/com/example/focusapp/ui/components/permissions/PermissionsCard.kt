package com.example.focusapp.ui.components.permissions


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.focusapp.model.PermissionState

@Composable
fun PermissionsCard(

    permissions: List<PermissionState>,

    onGrantClick: (PermissionState) -> Unit

) {

    Card {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Permissões",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            permissions.forEach { permission ->

                PermissionItem(

                    permission = permission,

                    onGrantClick = {
                        onGrantClick(permission)
                    }

                )

                Spacer(modifier = Modifier.height(20.dp))

            }

        }

    }

}
package com.ydhnwb.learnvoyager.page.primary.parent_explore.parent_home.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ydhnwb.learnvoyager.entity.GameType


@Composable
fun GameTypeItem(
    item: GameType,
    onClick: (id: Int) -> Unit
){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp)
            .clickable {
                onClick(item.id)
            },
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(item.title, fontWeight = FontWeight(500) )
            Text(item.description, fontStyle = FontStyle.Italic)
        }

    }
}
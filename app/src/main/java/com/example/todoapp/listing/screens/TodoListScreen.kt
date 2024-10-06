package com.example.todoapp.listing.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.todoapp.listing.data.TaskModel
//import com.ToDo.edit.screen.EditTaskActivity


@Composable
fun TodoListScreen(
    modifier: Modifier,
    tasks: List<TaskModel>,
    onDeleteTask: (TaskModel) -> Unit,
    onEditTask: (TaskModel) -> Unit,
    onCompletedTask: (TaskModel) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .background(Color(0xFFB3B7EE))
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(tasks) { task ->
            TodoCard(
                task = task,
                onDeleteTask = onDeleteTask,
                onEditTask = onEditTask,
                onCompletedTask= onCompletedTask
            )
        }
    }
}
@Composable
fun TodoCard(
    task: TaskModel,
    onDeleteTask: (TaskModel) -> Unit,
    onEditTask: (TaskModel) -> Unit,
    onCompletedTask: (TaskModel) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = task.title,
                    style = typography.bodyMedium,
                    color = Color(0xFFB3B7EE),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = task.subTitle,
                    style = typography.bodyMedium,
                    color = Color.Black
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onEditTask(task) }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Color(0xFFB3B7EE)
                    )
                }
                IconButton(onClick = { onDeleteTask(task) }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color(0xFFB3B7EE)
                    )
                }
                IconButton(onClick = {onCompletedTask(task)}) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Complete",
                        tint = Color(0xFFb3b3f7)
                    )
                }
            }
        }
    }
}


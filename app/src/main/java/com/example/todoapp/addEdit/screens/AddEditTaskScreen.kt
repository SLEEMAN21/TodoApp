package com.example.todoapp.addEdit.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.listing.data.TaskModel
import com.example.todoapp.listing.data.TaskStatus
@Composable
fun AddEditTaskScreen(
    modifier: Modifier,
    taskModel: TaskModel? = null,
    onAddClick: (TaskModel) -> Unit,
    onEditClick: (TaskModel) -> Unit
) {
    var title by remember { mutableStateOf(TextFieldValue(taskModel?.title ?: "")) }
    var subTitle by remember { mutableStateOf(TextFieldValue(taskModel?.subTitle ?: "")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))


        OutlinedTextField(
            value = subTitle,
            onValueChange = { subTitle = it },
            label = { Text("Subtitle") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val task = TaskModel(
                    id = taskModel?.id ?: 0,
                    title = title.text,
                    subTitle = subTitle.text,
                    status = taskModel?.status ?: TaskStatus.New
                )

                if (taskModel == null) {
                    onAddClick(task)
                } else {
                    onEditClick(task)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9395D3))
        ) {
            Text(
                text = if (taskModel == null) "ADD" else "EDIT",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddTaskScreenPreview() {
    AddEditTaskScreen(
        modifier = Modifier,
        onAddClick = {},
        onEditClick = {}
    )
}
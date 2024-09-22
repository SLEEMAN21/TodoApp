package com.example.todoapp.addEdit.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign


@Composable
fun EditTaskContent(
    modifier: Modifier = Modifier,
    initialTitle: String = "",
    initialDetail: String = "",
    onUpdate: (String, String) -> Unit
)
{

    var title by remember { mutableStateOf(initialTitle) }
    var detail by remember { mutableStateOf(initialDetail) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Title") },
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = detail,
            onValueChange = { detail = it },
            label = { Text("Detail") },
            modifier = Modifier.fillMaxWidth()

        )


        Spacer(modifier = Modifier.height(24.dp))

        // Buttons Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* onUpdate(title, detail)*/},
                modifier = Modifier
                    .width(120.dp)
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9395D3))
            ) {
                Text(text = "Update",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center)
            }

            Button(
                onClick = { /* Handle cancel */ },
                modifier = Modifier
                    .width(120.dp)
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9395D3))
            ) {
                Text(text = "Cancel",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditTaskScreenPreview() {
    EditTaskContent(

         onUpdate = { _, _ -> /* لا يوجد تنفيذ حقيقي في المعاينة */ }
    )
}
package com.soha.infotech.jetpackcomposetutorial.examples.tutorialkart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Display List Items in Android Compose
 */

data class Student(val name: String, val credits: Int)

val students = listOf(
    Student("Student 1", 125),
    Student("Student 2", 75),
    Student("Student 3", 15),
    Student("Student 4", 87),
    Student("Student 5", 22),
    Student("Student 6", 96)
)

@Composable
fun StudentList(students: List<Student>) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        students.forEach { student ->
            StudentRow(student)
        }
    }
}

@Composable
fun StudentRow(student: Student) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                student.name,
                fontSize = 25.sp,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(10.dp)
            )
            Text(student.credits.toString(), color = Color.Gray, modifier = Modifier.padding(10.dp))
        }
    }
}

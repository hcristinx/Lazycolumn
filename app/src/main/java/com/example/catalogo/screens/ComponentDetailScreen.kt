package com.example.catalogo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.catalogo.data.ComponentsData

// IA generated: Detailed view of a component with functional demos
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentDetailScreen(navController: NavController, componentId: String) {
    val component = ComponentsData.items.find { it.id == componentId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(component?.name ?: "Detalle") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            if (component != null) {
                Text(
                    text = component.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = component.description,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(24.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Demo Funcional:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // IA generated: Logic to show the corresponding demo
                ComponentDemo(componentId = componentId)
            } else {
                Text("Componente no encontrado")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentDemo(componentId: String) {
    when (componentId) {
        "appbars" -> {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                TopAppBar(
                    title = { Text("Top App Bar Demo") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                )
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    IconButton(onClick = { }) { Icon(Icons.Default.Add, "Add") }
                    IconButton(onClick = { }) { Icon(Icons.Default.Favorite, "Favorite") }
                }
            }
        }
        "badges" -> {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Notificaciones: ")
                Spacer(modifier = Modifier.width(8.dp))
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(Icons.Default.Info, contentDescription = "Info")
                }
            }
        }
        "bottomsheet" -> {
            var showSheet by remember { mutableStateOf(false) }
            val sheetState = rememberModalBottomSheetState()

            Button(onClick = { showSheet = true }) {
                Text("Abrir Bottom Sheet")
            }
            if (showSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showSheet = false },
                    sheetState = sheetState
                ) {
                    Box(Modifier.fillMaxWidth().height(150.dp).padding(16.dp)) {
                        Text("Este es un Bottom Sheet de Material 3")
                    }
                }
            }
        }
        "buttons" -> {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { }) { Text("Filled Button") }
                OutlinedButton(onClick = { }) { Text("Outlined Button") }
                IconButton(onClick = { }) { Icon(Icons.Default.Favorite, "Like") }
                FloatingActionButton(onClick = { }) { Icon(Icons.Default.Add, "Add") }
            }
        }
        "card" -> {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // IA generated: Simulated image with a colored box
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .background(MaterialTheme.colorScheme.primaryContainer)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Título de la Tarjeta", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Este es un ejemplo de Card de Material 3 con una imagen simulada y texto.")
                }
            }
        }
        "carousel" -> {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(10) { index ->
                    Card(
                        modifier = Modifier.size(160.dp, 100.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer
                        )
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            Text("Item ${index + 1}")
                        }
                    }
                }
            }
        }
        "chip" -> {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                var selected1 by remember { mutableStateOf(false) }
                var selected2 by remember { mutableStateOf(false) }
                var selected3 by remember { mutableStateOf(false) }
                FilterChip(selected = selected1, onClick = { selected1 = !selected1 }, label = { Text("Opción A") })
                FilterChip(selected = selected2, onClick = { selected2 = !selected2 }, label = { Text("Opción B") })
                FilterChip(selected = selected3, onClick = { selected3 = !selected3 }, label = { Text("Opción C") })
            }
        }
        "dialog" -> {
            var showDialog by remember { mutableStateOf(false) }
            Button(onClick = { showDialog = true }) {
                Text("Mostrar Diálogo")
            }
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Confirmación") },
                    text = { Text("¿Deseas continuar con esta acción?") },
                    confirmButton = { TextButton(onClick = { showDialog = false }) { Text("Aceptar") } },
                    dismissButton = { TextButton(onClick = { showDialog = false }) { Text("Cancelar") } }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentDetailScreenPreview() {
    val navController = rememberNavController()
    ComponentDetailScreen(navController = navController, componentId = "card")
}

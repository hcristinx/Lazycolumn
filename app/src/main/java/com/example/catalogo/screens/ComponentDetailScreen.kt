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
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import com.example.catalogo.R

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
                    text = "Detalles:",
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
        "dietas_balanceadas" -> {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text(
                    text = "Adoptar una alimentación saludable es, probablemente, el desafío más grande cuando te mudas lejos de casa y te enfrentas por primera vez a la responsabilidad de llenar tu propia alacena. En esta sección de 'Dietas Saludables', hemos diseñado un espacio pensado exclusivamente para el universitario foráneo que busca optimizar su rendimiento académico sin sacrificar su presupuesto ni su tiempo limitado. Aquí no encontrarás recetas imposibles con ingredientes costosos, sino guías realistas que te enseñarán a equilibrar tus macronutrientes utilizando productos básicos del supermercado. El objetivo es concientizarte sobre cómo lo que comes impacta directamente en tu capacidad de concentración durante los exámenes, en tus niveles de estrés y en tu energía diaria para cumplir con todas tus entregas.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        "Fun_spots" -> {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "¡El 'Juebebes' en León no se perdona y tu app lo sabe mejor que nadie! En esta sección, hemos curado los mejores 'spots' de la capital del calzado para que los foráneos vivan el juernes como se debe, equilibrando el estudio con el desestrés necesario. Sabemos que como estudiante en León, tu punto de reunión por excelencia es la calle Madero, por lo que aquí encontrarás las mejores promos en lugares icónicos como el Rey Compadre o la Destilería, ideales para empezar la noche con el presupuesto justo. Pero el 'Juebebes' no solo es fiesta; también te mostramos opciones más relajadas como las terrazas de la zona del Campestre si buscas algo más 'chill', o los diversos cafés y billares cerca de la zona de la Universidad de Guanajuato o la Ibero. ",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        "Finanzas_desde_0" -> {
        var showSheet by remember { mutableStateOf(false) }
        val sheetState = rememberModalBottomSheetState()

        Button(onClick = { showSheet = true }) {
            Text("Abrir consejos")
        }
        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSheet = false },
                sheetState = sheetState
            ) {
                Box(Modifier.fillMaxWidth().height(150.dp).padding(16.dp)) {
                    Text("Las finanzas son una ilusión. Tu ve por tu azulito lindx.")
                }
            }
        }
    }
        "Recetas" -> {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { }) { Text("Estoy en definición") }
                OutlinedButton(onClick = { }) { Text("Estoy en volumen") }
                IconButton(onClick = { }) { Icon(Icons.Default.Favorite, "Like") }
                FloatingActionButton(onClick = { }) { Icon(Icons.Default.Add, "Add") }
            }
        }
        "Vida_social" -> {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // IA generated: Simulated image with a colored box
                    Image(
                        painter = painterResource(id = R.drawable.marcelito), // 👈 tu imagen aquí
                        contentDescription = "Perfil",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Marcelo García", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("20 años. Me encanta el gym, reflexionar y escuchar música. Disfruto de los cafés y las pláticas profundas.")
                }
            }
        }
        "Tiendas_de_conveniencia" -> {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(4) { index ->

                    val imageRes = when (index) {
                        0 -> R.drawable.bodega
                        1 -> R.drawable.soriana
                        2 -> R.drawable.walmart
                        3 -> R.drawable.zorro
                        else -> R.drawable.heb
                    }

                    Card(
                        modifier = Modifier.size(160.dp, 100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = "Tienda ${index + 1}",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
        "Life_coach" -> {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                var selected1 by remember { mutableStateOf(false) }
                var selected2 by remember { mutableStateOf(false) }
                var selected3 by remember { mutableStateOf(false) }
                FilterChip(selected = selected1, onClick = { selected1 = !selected1 }, label = { Text("Omar F.") })
                FilterChip(selected = selected2, onClick = { selected2 = !selected2 }, label = { Text("Natalia C.") })
                FilterChip(selected = selected3, onClick = { selected3 = !selected3 }, label = { Text("Patricia L.") })
            }
        }
        "Atención_al_cliente" -> {
            var showDialog by remember { mutableStateOf(false) }
            Button(onClick = { showDialog = true }) {
                Text("Llamar")
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

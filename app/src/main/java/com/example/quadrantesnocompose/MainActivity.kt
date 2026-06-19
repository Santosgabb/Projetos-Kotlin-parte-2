package com.example.quadrantesnocompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.quadrantesnocompose.ui.theme.QuadrantesNoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuadrantesNoComposeTheme {
                // Surface é a base visual da tela
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Chama a tela dos quatro quadrantes
                    QuatroQuadrante()
                }
            }
        }
    }
}

// Função principal que divide a tela em 4 partes
@Composable
fun QuatroQuadrante(modifier: Modifier = Modifier) {

    // Column organiza as duas linhas uma embaixo da outra
    Column(
        modifier = modifier.fillMaxSize()
    ) {

        // Primeira linha da tela
        Row(
            modifier = Modifier.weight(1f)
        ) {

            // Quadrante superior esquerdo
            QuadrantCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )

            // Quadrante superior direito
            QuadrantCard(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }

        // Segunda linha da tela
        Row(
            modifier = Modifier.weight(1f)
        ) {

            // Quadrante inferior esquerdo
            QuadrantCard(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )

            // Quadrante inferior direito
            QuadrantCard(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// Função reutilizável para criar cada quadrante
@Composable
fun QuadrantCard(
    title: String,
    description: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            // Faz o card ocupar todo o espaço disponível dentro do quadrante
            .fillMaxSize()

            // Define a cor de fundo de cada quadrante
            .background(color)

            // Dá espaçamento interno no conteúdo
            .padding(16.dp),

        // Centraliza o conteúdo verticalmente
        verticalArrangement = Arrangement.Center,

        // Centraliza o conteúdo horizontalmente
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Texto do título em negrito
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Texto da descrição justificado
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

// Preview para visualizar no Android Studio
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun QuatroQuadrantePreview() {
    QuadrantesNoComposeTheme {
        QuatroQuadrante()
    }
}
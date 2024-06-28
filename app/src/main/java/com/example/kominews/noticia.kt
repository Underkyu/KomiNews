package com.example.kominews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.math.round


@Composable
fun Noticia(navController: NavController) {
    val layoutDirection = LocalLayoutDirection.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
        color = Color.White
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color(99, 47, 200))
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.komi),
                    contentDescription = "Icon Komi San"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "Komi News",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        LazyColumn(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = LocalContext.current.getString(R.string.titulo1),
                        color = Color.Black,
                        fontSize = 31.sp,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = LocalContext.current.getString(R.string.subtitulo1),
                        color = Color.Gray,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Image(
                        painter = painterResource(id = R.drawable.image1),
                        contentDescription = "Dungeon Meshi",
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp)
                            .shadow(elevation = 7.dp,
                                ambientColor = colorResource(R.color.teal_700),
                                spotColor = colorResource(R.color.teal_700),
                                shape = RoundedCornerShape(20.dp)),
                    )
                    Text(
                        text = "O anime febre da temporada conhecido como Dugeon Meshi teve sua 2ª tempoarada anunciada pelo estudio Trigger, responsavel pela adaptação",
                        color = Color.Black,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(13.dp, 0.dp, 13.dp, 20.dp),
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = "Apesar da sua segunda tempodarada ter sido anunciada, nada se sabe sobre uma possivel data de estreia da mesma, mas pelo sucesso do anime provavelmente não irá demorar muito",
                        color = Color.Black,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(13.dp, 0.dp, 13.dp, 20.dp),
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = "A segunda temporada de Dungeon Meshi possivelmente tambem será sua ultima, uma vez que o manga no qual o anime se baseia não é muito longo e anime já está bem avançado na história",
                        color = Color.Black,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(13.dp, 0.dp, 13.dp, 20.dp),
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = "O anime conta a história de um grupo de aventureiros que vai as pressas salvar a irmã do lider que foi atacada por um dragão dentro de uma dungeon e se veem obrigados a se alimentar dos monstros da mesma para sobreviver. O anime está disponivel no catálogo da Netflix",
                        color = Color.Black,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(13.dp, 0.dp, 13.dp, 20.dp),
                        textAlign = TextAlign.Justify,
                    )
                    Button(onClick = { navController.navigate(rotas.principal) }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp), colors = ButtonDefaults.buttonColors(Color(99, 47, 200))) {
                        Text(text = "Voltar a página principal", color = Color.White)
                    }
                }
            }
        }
        }
    }
}
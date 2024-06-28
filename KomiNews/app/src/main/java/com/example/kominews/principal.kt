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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.affirmations.data.Datasource
import com.example.kominews.model.Noticia


@Composable
fun KominewsPreview(navController: NavController){

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
                Text("Komi News", color = Color.White, fontSize = 32.sp, fontFamily = FontFamily.Monospace)
            }
            NoticiaList(
                noticiaList = Datasource().loadAffirmations(),
                modifier = Modifier,
                navController
            )
        }
    }
}

@Composable
fun NoticiaCard(noticia: Noticia, modifier: Modifier,navController: NavController) {

    Card(modifier = modifier
        .background(colorResource(R.color.white))
        .shadow(
            elevation = 7.dp,
            ambientColor = colorResource(R.color.teal_700),
            spotColor = colorResource(R.color.teal_700),
            shape = RoundedCornerShape(20.dp)
        )
        .size(width = 400.dp, height = 415.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.white)),
        elevation = CardDefaults.cardElevation(10.dp),
        content = {
            Column {
                Image(
                    painter = painterResource(noticia.imagem),
                    contentDescription = stringResource(noticia.titulo),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = LocalContext.current.getString(noticia.titulo),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black
                )
                Text(
                    text = LocalContext.current.getString(noticia.subtitulo),
                    modifier = Modifier.padding(16.dp,0.dp,16.dp,16.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                
                Button(onClick = { navController.navigate(rotas.noticia)  }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp), colors = ButtonDefaults.buttonColors(Color(99, 47, 200))) {
                    Text(text = "Ver Notícia", color = Color.White)
                }
                    
                }

        }

    )
}

@Composable
fun NoticiaList(noticiaList: List<Noticia>, modifier: Modifier = Modifier,navController: NavController) {
    LazyColumn(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        item { Text(text = "Principais Noticias", color = Color.Black, fontSize = 38.sp, modifier = Modifier.padding(0.dp,0.dp,0.dp,20.dp)) }
        items(noticiaList) { noticia ->
            NoticiaCard(
                noticia = noticia,
                modifier = Modifier.padding(8.dp),
                navController
            )
        }
    }
}
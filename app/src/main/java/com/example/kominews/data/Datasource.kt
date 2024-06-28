package com.example.affirmations.data

import com.example.kominews.R
import com.example.kominews.model.Noticia

class Datasource() {
    fun loadAffirmations(): List<Noticia> {
        return listOf<Noticia>(
            Noticia(R.string.titulo1,R.string.subtitulo1,R.drawable.image1),
            Noticia(R.string.titulo2,R.string.subtitulo2,R.drawable.image2),
            Noticia(R.string.titulo3,R.string.subtitulo3,R.drawable.image3),
            Noticia(R.string.titulo4,R.string.subtitulo4,R.drawable.image4),
            Noticia(R.string.titulo5,R.string.subtitulo5,R.drawable.image5),
            Noticia(R.string.titulo6,R.string.subtitulo6,R.drawable.image6),
            Noticia(R.string.titulo7,R.string.subtitulo7,R.drawable.image7)
        )
    }
}
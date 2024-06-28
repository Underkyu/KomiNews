package com.example.kominews.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Noticia(@StringRes val titulo: Int,
                   @StringRes val subtitulo: Int,
                   @DrawableRes val imagem: Int) {
}

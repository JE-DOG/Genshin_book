package com.example.genshinbook.presentaion.model.vision

import androidx.annotation.DrawableRes
import com.example.genshinbook.R

enum class Vision(val visionName: String, @DrawableRes val icon: Int) {

    ANEMO("Anemo", R.drawable.ic_element_anemo),
    ELECTRO("Electro",R.drawable.ic_element_electro),
    GEO("Geo", R.drawable.ic_element_geo),
    CRYO("Cryo",R.drawable.ic_element_cryo),
    DENDRO("Dendro",R.drawable.ic_element_dendro),
    PYRO("Pyro",R.drawable.ic_element_pyro),
    HYDRO("Hydro",R.drawable.ic_element_hydro)

}
package com.poli.prevendasomie.presentation.client_detail

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ClientDetailScreen(
    navController: NavController,
    viewModel: ClientDetailViewModel = hiltViewModel(),
    codigoClienteOmie: String
) {


    viewModel.loadClientByCode(codigoClienteOmie)

    Row(){

        Text("Oi $codigoClienteOmie ?")
        Text("${.nomeFantasia}")

    }




}


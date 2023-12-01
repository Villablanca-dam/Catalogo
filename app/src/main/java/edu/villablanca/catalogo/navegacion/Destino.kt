package edu.villablanca.catalogo.navegacion

/**
 * rutas para la navegación
 */
sealed class Destino(val ruta: String){
    object PLista: Destino("/PantallaComponentes")
    object PPrincipal: Destino("/PantallaPrincipal")

    object PCodigoFuente: Destino("/PCodigoFuente")
    object PText: Destino("/PText")
    object PButton: Destino("/PButton")


}
fun main() {
    // Kadu Farias
    val textoCifrado = "^mu({uuxzm0w(w{ƒw(zw„wz(x‚i(uq}+Vmu0{mux‚m(m}0{w}(„ëw(ty~zm(q{{qu3Y}mu0vëw(€mv..."
    }
  
//Decifrar texto
  
fun decifrarTexto(cifrado: String): String {
    val chave = { index: Int -> if (index % 5 == 0) 16 else 8 }
    val textoDecifrado = cifrado.mapIndexed { index, char ->
        val deslocamento = chave(index)
        (char.toInt() - deslocamento).toChar()
    }.joinToString("")
    return textoDecifrado
}
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

fun substituirPalindromos(texto: String): Pair<String, List<String>> {
    val palavras = texto.split(Regex("\\s+"))
    val palindromos = mutableListOf<String>()
    val palavrasSubstituidas = palavras.map { palavra ->
        if (palavra.equals(palavra.reversed(), ignoreCase = true) && palavra.length > 1) {
            palindromos.add(palavra)
            when (palindromos.size) {
                1 -> "\u001B[31mcéu\u001B[0m"
                2 -> "\u001B[31msorri\u001B[0m"
                3 -> "\u001B[31mvontade\u001B[0m"
                else -> palavra
            }
        } else palavra
    }
    return Pair(palavrasSubstituidas.joinToString(" "), palindromos)
}
fun substituirPalindromos(texto: String): Pair<String, List<String>> {
    val palavras = texto.split(Regex("\\s+"))
    val palindromos = mutableListOf<String>()
    val palavrasSubstituidas = palavras.map { palavra ->
        if (palavra.equals(palavra.reversed(), ignoreCase = true) && palavra.length > 1) {
            palindromos.add(palavra)
            when (palindromos.size) {
                1 -> "\u001B[31mcéu\u001B[0m"
                2 -> "\u001B[31msorri\u001B[0m"
                3 -> "\u001B[31mvontade\u001B[0m"
                else -> palavra
            }
        } else palavra
    }
    return Pair(palavrasSubstituidas.joinToString(" "), palindromos)
}

fun adicionarNomeParticipantes(
    texto: String,
    nome1: String,
    nome2: String
): String {
    val ultimaOcorrencia = texto.lastIndexOf("Vem")
    return if (ultimaOcorrencia != -1) {
        val inicio = texto.substring(0, ultimaOcorrencia + 3)
        val fim = texto.substring(ultimaOcorrencia + 3)
        "$inicio \u001B[31m$nome1 e $nome2\u001B[0m$fim"
    } else texto
}

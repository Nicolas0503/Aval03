fun main() {
    
    //Kadu Farias e Nícolas
    val textoCifrado = "^mu({uuxzm0w(w{w(zwwz(xi(uq}+Vmu0{muxm(m}0{w}(ëw(ty~zm(q{{qu3Y}mu0vëw(mv{i0mu(xqziz+a}mu(~ëw(xuv{i(uu(n}wqz+[uu(lm|qvw3Lé(iizi(tm({iyz+[m}(lm{qvw+cmu({qjmz(qwvlm0qz++`izi(vlm(iq(w0|mux+Xizq(wvlu(~ëw0w{({vpw{3Xzi(vlm(vwq(w0y}m(u}({m~|qi+Tm(zmmv|m3\\}lw0u}li0{mu(q~q{w3Lm(zuxmv|u++I(qli(ù(}u(iq(m0~mu+^ili(ù(xzi0{muxm+I(qli(ù(}u(iq(m0~mu+^ili(ù(xzi0{muxm+I(qli(ù(}u(iq(m0~mu+^ili(ù(xzi0{muxm+I(qli(ù(}u(iq(m0~mu3Y}ivw(uiy{(ximkm((nqu3Y}ivw(uiy{(vq~o}ñu0lq(qu+Uq{(v}~ki(uu(mv{yvizi}+M(m(v}vsi(ixmvlq3Um{u(i{{yu+Umuw(i{qu(wjzmq~q+]m{uw0i{{q}+M}(qqvli0m{|w(iy}y++Lm0~m(uu(y}qvlw(}m({q~|w(juu+Lm0~m(uu(y}qvlw(}m({q~|w(uqt+Lm0~m(uu(y}qvlw(}lw(yo}it3Lm(zuxmv|u(|}l(u}lq({mu0i~q{+Lm(mxmvm++I0~qli0ñ(}u0~iq(u(~mu3Vili0ñ(xzq({muzm+I0~qli0ñ(}u0~iq(u(~mu3Vili0ñ(xzq({muzm+I0~qli0ñ(}u0~iq(u(~mu3Vili0ñ(xzq({muzm+I0~qli0ñ(}u0~iq(u(~mu3Vili0ñ(xzq({muzm+I0~qli0ñ(}u0~iq(u(~mu3+Kixy|it(Yvqkqqt+^iy(m(^uu"

    // Decifrar o texto
    val textoDecifrado = decifrarTexto(textoCifrado)

    // substituir '#' por '\n'
    val textoComQuebraLinha = textoDecifrado.replace("#", "\n")

    // substituir palíndromos
    val (textoComPalindromos, palindromos) = substituirPalindromos(textoComQuebraLinha)

    // Concatenar 
    val textoFinal = adicionarNomes(textoComPalindromos, "Kadu Farias e Nícolas Bastos")

    // Exibir resultados
    println("Conteúdo do texto cifrado:")
    println(textoCifrado)
    println("\nPalíndromos encontrados:")
    println(palindromos)
    println("\nNúmero de caracteres do texto final: ${textoFinal.length}")
    println("Quantidade de palavras do texto final: ${textoFinal.split("\\s+".toRegex()).size}")
    println("\nTexto final:")
    println(textoFinal)
}

fun decifrarTexto(texto: String): String {
    val builder = StringBuilder()
    for (i in texto.indices) {
        val char = texto[i]
        val chave = if (i % 5 == 0) 16 else 8
        builder.append((char - chave).toChar())
    }
    return builder.toString()
}

fun substituirPalindromos(texto: String): Pair<String, List<String>> {
    val palavras = texto.split("\\s+".toRegex())
    val palindromosEncontrados = mutableListOf<String>()
    val substituicoes = listOf("céu", "sorri", "vontade")
    var contador = 0

    val textoAlterado = palavras.joinToString(" ") { palavra ->
        if (palavra == palavra.reversed() && contador < substituicoes.size) {
            palindromosEncontrados.add(palavra)
            "\u001B[31m${substituicoes[contador++]}\u001B[0m"
        } else palavra
    }
    return textoAlterado to palindromosEncontrados
}

fun adicionarNomes(texto: String, nomes: String): String {
    val ultimaOcorrencia = texto.lastIndexOf("Vem")
    return if (ultimaOcorrencia != -1) {
        texto.substring(0, ultimaOcorrencia + 3) +
                "\u001B[31m $nomes\u001B[0m" +
                texto.substring(ultimaOcorrencia + 3)
    } else texto
}

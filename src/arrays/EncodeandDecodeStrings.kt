package arrays


fun main() {
    val input = listOf("hello", "world", "this is a test", "")

    // Testing CodecUnoptimized
    val codecUnoptimized = CodecUnoptimized()
    val encodedUnoptimized = codecUnoptimized.encode(input)
    val decodedUnoptimized = codecUnoptimized.decode(encodedUnoptimized)

    println("Unoptimized Encoding: $encodedUnoptimized")
    println("Unoptimized Decoding: $decodedUnoptimized")

    // Testing CodecOptimized
    val codecOptimized = CodecOptimized()
    val encodedOptimized = codecOptimized.encode(input)
    val decodedOptimized = codecOptimized.decode(encodedOptimized)

    println("Optimized Encoding: $encodedOptimized")
    println("Optimized Decoding: $decodedOptimized")
}

class CodecUnoptimized {
    fun encode(strs: List<String>): String = strs.joinToString(separator = "|")

    fun decode(s: String): List<String> = s.split("|")
}

class CodecOptimized {
    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        for (str in strs) {
            sb.append(str.length).append('#').append(str)
        }
        return sb.toString()
    }

    fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            val sharpIndex = s.indexOf('#', i)
            val length = s.substring(i, sharpIndex).toInt()
            i = sharpIndex + 1 + length
            result.add(s.substring(sharpIndex + 1, i))
        }
        return result
    }
}

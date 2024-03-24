package arrays

fun main() {
    println(isAnagram("rahat", "tahar"))
    println(isAnagramOptimized("rahat", "tahar"))
}


fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    return s.toCharArray().sorted() == t.toCharArray().sorted()
}


fun isAnagramOptimized(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val charCounts = IntArray(26)
    for (i in s.indices) {
        charCounts[s[i] - 'a']++
        charCounts[t[i] - 'a']--
    }

    return charCounts.all { it == 0 }
}

package arrays

fun main() {
    println(groupAnagramsUnoptimized(arrayOf("rahat", "akash", "tapash", "tahar")))
    println(groupAnagramsOptimized(arrayOf("rahat", "akash", "tapash", "tahar")))
    println(groupAnagramsOptimizedSimplified(arrayOf("rahat", "akash", "tapash", "tahar")))
}

fun groupAnagramsUnoptimized(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()
    for (str in strs) {
        val sortedStr = str.toCharArray().sorted().joinToString("")
        if (!map.containsKey(sortedStr)) {
            map[sortedStr] = mutableListOf()
        }
        map[sortedStr]!!.add(str)
    }
    return map.values.toList()
}

fun groupAnagramsOptimized(strs: Array<String>): List<List<String>> {
    val map = HashMap<Map<Char, Int>, MutableList<String>>()
    for (str in strs) {
        val charCounts = str.groupingBy { it }.eachCount()
        map.computeIfAbsent(charCounts) { mutableListOf() }.add(str)
    }
    return map.values.toList()
}

fun groupAnagramsOptimizedSimplified(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()

    for (str in strs) {
        val charCounts = IntArray(26)
        for (char in str) {
            charCounts[char - 'a']++
        }
        val key = charCounts.joinToString("#")
        if (!map.containsKey(key)) {
            map[key] = mutableListOf()
        }
        map[key]!!.add(str)
    }

    return map.values.toList()
}



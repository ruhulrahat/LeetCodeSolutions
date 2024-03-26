package arrays

fun main() {
    println(groupAnagramsUnoptimized(arrayOf("rahat", "akash", "tapash", "tahar")))
    println(groupAnagramsOptimized(arrayOf("rahat", "akash", "tapash", "tahar")))
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


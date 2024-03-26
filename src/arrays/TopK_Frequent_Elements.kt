package arrays

fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    val k = 2
    val resultUnoptimized = topKFrequentUnoptimized(nums, k)
    println(resultUnoptimized.joinToString(", "))

    val resultOptimized = topKFrequentOptimized(nums, k)
    println(resultOptimized.joinToString(", "))
}

fun topKFrequentUnoptimized(nums: IntArray, k: Int): IntArray {
    val frequencyMap = mutableMapOf<Int, Int>()
    for (num in nums) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    val sortedNums = frequencyMap.toList().sortedByDescending { it.second }.toMap()
    return sortedNums.keys.take(k).toIntArray()
}


fun topKFrequentOptimized(nums: IntArray, k: Int): IntArray {
    val frequencyMap = nums.toList().groupingBy { it }.eachCount()
    val bucket = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }

    for ((num, freq) in frequencyMap) {
        bucket[freq].add(num)
    }

    val result = mutableListOf<Int>()
    for (i in bucket.indices.reversed()) {
        for (num in bucket[i]) {
            result.add(num)
            if (result.size == k) return result.toIntArray()
        }
    }

    return result.toIntArray()
}

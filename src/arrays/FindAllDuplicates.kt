package arrays


fun main() {
    val input = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    //println(findDuplicatesUnoptimized(input))
    println(findDuplicatesOptimized(input))
}

fun findDuplicatesUnoptimized(nums: IntArray): List<Int> {
    nums.sort()
    val duplicates = mutableListOf<Int>()
    for (i in 1..nums.size) {
        if (nums[i] == nums[i - 1]) {
            duplicates.add(nums[i])
        }
    }
    return duplicates
}

fun findDuplicatesOptimized(nums: IntArray): List<Int> {
    val seen = HashSet<Int>()
    val duplicates = mutableListOf<Int>()
    for (num in nums) {
        if (!seen.add(num)) {
            duplicates.add(num)
        }
    }
    return duplicates
}



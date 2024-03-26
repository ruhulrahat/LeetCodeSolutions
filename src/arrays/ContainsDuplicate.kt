package arrays


fun main() {
    val input = intArrayOf(2, 3, 4, 4)
    println(containsDuplicateUnoptimized(input))
    println(containsDuplicateOptimized(input))
}

fun containsDuplicateUnoptimized(nums: IntArray): Boolean {
    for (i in nums.indices) {
        for (j in i + 1..<nums.size) {
            if (nums[i] == nums[j]) {
                return true
            }
        }
    }
    return false
}

fun containsDuplicateOptimized(nums: IntArray): Boolean {
    val seen = HashSet<Int>()
    for (num in nums) {
        if (seen.contains(num)) {
            return true
        }
        seen.add(num)
    }
    return false
}


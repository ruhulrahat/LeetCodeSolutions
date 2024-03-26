package arrays


fun main() {
    val inputArray = intArrayOf(2, 5, 5, 3, 3, 9, 1)
    println(twoSumUnoptimized(inputArray, 12).contentToString())
    println(twoSumOptimized(inputArray, 12).contentToString())
}

fun twoSumUnoptimized(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in i + 1..<nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    throw IllegalArgumentException("No two sum solution")
}

fun twoSumOptimized(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("No two sum solution")
}

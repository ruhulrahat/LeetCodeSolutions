package arrays


fun main() {
    val input = intArrayOf(100,4,200,1,3,2)
    println(longestConsecutiveUnoptimized(input))
    println(longestConsecutiveOptimized(input))
}
fun longestConsecutiveUnoptimized(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    nums.sort()
    var longestStreak = 1
    var currentStreak = 1

    for (i in 1..<nums.size) {
        if (nums[i] != nums[i - 1]) {
            if (nums[i] == nums[i - 1] + 1) {
                currentStreak++
            } else {
                longestStreak = maxOf(longestStreak, currentStreak)
                currentStreak = 1
            }
        }
    }

    return maxOf(longestStreak, currentStreak)
}

fun longestConsecutiveOptimized(nums: IntArray): Int {
    val numSet = nums.toHashSet()
    var longestStreak = 0

    for (num in numSet) {
        if (!numSet.contains(num - 1)) {
            var currentNum = num
            var currentStreak = 1

            while (numSet.contains(currentNum + 1)) {
                currentNum++
                currentStreak++
            }

            longestStreak = maxOf(longestStreak, currentStreak)
        }
    }

    return longestStreak
}


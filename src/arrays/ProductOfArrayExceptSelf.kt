package arrays


fun main() {

    val input = intArrayOf(1,2,3,4)
    println(productExceptSelfUnoptimized(input).contentToString())
    println(productExceptSelfOptimized(input).contentToString())
}

fun productExceptSelfUnoptimized(nums: IntArray): IntArray {
    val length = nums.size
    val leftProducts = IntArray(length) { 1 }
    val rightProducts = IntArray(length) { 1 }
    val answer = IntArray(length)

    for (i in 1..<length) {
        leftProducts[i] = leftProducts[i - 1] * nums[i - 1]
    }

    for (i in length - 2 downTo 0) {
        rightProducts[i] = rightProducts[i + 1] * nums[i + 1]
    }

    for (i in nums.indices) {
        answer[i] = leftProducts[i] * rightProducts[i]
    }

    return answer
}

fun productExceptSelfOptimized(nums: IntArray): IntArray {
    val length = nums.size
    val answer = IntArray(length) { 1 }

    var leftProduct = 1
    for (i in nums.indices) {
        answer[i] = leftProduct
        leftProduct *= nums[i]
    }

    var rightProduct = 1
    for (i in length - 1 downTo 0) {
        answer[i] *= rightProduct
        rightProduct *= nums[i]
    }

    return answer
}


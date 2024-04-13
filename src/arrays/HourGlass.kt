package arrays

fun maxHourglassSum(arr: Array<Array<Int>>): Int {
    var maxSum = Int.MIN_VALUE
    for (i in 0..3) {
        for (j in 0..3) {
            val sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                    arr[i+1][j+1] +
                    arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
            maxSum = maxOf(maxSum, sum)
        }
    }
    return maxSum
}

fun main() {
    val arr = arrayOf(
        arrayOf(1, 1, 1, 0, 0, 0),
        arrayOf(0, 1, 0, 0, 0, 0),
        arrayOf(1, 1, 1, 0, 0, 0),
        arrayOf(0, 0, 2, 4, 4, 0),
        arrayOf(0, 0, 0, 2, 0, 0),
        arrayOf(0, 0, 1, 2, 4, 0)
    )
    val result = maxHourglassSum(arr)
    println(result)  // Output should be 19
}

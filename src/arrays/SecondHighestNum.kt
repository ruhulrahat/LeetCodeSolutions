package arrays

fun main() {
    println(findSecondHighestNumber(intArrayOf(2,3,4,5,10)))
}

fun findSecondHighestNumber(numbers: IntArray): Int? {
    if (numbers.size < 2) return null // not enough elements

    var highest = Int.MIN_VALUE
    var secondHighest = Int.MIN_VALUE

    for (number in numbers) {
        if (number > highest) {
            secondHighest = highest // update second highest
            highest = number // update highest
        } else if (number > secondHighest && number != highest) {
            secondHighest = number // update second highest if number is different from the highest
        }
    }

    return if (secondHighest == Int.MIN_VALUE) null else secondHighest // check if second highest was updated
}

package recursion



fun fibIterative(n: Int): Long {
    if (n <= 1) {
        return n.toLong()
    }
    var a: Long = 0
    var b: Long = 1
    for (i in 2..n) {
        val sum = a + b
        a = b
        b = sum
    }
    return b
}

fun fibUnoptimizedRecursive(n: Long): Long {
    if (n <= 1) {
        return n
    }
    return fibUnoptimizedRecursive(n - 1) + fibUnoptimizedRecursive(n - 2)
}

fun fibOptimizedTabulation(n: Int): Long {
    if (n <= 1) return n.toLong()
    val memo = LongArray(n + 1)
    memo[0] = 0
    memo[1] = 1
    for (i in 2..n) {
        memo[i] = memo[i - 1] + memo[i - 2]
    }
    return memo[n]
}

fun fibRecursiveMemo(n: Int, memo: LongArray = LongArray(n + 1)): Long {
    if (n <= 1) return n.toLong()

    if (memo[n] != 0L) return memo[n]

    memo[n] = fibRecursiveMemo(n - 1, memo) + fibRecursiveMemo(n - 2, memo)
    return memo[n]
}




fun main() {
    println(fibIterative(100))
    //println(fibUnoptimizedRecursive(100))
    println(fibOptimizedTabulation(100))
    println(fibRecursiveMemo(100))

}


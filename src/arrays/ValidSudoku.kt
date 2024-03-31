package arrays


fun main() {

    val sudoku = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )


    println(isValidSudokuUnoptimized(sudoku))
    println(isValidSudokuOptimized(sudoku))
    println(isValidSudokuOptimizedSimplified(sudoku))
}

fun isValidSudokuUnoptimized(board: Array<CharArray>): Boolean {
    // Check each row
    for (row in board) {
        if (!isPartValid(row)) return false
    }

    // Check each column
    for (i in 0..<9) {
        val column = CharArray(9) { j -> board[j][i] }
        if (!isPartValid(column)) return false
    }

    // Check each sub-box
    for (i in 0..<9 step 3) {
        for (j in 0..<9 step 3) {
            val box = CharArray(9)
            for (k in 0..<9) {
                box[k] = board[i + k / 3][j + k % 3]
            }
            if (!isPartValid(box)) return false
        }
    }

    return true
}

fun isPartValid(part: CharArray): Boolean {
    val seen = BooleanArray(9)
    for (char in part) {
        if (char != '.') {
            if (seen[char - '1']) return false
            seen[char - '1'] = true
        }
    }
    return true
}

fun isValidSudokuOptimized(board: Array<CharArray>): Boolean {
    val seen = HashSet<String>()
    for (i in 0..<9) {
        for (j in 0..<9) {
            if (board[i][j] != '.') {
                val num = board[i][j]
                if (!seen.add("$num in row $i") ||
                    !seen.add("$num in column $j") ||
                    !seen.add("$num in box ${i / 3}${j / 3}")) return false
            }
        }
    }
    return true
}

fun isValidSudokuOptimizedSimplified(board: Array<CharArray>): Boolean {
    val seen = HashSet<String>()

    for (i in 0..<9) {
        for (j in 0..<9) {
            val currentVal = board[i][j]
            if (currentVal != '.') {
                val rowKey = "$currentVal in row $i"
                val colKey = "$currentVal in column $j"
                val boxKey = "$currentVal in box ${i / 3}${j / 3}"

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false
                }
            }
        }
    }

    return true
}



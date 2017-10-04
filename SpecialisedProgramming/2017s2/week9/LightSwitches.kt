class LightSwitches {
    fun countPossibleConfigurations(switches: Array<String>): Long {
        val rows = switches.size
        val columns = switches[0].length

        // translate into boolean array
        val table = switches.map { it.map { it == 'Y' }.toMutableList() }.toMutableList()
        // outputMatrix(table);

        // Gaussian Elimination
        var count = 0 // effective row counts, as the beginning index of non-eliminated rows, too
        for (c in 0 until columns) {
            // move the line with non-empty[j] to top for easy comparison
            var nonEmpty = count
            while (nonEmpty < rows) {
                if (table[nonEmpty][c]) break
                nonEmpty++
            }
            if (nonEmpty == rows) continue // current column has no `true`

            // move the first row containing `true` to row `count`, from column `j` to column `count`
            run {
                var j = 0
                while (j < columns && count != nonEmpty) {
                    // swap trick: swap table[count][j] and table[nonEmpty][j], without using temp
                    table[count][j] = table[count][j] xor table[nonEmpty][j]
                    table[nonEmpty][j] = table[nonEmpty][j] xor table[count][j]
                    table[count][j] = table[count][j] xor table[nonEmpty][j]
                    j++
                }
            }

            // elimination from table[count + 1][]
            for (i in count + 1 until rows) {
                if (table[i][c])
                    for (j in 0 until columns) {
                        table[i][j] = table[i][j] xor table[count][j] // table[count][] is accumulated elimination result
                    }
            }
            count += 1
        }
        return 1L shl count
    }

    private fun outputMatrix(mat: Array<BooleanArray>) {
        for (i in mat.indices) {
            for (j in 0 until mat[i].size)
                print(if (mat[i][j]) 1 else 0)
            println()
        }
        println()
    }
}

fun main(args: Array<String>) {
    println(LightSwitches().countPossibleConfigurations(arrayOf("YYN", "NNY", "YYY", "NNN")))
    println(LightSwitches().countPossibleConfigurations(arrayOf("NNNNYYYNYYNYYYYYNYY")))
    println(LightSwitches().countPossibleConfigurations(arrayOf("NYNYNYN", "YNYNYNY", "YYNNNYN", "NNNYNYN", "YYYYYNN", "YNNNNYN")))
    println(LightSwitches().countPossibleConfigurations(arrayOf(
            "YNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNN",
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNN")))
    println(LightSwitches().countPossibleConfigurations(arrayOf("NNY", "NYN")))
}
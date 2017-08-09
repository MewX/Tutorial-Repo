
class Elections {
    fun visit(likelihoods: Array<String>): Int =
            likelihoods.mapIndexed { idx, it -> idx to it.count { it == '2' }.toFloat() / it.length }
                    .sortedWith(compareBy({ -it.second }, { it.first }))
                    .first().first
}

fun main(args: Array<String>) {
    println(Elections().visit(arrayOf("1222","1122","1222")))
    println(Elections().visit(arrayOf("1222111122","2222222111","11111222221222222222")))
    println(Elections().visit(arrayOf("111","112","121","122","211","212","221","222")))
    println(Elections().visit(arrayOf("1122","1221","1212","2112","2121","2211")))
    println(Elections().visit(arrayOf("11112222111121","1211221212121","112111222","11122222222111","112121222","1212122211112")))
}

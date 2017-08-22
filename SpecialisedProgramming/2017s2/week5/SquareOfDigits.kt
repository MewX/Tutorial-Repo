/**
 * Created by MewX on 8/23/2017.
 */

class SquareOfDigits {
    fun getMax(data: Array<String>): Int =
        (data.size downTo 2).filter { it <= data[0].length }
                .filter { distance->
                    (0..data.size - distance).map { x ->
                        (0..data[0].length - distance).filter { y ->
                            data[x][y] == data[x + distance - 1][y]
                                    && data[x + distance - 1][y] == data[x][y + distance - 1]
                                    && data[x][y + distance - 1] == data[x + distance - 1][y + distance - 1]
                        }.count()
                    }.sum() > 0
                }.max()?.let { it * it } ?: 1
}

fun main(args: Array<String>) {
    System.out.println(SquareOfDigits().getMax(arrayOf("12", "34")))
    System.out.println(SquareOfDigits().getMax(arrayOf("1255", "3455")))
    System.out.println(SquareOfDigits().getMax(arrayOf("42101", "22100", "22101")))
    System.out.println(SquareOfDigits().getMax(arrayOf("1234567890")))
    System.out.println(SquareOfDigits().getMax(arrayOf("9785409507", "2055103694", "0861396761", "3073207669", "1233049493", "2300248968", "9769239548", "7984130001", "1670020095", "8894239889", "4053971072")))
}

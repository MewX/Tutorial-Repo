/**
 * Created by MewX on 8/23/2017.
 */

class ElevatorLimit {
    fun getRange(enter: IntArray, exit: IntArray, physicalLimit: Int): IntArray =
        // maxPeople, minPeople, currentPeople
        enter.indices.fold(mutableListOf(Int.MIN_VALUE, Int.MAX_VALUE, 0)) {
            save, i -> save.let { save[2] -= exit[i] }
                .let { save[1] = Math.min(save[1], save[2]) }
                .let { save[2] += enter[i] }
                .let { save[0] = Math.max(save[0], save[2]) }
                save
        }.let {
            // limitation on maxPeople and minPeople
            if (it[0] - it[1] > physicalLimit || -it[1] > physicalLimit) return IntArray(0)
            else return intArrayOf(-it[1], if (it[0] < 0) physicalLimit else physicalLimit - it[0])
        }
    }

fun out(arr: IntArray) {
    if (arr.isEmpty())
        println("()")
    else
        System.out.format("(%d, %d)\n", arr[0], arr[1])
}

fun main(args: Array<String>) {
    out(ElevatorLimit().getRange(intArrayOf(1, 0), intArrayOf(0, 1), 1))
    out(ElevatorLimit().getRange(intArrayOf(1, 0), intArrayOf(0, 1), 2))
    out(ElevatorLimit().getRange(intArrayOf(0, 1), intArrayOf(1, 0), 1))
    out(ElevatorLimit().getRange(intArrayOf(0, 2), intArrayOf(1, 0), 1))
    out(ElevatorLimit().getRange(intArrayOf(6, 85, 106, 1, 199, 76, 162, 141), intArrayOf(38, 68, 62, 83, 170, 12, 61, 114), 668))
    out(ElevatorLimit().getRange(intArrayOf(179, 135, 104, 90, 97, 186, 187, 47, 152, 100, 119, 28, 193, 11, 103, 100, 179, 11, 80, 163, 50, 131, 103, 50, 142, 51, 112, 62, 69, 72, 88, 3, 162, 93, 190, 85, 79, 86, 146, 71, 65, 131, 179, 119, 66, 111),
            intArrayOf(134, 81, 178, 168, 86, 128, 1, 165, 62, 46, 188, 70, 104, 111, 3, 47, 144, 69, 163, 21, 101, 126, 169, 84, 146, 165, 198, 1, 65, 181, 135, 99, 100, 195, 171, 47, 16, 54, 79, 69, 6, 97, 154, 80, 151, 76), 954))
    out(ElevatorLimit().getRange(intArrayOf(2), intArrayOf(3), 2))

    // maxPeople < 0 case
    out(ElevatorLimit().getRange(intArrayOf(295, 752, 84, 439, 607, 581), intArrayOf(558, 664, 644, 2, 564, 451), 948))
}

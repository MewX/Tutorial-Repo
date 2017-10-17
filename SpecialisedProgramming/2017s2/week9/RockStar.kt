
class RockStar {

    fun getNumSongs(ff: Int, fs: Int, sf: Int, ss: Int): Int =
            if (fs > 0 || ff > 0)
                ff + Math.min(fs, sf) * 2 + (if (fs > 0) ss else 0) + if (sf == Math.min(fs, sf) && fs > sf) 1 else 0
            else
                ss + (if (sf != 0) 1 else 0)

//    fun getNumSongs(ff: Int, fs: Int, sf: Int, ss: Int): Int {
//        // start from ff ff ff
//        var sum = ff
//        if (fs != 0) {
//            // add all pairs of "fs sf"
//            val com = Math.min(fs, sf)
//            sum += + com * 2 + ss
//
//            if (fs == com && sf == com) ; // do nothing
//            else if (fs == com) ; // do nothing
//            else if (sf == com) sum += 1
//        }
//        return if (sum == 0) ss + (if (sf != 0) 1 else 0) else sum
//    }
}

fun main(args: Array<String>) {
    println(RockStar().getNumSongs(100, 0, 0, 200))
    println(RockStar().getNumSongs(0, 0, 20, 200))
    println(RockStar().getNumSongs(1, 2, 1, 1))
    println(RockStar().getNumSongs(192, 279, 971, 249))
}

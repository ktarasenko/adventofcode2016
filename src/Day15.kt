object Day15 {

    fun findGoodTime(disks : Iterable<Triple<Int, Int, Int>>): Int {
        val topDisk = disks.first()
        var t = topDisk.third - topDisk.second - 1
        while (disks.any { !isFallingThrough(it, t) }){
            t += topDisk.third
        }

        return t
    }

    fun isFallingThrough(disk: Triple<Int, Int, Int>, time : Int): Boolean = (disk.first + disk.second + time) % disk.third == 0
}
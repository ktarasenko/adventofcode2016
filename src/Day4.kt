import java.util.regex.Pattern

object Day4 {

    fun countRoomCodes(list: Iterable<String>) : Int {
        return getRealRooms(list).sumBy { it.sectorId }
    }


    fun decryptRealRooms(list: Iterable<String>) {
        getRealRooms(list).forEach{ println(it.decrypt())}
    }

    fun getRealRooms(list: Iterable<String>): List<Room>{
        return list.flatMap {
            val room = Room(it)
            if (room.isRealRoom()){
                listOf(room)
            } else {
                listOf()
            }
        }
    }

    class Room(room: String){
        val split = room.split("-")
        val info = split.last()
        val sectorId = info.substring(0..2).toInt()
        val checksum = info.substring(4..info.length-2)
        val map = split.dropLast(1).flatMap{it.toList()}.groupingBy { it }
                .eachCount().toSortedMap().toList().sortedByDescending { it.second }



        fun isRealRoom() : Boolean{
            val countedSum =  map.take(5).map { it.first }.joinToString (separator = "")
//            print("${countedSum} - ${checksum}")
            return countedSum == checksum
        }


        fun decrypt() : String {
            return split.dropLast(1)
                    .map { it.toList()
                            .map { (((it.toInt() - 'a'.toInt()) + sectorId) % 26 + 'a'.toInt()).toChar() }.joinToString (separator = "" ) }
                    .joinToString(separator = " ") +  " " + sectorId
        }
    }

}
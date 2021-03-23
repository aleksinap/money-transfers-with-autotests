fun main() {
    val typeOfCard = "Maestro"
    val monthTransfers = 46_799_000
    val transfer = 350_000
    val commission = getCommission(typeOfCard, monthTransfers, transfer)
    println(commission)
}

fun getCommission(
    typeOfCard: String = "Vk Pay",
    monthTransfers: Int = 0,
    transfer: Int
): Int {
    return when (typeOfCard) {
        "Мир", "Visa" -> if (transfer * 0.0075 > 3_500.0) (transfer * 0.0075).toInt() else 3_500
        "MasterCard", "Maestro" -> if (monthTransfers <= 7_500_000) 0 else (transfer * 0.006 + 2_000).toInt()
        else -> 0
    }
}
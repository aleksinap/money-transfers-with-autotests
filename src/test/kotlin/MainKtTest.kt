import org.junit.Assert.*
import org.junit.Test

class MainKtTest{
    @Test
    fun getCommission_forMasterCardOrMaestroOwner_highMonthTransferLevel(){
        val typeOfCard = "Maestro"
        val monthTransfers = 46_799_000
        val transfer = 350_000
        val expected = 6_100

        val result = getCommission(
            typeOfCard = typeOfCard,
            monthTransfers = monthTransfers,
            transfer = transfer,
        )

        assertEquals(expected, result)
    }

    @Test
    fun getCommission_forVisaOwner(){
        val typeOfCard = "Visa"
        val monthTransfers = 46_799_000
        val transfer = 350_000
        val expected = 3_500

        val result = getCommission(
            typeOfCard = typeOfCard,
            monthTransfers = monthTransfers,
            transfer = transfer,
        )

        assertEquals(expected, result)
    }

    @Test
    fun getCommission_forVkPayOwner(){
        val transfer = 350_000
        val expected = 0

        val result = getCommission(
            transfer = transfer,
        )

        assertEquals(expected, result)
    }

    @Test
    fun getCommission_forMasterCardOrMaestroOwner_lowMonthTransferLevel(){
        val typeOfCard = "MasterCard"
        val monthTransfers = 6_799_000
        val transfer = 350_000
        val expected = 0

        val result = getCommission(
            typeOfCard = typeOfCard,
            monthTransfers = monthTransfers,
            transfer = transfer,
        )

        assertEquals(expected, result)
    }

    @Test
    fun getCommission_forMirOwner(){
        val typeOfCard = "Мир"
        val monthTransfers = 46_799_000
        val transfer = 1_000_000
        val expected = 7_500

        val result = getCommission(
            typeOfCard = typeOfCard,
            monthTransfers = monthTransfers,
            transfer = transfer,
        )

        assertEquals(expected, result)
    }
}
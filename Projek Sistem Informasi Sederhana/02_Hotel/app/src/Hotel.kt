// Class Hotel
class Hotel(val namaHotel: String, val lokasi: String, var kamarTersedia: Int) {
    fun tampilkanInfoHotel() {
        println("Hotel: $namaHotel, Lokasi: $lokasi, Kamar Tersedia: $kamarTersedia")
    }

    fun perbaruiKamarTersedia(jumlah: Int) {
        kamarTersedia -= jumlah
        println("Jumlah kamar tersedia sekarang: $kamarTersedia")
    }
}

// Class Kamar
class Kamar(val nomorKamar: Int, val tipeKamar: String, val hargaPerMalam: Double, var statusTersedia: Boolean) {
    fun tampilkanInfoKamar() {
        val status = if (statusTersedia) "Tersedia" else "Tidak Tersedia"
        println("Kamar Nomor: $nomorKamar, Tipe: $tipeKamar, Harga: $hargaPerMalam, Status: $status")
    }
}

// Class Tamu
class Tamu(val namaTamu: String, val email: String) {
    fun reservasiKamar(kamar: Kamar) {
        if (kamar.statusTersedia) {
            println("$namaTamu memesan kamar nomor ${kamar.nomorKamar}.")
            kamar.statusTersedia = false
        } else {
            println("Kamar sudah dipesan.")
        }
    }

    fun batalkanReservasi(kamar: Kamar) {
        println("$namaTamu membatalkan reservasi untuk kamar nomor ${kamar.nomorKamar}.")
        kamar.statusTersedia = true
    }
}

// Main Function
fun main() {
    val hotel = Hotel("Hotel Mewah", "Bandung", 10)
    val kamar101 = Kamar(101, "Suite", 1500000.0, true)
    val tamu = Tamu("Kinan", "kinan@example.com")

    // Menampilkan informasi hotel dan kamar
    hotel.tampilkanInfoHotel()
    kamar101.tampilkanInfoKamar()

    // Tamu melakukan reservasi kamar
    tamu.reservasiKamar(kamar101)

    // Memperbarui jumlah kamar tersedia
    hotel.perbaruiKamarTersedia(1)

    // Membatalkan reservasi
    tamu.batalkanReservasi(kamar101)

    // Memperbarui jumlah kamar setelah pembatalan
    hotel.perbaruiKamarTersedia(-1)
}

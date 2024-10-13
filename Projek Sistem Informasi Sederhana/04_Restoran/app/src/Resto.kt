// Class Restoran
class Restoran(val namaRestoran: String, val lokasi: String, var jumlahMeja: Int) {
    fun tampilkanInfoRestoran() {
        println("Restoran: $namaRestoran, Lokasi: $lokasi, Jumlah Meja Tersedia: $jumlahMeja")
    }

    fun perbaruiJumlahMeja(jumlah: Int) {
        jumlahMeja -= jumlah
        println("Jumlah meja tersedia sekarang: $jumlahMeja")
    }
}

// Class Meja
class Meja(val nomorMeja: Int, val kapasitas: Int, var statusTersedia: Boolean) {
    fun tampilkanInfoMeja() {
        val status = if (statusTersedia) "Tersedia" else "Tidak Tersedia"
        println("Meja Nomor: $nomorMeja, Kapasitas: $kapasitas, Status: $status")
    }
}

// Class Pelanggan
class Pelanggan(val namaPelanggan: String, val nomorTelepon: String) {
    fun reservasiMeja(meja: Meja) {
        if (meja.statusTersedia) {
            println("$namaPelanggan memesan meja nomor ${meja.nomorMeja}.")
            meja.statusTersedia = false
        } else {
            println("Meja sudah dipesan.")
        }
    }

    fun batalkanReservasi(meja: Meja) {
        println("$namaPelanggan membatalkan reservasi untuk meja nomor ${meja.nomorMeja}.")
        meja.statusTersedia = true
    }
}

// Main Function
fun main() {
    val restoran = Restoran("Restoran Lezat", "Jakarta", 10)
    val meja1 = Meja(1, 4, true)
    val pelanggan = Pelanggan("Kinan", "081234567890")

    // Menampilkan informasi restoran dan meja
    restoran.tampilkanInfoRestoran()
    meja1.tampilkanInfoMeja()

    // Pelanggan melakukan reservasi meja
    pelanggan.reservasiMeja(meja1)

    // Memperbarui jumlah meja yang tersedia
    restoran.perbaruiJumlahMeja(1)

    // Membatalkan reservasi
    pelanggan.batalkanReservasi(meja1)

    // Memperbarui jumlah meja setelah pembatalan
    restoran.perbaruiJumlahMeja(-1)
}

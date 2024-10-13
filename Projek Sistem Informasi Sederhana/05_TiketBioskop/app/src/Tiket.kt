// Class Film
class Film(
    val judul: String,
    val durasi: Int,
    val genre: String,
    val rating: Double
) {
    fun tampilkanInfoFilm() {
        println("Judul: $judul, Durasi: $durasi menit, Genre: $genre, Rating: $rating")
    }
}

// Class Kursi
class Kursi(val nomor: String, var status: Boolean) {
    fun cekKetersediaan(): Boolean {
        return status
    }

    fun pesanKursi() {
        if (status) {
            status = false
            println("Kursi $nomor berhasil dipesan.")
        } else {
            println("Kursi $nomor sudah dipesan.")
        }
    }
}

// Class Pembeli
class Pembeli(val nama: String, val email: String) {
    var kursiDipilih: Kursi? = null

    fun pilihKursi(kursi: Kursi) {
        if (kursi.cekKetersediaan()) {
            kursi.pesanKursi()
            kursiDipilih = kursi
            println("$nama memilih kursi nomor ${kursi.nomor}.")
        } else {
            println("Kursi tidak tersedia.")
        }
    }

    fun bayarTiket() {
        if (kursiDipilih != null) {
            println("Tiket untuk $nama sudah dibayar.")
        } else {
            println("Pilih kursi terlebih dahulu.")
        }
    }
}

// Implementasi di dalam program
fun main() {
    val film1 = Film("Avengers", 180, "Action", 8.5)
    film1.tampilkanInfoFilm()

    val kursiA1 = Kursi("A1", true)
    val kursiA2 = Kursi("A2", true)

    val pembeli1 = Pembeli("Kinan", "kinan@example.com")
    pembeli1.pilihKursi(kursiA1)
    pembeli1.bayarTiket()

    val pembeli2 = Pembeli("Kenan", "kenan@example.com")
    pembeli2.pilihKursi(kursiA1)  // Coba pesan kursi yang sudah dipesan
    pembeli2.pilihKursi(kursiA2)  // Pesan kursi yang tersedia
    pembeli2.bayarTiket()
}

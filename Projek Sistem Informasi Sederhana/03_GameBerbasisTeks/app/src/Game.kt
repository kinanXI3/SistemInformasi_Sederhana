// Class Pemain
class Pemain(val nama: String, var nyawa: Int, var kekuatan: Int) {
    fun serang(musuh: Musuh) {
        println("$nama menyerang ${musuh.nama} dengan kekuatan $kekuatan!")
        musuh.nyawa -= kekuatan
        if (musuh.nyawa <= 0) {
            println("${musuh.nama} telah dikalahkan!")
        } else {
            println("${musuh.nama} memiliki ${musuh.nyawa} nyawa tersisa.")
        }
    }

    fun tampilkanStatus() {
        println("Status Pemain: $nama - Nyawa: $nyawa, Kekuatan: $kekuatan")
    }
}

// Class Musuh
class Musuh(val nama: String, var nyawa: Int, var kekuatan: Int) {
    fun serang(pemain: Pemain) {
        println("$nama menyerang ${pemain.nama} dengan kekuatan $kekuatan!")
        pemain.nyawa -= kekuatan
        if (pemain.nyawa <= 0) {
            println("${pemain.nama} telah kalah dalam pertempuran!")
        } else {
            println("${pemain.nama} memiliki ${pemain.nyawa} nyawa tersisa.")
        }
    }

    fun tampilkanStatus() {
        println("Status Musuh: $nama - Nyawa: $nyawa, Kekuatan: $kekuatan")
    }
}

// Class Permainan
class Permainan(val pemain: Pemain, val musuh: Musuh) {
    fun mulaiPertarungan() {
        println("Pertarungan antara ${pemain.nama} dan ${musuh.nama} dimulai!")
        while (pemain.nyawa > 0 && musuh.nyawa > 0) {
            pemain.serang(musuh)
            if (musuh.nyawa > 0) {
                musuh.serang(pemain)
            }
            cekStatusPertarungan()
        }
    }

    fun cekStatusPertarungan() {
        pemain.tampilkanStatus()
        musuh.tampilkanStatus()
        if (pemain.nyawa <= 0) {
            println("${pemain.nama} kalah dalam permainan.")
        } else if (musuh.nyawa <= 0) {
            println("${musuh.nama} telah dikalahkan! ${pemain.nama} menang!")
        }
    }
}

// Main Function
fun main() {
    val pemain = Pemain("Kinan", 100, 20)
    val musuh = Musuh("Troll", 80, 15)
    
    val permainan = Permainan(pemain, musuh)
    permainan.mulaiPertarungan()
}

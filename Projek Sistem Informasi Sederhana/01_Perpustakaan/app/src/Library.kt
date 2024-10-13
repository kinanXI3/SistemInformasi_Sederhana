// Class Buku
class Buku (val judul: String, val penulis:String, var statusTersedia: Boolean) {
    fun tampilkanInfoBuku(){
        val status = if (statusTersedia) "Tersedia" else "Dipinjam"
        println("Buku: $judul, Penulis: $penulis, Status: $status")
    }
    fun perbaruiStatusTersedia(status: Boolean){
        statusTersedia = status
    }
}

//Class Anggota
class Anggota(val nama: String, val idAnggota: String){
    fun tampilkanInfoAnggota(){
        println("Anggota: $nama, ID Anggota: $idAnggota")
    }
}

//Class TransaksiPeminjaman
class TransaksiPeminjaman(val anggota: Anggota, val buku: Buku, val tanggalPinjam: String, 
var tanggalKembali: String? = null){
    fun tampilkanInfoTransaksi(){
        val statusPengembalian = if (tanggalKembali == null) "Belum Dikembalikan" else "Sudah Dikembalikan"
        println("Transaksi: ${anggota.nama} meminjam buku ${buku.judul} pada $tanggalPinjam, Status: $statusPengembalian")
    }
    fun kembalikanBuku(tanggalKembali: String){
        this.tanggalKembali = tanggalKembali
        buku.perbaruiStatusTersedia(true)
        println("Buku ${buku.judul} telah dikembalikan pada $tanggalKembali.")
    }
}

//Main Function
fun main(){
    //membuat objek buku dan anggota
    val buku1 = Buku("Pemrograman Kotlin", "Dewi Lestari", true)
    val anggota1 = Anggota("Kinan", "AG001")

    //menampilkan informasi buku dan anggota
    buku1.tampilkanInfoBuku()
    anggota1.tampilkanInfoAnggota()

    //membuat transaksi peminjaman
    val transaksi1 = TransaksiPeminjaman(anggota1, buku1, "02-10-2024")
    transaksi1.tampilkanInfoTransaksi()

    //mengubah status buku seteah dipinjam
    buku1.perbaruiStatusTersedia(false)
    buku1.tampilkanInfoBuku()

    //mengembalikan buku
    transaksi1.kembalikanBuku("10-10-2024")
    transaksi1.tampilkanInfoTransaksi()
}

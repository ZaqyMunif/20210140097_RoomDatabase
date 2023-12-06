package com.example.test.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.test.data.Siswa
import com.example.test.repositori.RepositoriSiswa

class EntryViewModel (private val repositoriSiswa: RepositoriSiswa): ViewModel(){

    /**
     * Berisi status Siswa Saat ini
     */
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa ): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
        fun updateUiState(detailSiswa: DetailSiswa) {
            uiStateSiswa =
                UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
        }

    /* FUngsi untuk Menyimpan data yang di-entry */
}
/**
 * Mewakili Stats Ui untuk siswa
 */
data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)
/* Mewakili Status UI untuk siswa*/
data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)
package com.putrapebrianonurba.equran.data.local.source

import com.putrapebrianonurba.equran.data.local.database.dao.QuranDao
import javax.inject.Inject

class QuranLocalDataSource @Inject constructor(
    private val local: QuranDao
) {

}
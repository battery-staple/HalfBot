package com.rohengiralt.halfbot.persistence.database

import com.uchuhimo.konf.Config
import com.uchuhimo.konf.ConfigSpec

internal val config = Config { addSpec(DatabaseSpec) }
    .from.env()

internal object DatabaseSpec : ConfigSpec() {
    val url by optional("jdbc:postgresql://database:5432/postgres")
    val username by required<String>()
    val password by required<String>()
}

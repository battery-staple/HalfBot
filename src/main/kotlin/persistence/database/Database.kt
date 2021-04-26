package persistence.database

import com.rohengiralt.halfbot.TestTable
import com.rohengiralt.halfbot.persistence.database.DatabaseSpec.password
import com.rohengiralt.halfbot.persistence.database.DatabaseSpec.url
import com.rohengiralt.halfbot.persistence.database.DatabaseSpec.username
import com.rohengiralt.halfbot.persistence.database.config
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun initDatabase() {
    println("Connecting to database at ${config[url]} with username ${config[username]} and password ${config[password]}")

    Database.connect(config[url], driver = "org.postgresql.Driver", user = config[username], password = config[password])
    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(TestTable)
    }
}
package com.rohengiralt.halfbot

import com.jessecorbett.diskord.api.model.Message
import com.jessecorbett.diskord.dsl.Bot
import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import com.rohengiralt.halfbot.secrets.SecretsSpec
import com.rohengiralt.halfbot.secrets.secrets
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import persistence.database.initDatabase

const val commandPrefix = "h!"

suspend fun main() {
    initDatabase()

    bot(secrets[SecretsSpec.token]) {
        commands("h!") {
            command("ping") {
                reply("pong!")
            }

            command("store") {
                val value = content.removePrefix("h!store").dropWhile(Char::isWhitespace)
                if (value.isEmpty()) {
                    reply("I don't understand—try giving me something to store.")
                    return@command
                }

                println(value)
                transaction {
                    addLogger(StdOutSqlLogger)
                    TestTable.insert {
                        it[text] = value.take(50)
                    }
                }
            }

            command("get") {
                var all: String = ""
                transaction {
                    addLogger(StdOutSqlLogger)
                    all = TestTable.selectAll().toString()
                }
                reply(all)
            }

            command("ping 1") {
                reply("ok")
            }
        }
    }
}

object TestTable : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val text: Column<String> = varchar("text", 50)
}
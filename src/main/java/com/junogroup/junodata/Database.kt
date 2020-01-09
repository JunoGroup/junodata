package com.junogroup.junodata

import android.content.Context
import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.KClassifier

/**
 * Opens a file database, compliant with Juno's protocol. Note that this does not create a new
 * database if the database doesn't already exist.
 *
 * @param ctx Context of the application
 *
 * @author Marko Vejnovic <marko.vejnovic@hotmail.com>
 *
 */
// TODO: Consider if model should be Class<Any>
class Database(ctx: Context, model: KClassifier) {
    companion object {
        private val DATABASE_NAME = BuildConfig.LIBRARY_PACKAGE_NAME
    }

    private val ctx = ctx
    private val model = model
    private val dbFile = File(ctx.filesDir.absolutePath + File.pathSeparator + DATABASE_NAME)

    init {
        if (!dbFile.exists()) {
            dbFile.createNewFile()
        }
    }
}
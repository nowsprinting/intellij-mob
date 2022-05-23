/*
 * Copyright 2020-2021 Koji Hasegawa. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package com.nowsprinting.intellij_mob.testdouble

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Condition
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.messages.MessageBus
import org.picocontainer.PicoContainer

internal open class DummyProject : Project {
    override fun isDisposed(): Boolean {
        throw Exception("Not yet implemented")
    }

    override fun getWorkspaceFile(): VirtualFile? {
        throw Exception("Not yet implemented")
    }

    override fun getProjectFilePath(): String? {
        throw Exception("Not yet implemented")
    }

    override fun getName(): String {
        throw Exception("Not yet implemented")
    }

    override fun <T : Any?> getComponent(interfaceClass: Class<T>): T {
        throw Exception("Not yet implemented")
    }

    override fun getBaseDir(): VirtualFile {
        throw Exception("Not yet implemented")
    }

    override fun <T : Any?> putUserData(key: Key<T>, value: T?) {
        throw Exception("Not yet implemented")
    }

    override fun isOpen(): Boolean {
        throw Exception("Not yet implemented")
    }

    override fun save() {
        throw Exception("Not yet implemented")
    }

    override fun getDisposed(): Condition<*> {
        throw Exception("Not yet implemented")
    }

    override fun getPicoContainer(): PicoContainer {
        throw Exception("Not yet implemented")
    }

    override fun getProjectFile(): VirtualFile? {
        throw Exception("Not yet implemented")
    }

    override fun <T : Any?> getUserData(key: Key<T>): T? {
        throw Exception("Not yet implemented")
    }

    override fun isInitialized(): Boolean {
        throw Exception("Not yet implemented")
    }

    override fun getMessageBus(): MessageBus {
        throw Exception("Not yet implemented")
    }

    override fun isDefault(): Boolean {
        throw Exception("Not yet implemented")
    }

    override fun getBasePath(): String? {
        throw Exception("Not yet implemented")
    }

    override fun getLocationHash(): String {
        throw Exception("Not yet implemented")
    }

    override fun dispose() {
        throw Exception("Not yet implemented")
    }
}
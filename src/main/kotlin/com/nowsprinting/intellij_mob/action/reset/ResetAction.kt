package com.nowsprinting.intellij_mob.action.reset

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.options.ShowSettingsUtil
import com.nowsprinting.intellij_mob.action.reset.ui.ResetDialog
import com.nowsprinting.intellij_mob.config.MobProjectSettings
import com.nowsprinting.intellij_mob.config.MobSettingsConfigurable
import com.nowsprinting.intellij_mob.git.GitRepositoryResult
import com.nowsprinting.intellij_mob.git.getGitRepository
import com.nowsprinting.intellij_mob.git.stayBranch
import com.nowsprinting.intellij_mob.util.notifyError

class ResetAction : AnAction() {

    override fun update(e: AnActionEvent) {
        super.update(e)

        val project = e.project ?: throw NullPointerException("AnActionEvent#getProject() was return null")
        val settings = MobProjectSettings.getInstance(project)
        val repository = when (val result = getGitRepository(project)) {
            is GitRepositoryResult.Success -> {
                result.repository
            }
            is GitRepositoryResult.Failure -> {
                notifyError(result.reason)
                return
            }
        }
        val enabled = repository.stayBranch(settings.wipBranch)
        e.presentation.isEnabled = enabled
    }

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: throw NullPointerException("AnActionEvent#getProject() was return null")
        val settings = MobProjectSettings.getInstance(project)
        FileDocumentManager.getInstance().saveAllDocuments()
        val (canExecute, reason) = checkResetPrecondition(settings, project)

        val dialog = ResetDialog()
        dialog.title = e.presentation.text.removeSuffix("...")
        dialog.setPreconditionResult(canExecute, reason)
        dialog.pack()
        dialog.setLocationRelativeTo(null) // set on screen center
        dialog.isVisible = true

        if (dialog.isOpenSettings) {
            ShowSettingsUtil.getInstance().showSettingsDialog(project, MobSettingsConfigurable::class.java)
        }

        if (dialog.isOk) {
            ResetTask(settings, project, dialog.title).queue()
        }
    }
}
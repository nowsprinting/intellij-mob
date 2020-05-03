package com.nowsprinting.intellij_mob.git

import com.nowsprinting.intellij_mob.config.MobProjectSettings
import git4idea.GitLocalBranch
import git4idea.repo.GitRepository

fun GitRepository.hasRemote(remoteName: String): Boolean {
    for (remote in this.remotes) {
        if (remoteName == remote.name) {
            return true
        }
    }
    return false
}

fun GitRepository.hasMobProgrammingBranch(settings: MobProjectSettings): Boolean {
    return hasLocalBranch(settings.wipBranch)
}

fun GitRepository.hasLocalBranch(branchName: String): Boolean {
    if (this.getLocalBranch(branchName) != null) {
        return true
    }
    return false
}

fun GitRepository.getLocalBranch(branchName: String): GitLocalBranch? {
    for (branch in this.branches.localBranches) {
        if (branch.name == branchName) {
            return branch
        }
    }
    return null
}

fun GitRepository.hasMobProgrammingBranchOrigin(settings: MobProjectSettings): Boolean {
    return hasRemoteBranch(settings.remoteName, settings.wipBranch)
}

fun GitRepository.hasRemoteBranch(remoteName: String, branchName: String): Boolean {
    val remoteBranchName = "${remoteName}/${branchName}"
    return hasRemoteBranch(remoteBranchName)
}

fun GitRepository.hasRemoteBranch(remoteBranchName: String): Boolean {
    for (branch in this.branches.remoteBranches) {
        if (branch.name == remoteBranchName) {
            return true
        }
    }
    return false
}

fun GitRepository.isMobProgramming(settings: MobProjectSettings): Boolean {
    return stayBranch(settings.wipBranch)
}

fun GitRepository.stayBranch(branchName: String): Boolean {
    if (this.currentBranchName == branchName) {
        return true
    }
    return false
}
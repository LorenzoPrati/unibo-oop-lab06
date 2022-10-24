# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
2. Ci si assicuri di avere localmente entrambi i branch remoti
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
8. Si faccia push del branch `master` sul proprio repository
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

[lore@hanamaru OOP-git-merge-conflict-test]$ git checkout -b feature origin/feature 
branch 'feature' set up to track 'origin/feature'.
Switched to a new branch 'feature'
[lore@hanamaru OOP-git-merge-conflict-test]$ git brnach
git: 'brnach' is not a git command. See 'git --help'.

The most similar command is
	branch
[lore@hanamaru OOP-git-merge-conflict-test]$ git branch
* feature
  master
[lore@hanamaru OOP-git-merge-conflict-test]$ git checkout master 
Switched to branch 'master'
Your branch is up to date with 'origin/master'.
[lore@hanamaru OOP-git-merge-conflict-test]$ git branch
  feature
* master
[lore@hanamaru OOP-git-merge-conflict-test]$ git merge feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.
[lore@hanamaru OOP-git-merge-conflict-test]$ ls
HelloWorld.java
[lore@hanamaru OOP-git-merge-conflict-test]$ gedit HelloWorld.java 
[lore@hanamaru OOP-git-merge-conflict-test]$ gedit HelloWorld.java 
[lore@hanamaru OOP-git-merge-conflict-test]$ code HelloWorld.java 
[lore@hanamaru OOP-git-merge-conflict-test]$ ls
HelloWorld.java
[lore@hanamaru OOP-git-merge-conflict-test]$ git status
On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")
[lore@hanamaru OOP-git-merge-conflict-test]$ git commit -m "Merge resolved"
U	HelloWorld.java
error: Committing is not possible because you have unmerged files.
hint: Fix them up in the work tree, and then use 'git add/rm <file>'
hint: as appropriate to mark resolution and make a commit.
fatal: Exiting because of an unresolved conflict.
[lore@hanamaru OOP-git-merge-conflict-test]$ git log --oneline
8e0f29c (HEAD -> master, origin/master, origin/HEAD) Change HelloWorld to print the number of available processors
d956df6 Create .gitignore
700ee0b Create HelloWorld
[lore@hanamaru OOP-git-merge-conflict-test]$ git status
On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")
[lore@hanamaru OOP-git-merge-conflict-test]$ git add HelloWorld.java 
[lore@hanamaru OOP-git-merge-conflict-test]$ git status
On branch master
Your branch is up to date with 'origin/master'.

All conflicts fixed but you are still merging.
  (use "git commit" to conclude merge)

Changes to be committed:
	modified:   HelloWorld.java

[lore@hanamaru OOP-git-merge-conflict-test]$ git commit -m 'Resolve conlift to print both processors and author'
[master 4754766] Resolve conlift to print both processors and author
[lore@hanamaru OOP-git-merge-conflict-test]$ git log --oneline
4754766 (HEAD -> master) Resolve conlift to print both processors and author
bed943f (origin/feature, feature) Print author information
8e0f29c (origin/master, origin/HEAD) Change HelloWorld to print the number of available processors
d956df6 Create .gitignore
700ee0b Create HelloWorld
[lore@hanamaru OOP-git-merge-conflict-test]$ git log --oneline --graph 
*   4754766 (HEAD -> master) Resolve conlift to print both processors and author
|\  
| * bed943f (origin/feature, feature) Print author information
* | 8e0f29c (origin/master, origin/HEAD) Change HelloWorld to print the number of available processors
|/  
* d956df6 Create .gitignore
* 700ee0b Create HelloWorld
[lore@hanamaru OOP-git-merge-conflict-test]$ git log 
commit 47547662d5151a787a870b9bd691e4d5f6da9e09 (HEAD -> master)
Merge: 8e0f29c bed943f
Author: Lorenzo Prati <lorenzo.prati3@studio.unibo.it>
Date:   Mon Oct 24 11:19:23 2022 +0200

    Resolve conlift to print both processors and author

commit bed943fbdd6ba94e64197448e4754a529d984e88 (origin/feature, feature)
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:21:22 2016 +0200

    Print author information

commit 8e0f29c12e060f3bdc62540343eff3e473616d61 (origin/master, origin/HEAD)
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:19:05 2016 +0200

    Change HelloWorld to print the number of available processors

commit d956df66aeb0829f23b7b3d0d9a1c002c390f87f
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:17:43 2016 +0200

[lore@hanamaru OOP-git-merge-conflict-test]$ git log --graph
*   commit 47547662d5151a787a870b9bd691e4d5f6da9e09 (HEAD -> master)
|\  Merge: 8e0f29c bed943f
| | Author: Lorenzo Prati <lorenzo.prati3@studio.unibo.it>
| | Date:   Mon Oct 24 11:19:23 2022 +0200
| | 
| |     Resolve conlift to print both processors and author
| | 
| * commit bed943fbdd6ba94e64197448e4754a529d984e88 (origin/feature, feature)
| | Author: Danilo Pianini <danilo.pianini@gmail.com>
| | Date:   Thu Oct 27 17:21:22 2016 +0200
| | 
| |     Print author information
| | 
* | commit 8e0f29c12e060f3bdc62540343eff3e473616d61 (origin/master, origin/HEAD)
|/  Author: Danilo Pianini <danilo.pianini@gmail.com>
|   Date:   Thu Oct 27 17:19:05 2016 +0200
|   
|       Change HelloWorld to print the number of available processors
| 
* commit d956df66aeb0829f23b7b3d0d9a1c002c390f87f
| Author: Danilo Pianini <danilo.pianini@gmail.com>
| Date:   Thu Oct 27 17:17:43 2016 +0200
| 
|     Create .gitignore
| 
* commit 700ee0b669f6cd75384abb9af51ca5c2adefe917
  Author: Danilo Pianini <danilo.pianini@gmail.com>
  Date:   Thu Oct 27 17:15:10 2016 +0200
  
      Create HelloWorld

[lore@hanamaru OOP-git-merge-conflict-test]$ git remote -v
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (push)
[lore@hanamaru OOP-git-merge-conflict-test]$ git remote add myprofilerepo
usage: git remote add [<options>] <name> <url>

    -f, --fetch           fetch the remote branches
    --tags                import all tags and associated objects when fetching
                          or do not fetch any tag at all (--no-tags)
    -t, --track <branch>  branch(es) to track
    -m, --master <branch>
                          master branch
    --mirror[=(push|fetch)]
                          set up remote as a mirror to push to or fetch from

[lore@hanamaru OOP-git-merge-conflict-test]$ git remote -v
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (push)
[lore@hanamaru OOP-git-merge-conflict-test]$ git remote add myprofilerepo git@github.com:LorenzoPrati/OOP-git-merge-conflict-test.git
[lore@hanamaru OOP-git-merge-conflict-test]$ git remote -v
myprofilerepo	git@github.com:LorenzoPrati/OOP-git-merge-conflict-test.git (fetch)
myprofilerepo	git@github.com:LorenzoPrati/OOP-git-merge-conflict-test.git (push)
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (push)
[lore@hanamaru OOP-git-merge-conflict-test]$ git branch 
  feature
* master
[lore@hanamaru OOP-git-merge-conflict-test]$ git push myprofilerepo master
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 8 threads
Compressing objects: 100% (11/11), done.
Writing objects: 100% (15/15), 1.58 KiB | 1.58 MiB/s, done.
Total 15 (delta 4), reused 10 (delta 2), pack-reused 0
remote: Resolving deltas: 100% (4/4), done.
To github.com:LorenzoPrati/OOP-git-merge-conflict-test.git
 * [new branch]      master -> master
[lore@hanamaru OOP-git-merge-conflict-test]$ git status
On branch master
Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean
[lore@hanamaru OOP-git-merge-conflict-test]$ git branch --set-upstream-to=myprofilerepo/master 
branch 'master' set up to track 'myprofilerepo/master'.

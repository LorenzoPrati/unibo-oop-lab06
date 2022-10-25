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

[lore@hanamaru OOP-git-merge-conflict-test]$ git checkout -b feature origin/feature 
branch 'feature' set up to track 'origin/feature'.
Switched to a new branch 'feature'

[lore@hanamaru OOP-git-merge-conflict-test]$ git branch
* feature
  master

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

[lore@hanamaru OOP-git-merge-conflict-test]$ git checkout master 
Switched to branch 'master'
Your branch is up to date with 'origin/master'.
[lore@hanamaru OOP-git-merge-conflict-test]$ git merge feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!
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

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

Fatte modifiche al file per stampare sia l'autore che il numero di processori

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

6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

[lore@hanamaru OOP-git-merge-conflict-test]$ git remote add myprofilerepo git@github.com:LorenzoPrati/OOP-git-merge-conflict-test.git
[lore@hanamaru OOP-git-merge-conflict-test]$ git remote -v
myprofilerepo	git@github.com:LorenzoPrati/OOP-git-merge-conflict-test.git (fetch)
myprofilerepo	git@github.com:LorenzoPrati/OOP-git-merge-conflict-test.git (push)
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin	git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (push)

8. Si faccia push del branch `master` sul proprio repository

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

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

[lore@hanamaru OOP-git-merge-conflict-test]$ git branch --set-upstream-to=myprofilerepo/master 
branch 'master' set up to track 'myprofilerepo/master'.


# D3TranslateApp
It's an Android app that translates stuff!

## Cloning this repository and importing into Android Studio
1. Open Android Studio and close out of any projects that might be open.
2. Click "import from version control" and click "GitHub."
3. If your GitHub information hasn't been added to Android Studio, add it.
4. Select this repository and clone it.
5. Android Studio will ask you if you want to import the project you just cloned. Click "no."
6. Go to "import Studio project" and navigate to the directory you just cloned.
7. Select the highest-level Android Studio project named "D3TranslateApp" and import it.

## Using Git
After you import your project, Android Studio is going to say something like "Unrecognized VCS root."
Click "Add root." That way any changes you make throughout the project are
going to be tracked by git.

Do not ever push directly to master. Think about the feature you want to
implement and go to the lower right hand corner of Android Studio where
it says "Git: master" and click "new branch." Name your branch something like
"quiz_implementation" and click "ok."

With every substantial change you make, go to VCS -> Commit Changes...
and add a useful commit message. Once you want to push your changes to
GitHub, you can do it on your final commit and click "commit and push"
after you write a commit message or you can go to VCS -> git -> push 
which will just push whatever staged commits you have.

Once you have a fully-implemented and working feature, open a pull
request on GitHub. If everything works and it can be merged, merge it
and delete the branch. If everything works but it can't be merged,
go to VCS -> git -> merge changes and merge with origin/master. 
_Carefully_ merge your changes, and then add a new commit once it's
done and push to your branch. Then merge with master on GitHub.
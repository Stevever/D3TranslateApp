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

## The Navigation Drawer
If you create a new activity (properly generated from Android Studio of
course) your app must extend the NavigationDrawerActivity if you 
want your activity have the navigation drawer. It should look like this:

`public class NewActivity extends NavigationDrawerActivity {`

By default Android activities call `setContentView()` but the
navigation drawer has an activity to deal with this called `addLayout()`.
Pass the same argument you'd pass into `setContentView()` into `addLayout()`.

## The UserPreferences class
`UserPreferences` is a singleton and houses the user's preferences.
The preferences it currently stores are the user's name and the
target language. Get these with the getter methods (to get the target
language as a string, just call it with `toString()`). It's a static
class so it doesn't need to be instanciated.

This class also has an enum called `Language` that contains all the
currently supported languages. You can use it like a normal enum. You
should never need to interact with this except when implementing the
user picking their language choice though.

## The Translator class
The `Translator` class is also a singleton and needs to be instanciated.
To call this, call `Translator.getInstance()` just to make sure that 
the target language is set. If it happens early in the app you probably
don't need to do it though.

## Dictionary Lookups and JSONResponseParser class
The dictionary lookup is done by using the Glosbe translation API 
(https://en.glosbe.com/a-api for info). The app sends to Glosbe 3 things,
all provided by the user: current language, destination language and the
phrase to lookup. The response is a `JSONObject` that contains the raw
translation data from Glosbe. The `DictionaryLookupActivity` is passed a
string representation of this . To actually get the translation data
from the String:

1. Create a `JSONObject` with the String representation
2. Create a `JSONResponseParser` object with this `JSONObject`
3. Get the necessary data from the JSONResponseParser by calling its public
methods (`getToLang()`, `getFromLang()`, `getPhrase()`, etc)

In the future, I will add a `verify()` method that makes sure a valid 
translation was found. This should help with error handling.

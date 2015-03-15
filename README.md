# com.example.goodreads
Sample Good Reads Eclipse plugin.

This plugin is a simple implementation of GoodReads service. (www.goodreads.com) <br>
It defines <br>
<li> 1. A simple model using EMF. Main entities are People, Friends, Books, Book shelf. See file model\goodreads.ecore for more details. <br>
<li> 2. A multi page editor with two pages Profile and Data base page. <br>
<li> 3. All the changes done in the editor are instantly updated in the file system. <br>
<li> 4. The plugin uses EMF generated classes to read/modify/save the model. See sources under generated package. <br>

<br>
Profile Page: <br>
<li> 1. Profile page allows to view the details of any of the readers available in Database. <br>
<li> 2. Allows to add/remove friends. <br>
<li> 3. Allows to add/remove books to book shelves. Each person has three book shelves by default. <br>

<br>
Database Page:<br>
<li> 1. Allows to add/delete new readers and books. <br>
<li> 2. A book can only be deleted if it is not prsent in any of bookshelves of the readers. <br>

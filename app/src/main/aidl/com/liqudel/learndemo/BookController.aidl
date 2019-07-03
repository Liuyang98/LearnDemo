// BookController.aidl
package com.liqudel.learndemo;

//import com.liqudel.learndemo.bean.Book;

interface BookController {

    List<String> getBookList();

    void addBookInOut( String book);

}
